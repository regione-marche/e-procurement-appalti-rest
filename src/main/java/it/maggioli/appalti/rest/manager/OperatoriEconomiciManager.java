package it.maggioli.appalti.rest.manager;

import java.time.Instant;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.dto.OperatoreEconomicoDto;
import it.maggioli.appalti.rest.dto.OperatoreEconomicoFilterDto;
import it.maggioli.appalti.rest.dto.OperatoreEconomicoWithRegistersDto;
import it.maggioli.appalti.rest.dto.PageDto;
import it.maggioli.appalti.rest.dto.TabulatoDto;
import it.maggioli.appalti.rest.entities.G1msflussi;
import it.maggioli.appalti.rest.entities.Impr;
import it.maggioli.appalti.rest.entities.TabTre;
import it.maggioli.appalti.rest.entities.Winvcom;
import it.maggioli.appalti.rest.entities.Wpuser;
import it.maggioli.appalti.rest.entities.identities.DitgPK;
import it.maggioli.appalti.rest.functions.TransformImprToOeDto;
import it.maggioli.appalti.rest.repositories.DitgRepository;
import it.maggioli.appalti.rest.repositories.G1msflussiRepository;
import it.maggioli.appalti.rest.repositories.ImprRepository;
import it.maggioli.appalti.rest.repositories.TabulatoTreRepository;
import it.maggioli.appalti.rest.repositories.TabulatoUnoRepository;
import it.maggioli.appalti.rest.repositories.WinvcomRepository;
import it.maggioli.appalti.rest.repositories.WpuserRepository;
import it.maggioli.appalti.rest.specifications.ImprSpecification;

/**
 * Questa classe gestisce le operazioni sugli operatori economici
 * 
 * @author gabriele.nencini
 *
 */
@Service
public class OperatoriEconomiciManager {

	private static final Logger logger = LoggerFactory.getLogger(OperatoriEconomiciManager.class);
	@Autowired
	private ImprRepository imRepository;
	@Autowired
	private WinvcomRepository wimRepository;
	@Autowired
	private WpuserRepository wpuserRepository;
	@Autowired
	private TabulatoTreRepository tab3Repository;
	@Autowired
	private TabulatoUnoRepository tab1Repository;
	@Autowired
	private DitgRepository ditgRepository;
	@Autowired
	private TransformImprToOeDto funcImprToOe;
	@Autowired
	private G1msflussiRepository g1msflussiRepository;
	@Autowired
	private WgenChiaviManager wcManager;

	@Transactional
	public List<OperatoreEconomicoDto> findOperatoriEconomici(Date dataAggiornamentoDaPortaleDa,
			Date dataAggiornamentoDaPortaleA, String codiceOe, String cfOe, String pivaOe, String denomOe) {
		Iterable<Impr> it = Collections.emptyList();
		if (dataAggiornamentoDaPortaleDa != null || dataAggiornamentoDaPortaleA != null) {
			logger.info("Ricerca con date");

			List<Winvcom> stWinvcom;
			if (dataAggiornamentoDaPortaleDa != null && dataAggiornamentoDaPortaleA != null)
				stWinvcom = wimRepository.findAllByComtipoAndComstatoAndComdatastatoBetweenOrderByComdatastatoAsc("FS5",
						"6", dataAggiornamentoDaPortaleDa, dataAggiornamentoDaPortaleA);
			else if (dataAggiornamentoDaPortaleDa != null)
				stWinvcom = wimRepository.findAllByComtipoAndComstatoAndComdatastatoAfterOrderByComdatastatoAsc("FS5",
						"6", dataAggiornamentoDaPortaleDa);
			else // Per esclusione: dataAggiornamentoDaPortaleA !=null; è sempre vera in questo
					// caso
				stWinvcom = wimRepository.findAllByComtipoAndComstatoAndComdatastatoBeforeOrderByComdatastatoAsc("FS5",
						"6", dataAggiornamentoDaPortaleA);

			if (logger.isDebugEnabled())
				stWinvcom.forEach(el -> logger.debug("w_invcom: {}", el));
			// 2. ricerca w_puser da w_invcom
			Map<String, Winvcom> mapOfWinvcomByComkey1 = stWinvcom.parallelStream()
					.collect(Collectors.toMap(Winvcom::getComkey1, Function.identity(), (o1, o2) -> o2));
			if (logger.isDebugEnabled())
				mapOfWinvcomByComkey1.forEach((key, value) -> logger.debug("{}: {}", key, value));
			Set<String> listaCodiceImprese = wpuserRepository.findByUsernomeIn(mapOfWinvcomByComkey1.keySet())
					.parallelStream().map(Wpuser::getUserkey1).collect(Collectors.toSet());
			// 3. prendi i dati da impr e presenta con data aggiornamento da w_invcom
			it = imRepository.findAll(ImprSpecification.getImprSpecification(dataAggiornamentoDaPortaleDa,
					dataAggiornamentoDaPortaleA, cfOe, pivaOe, denomOe, listaCodiceImprese));
		} else { // Questa condizione si verifica sempre se non si verifica quella sopra:
					// dataAggiornamentoDaPortaleDa == null && dataAggiornamentoDaPortaleA == null;
			logger.info("Ricerca senza date");
			Impr probe = new Impr();
			probe.setCodimp(codiceOe);
			probe.setCfimp(cfOe);
			probe.setPivimp(pivaOe);
			probe.setNomimp(denomOe);
			ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues().withMatcher("nomimp",
					GenericPropertyMatchers.contains().ignoreCase());
			Example<Impr> ex = Example.of(probe, matcher);
			it = imRepository.findAll(ex);
		}
		Map<String, String> mapProv = tab3Repository.findAllByIdCodice("Agx15")
				.filter(el -> !"1".equals(el.getArchiviato()))
				.collect(Collectors.toMap(el -> el.getId().getValore(), TabTre::getDescrizione, (el1, el2) -> el2));
		Map<Integer, String> mapNaz = tab1Repository.findDtoByCodiceFilteringArchOrderByOrdinamento("Ag010")
				.parallelStream().collect(Collectors.toMap(TabulatoDto::getId, TabulatoDto::getDescrizione));
		funcImprToOe.setMapProv(mapProv);
		funcImprToOe.setMapNaz(mapNaz);
		Set<Impr> sit = StreamSupport.stream(it.spliterator(), true).collect(Collectors.toSet());
		return sit.parallelStream().map(funcImprToOe::apply)
				.sorted(Comparator.comparing(OperatoreEconomicoDto::getCodice)).collect(Collectors.toList());
	}

	@Transactional
	public List<OperatoreEconomicoWithRegistersDto> getOperatoreEconomicoWithListOfRegisters(
			Optional<OperatoreEconomicoFilterDto> operatoreEconomicoFilterDto) {
		List<OperatoreEconomicoDto> listOfOe = Collections.emptyList();
		if (operatoreEconomicoFilterDto.isPresent()) {
			var filter = operatoreEconomicoFilterDto.get();
			logger.info("Invocato getOperatoreEconomicoWithListOfRegisters con {}", filter);
			listOfOe = this.findOperatoriEconomici(filter.getDataAggiornamentoDaPortaleDa(),
					filter.getDataAggiornamentoDaPortaleA(), filter.getCodiceOe(), filter.getCfOe(), filter.getPivaOe(),
					filter.getDenomOe());
		} else {
			logger.info("Invocato getOperatoreEconomicoWithListOfRegisters senza filtri");
			listOfOe = this.findOperatoriEconomici(null, null, null, null, null, null);
		}
		if (listOfOe.isEmpty())
			return Collections.emptyList();

		var oeCodiciList = listOfOe.parallelStream().map(OperatoreEconomicoDto::getCodice).collect(Collectors.toList());
		// now get ditg with join with garealbo to get the list of codici mapped with
		// datum

		var listOfDitgPKWithRegisters = ditgRepository.findForRegistry(oeCodiciList, Date.from(Instant.now()));
		final var mapOflistOfOeWithRegisters = listOfDitgPKWithRegisters.stream().collect(
				Collectors.groupingBy(DitgPK::getDittao, Collectors.mapping(DitgPK::getNgara5, Collectors.toList())));

		var listOfOeWithRegisters = listOfOe.parallelStream().map(el -> {
			var result = new OperatoreEconomicoWithRegistersDto();
			BeanUtils.copyProperties(el, result);
			result.setRegisters(mapOflistOfOeWithRegisters.get(el.getCodice()));
			return result;
		}).collect(Collectors.toList());

		return listOfOeWithRegisters;
	}

	@Transactional
	public ResponseEntity<OperatoreEconomicoWithRegistersDto> updateImpr(
			OperatoreEconomicoWithRegistersDto operatoreEconomicoDto) {
		try {
			logger.info("Invocato updateImpr con {}", operatoreEconomicoDto);
			if (StringUtils.isBlank(operatoreEconomicoDto.getCodice())) {
				logger.info("Invocato updateImpr con codice null");
				return ResponseEntity.badRequest().build();
			}
			if (StringUtils.isBlank(operatoreEconomicoDto.getCodiceForniotreEsterno())) {
				logger.info("Invocato updateImpr con CodiceForniotreEsterno null");
				return ResponseEntity.badRequest().build();
			}

			Impr probe = new Impr();
			probe.setCodimp(operatoreEconomicoDto.getCodice());		
			ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues();
			Example<Impr> ex = Example.of(probe, matcher);

			Optional<Impr> opimpr = imRepository.findOne(ex);
			if (opimpr.isEmpty()) {
				logger.info("Non trovata IMPR con Codimp:{} e Cgenimp:{}", operatoreEconomicoDto.getCodice(),
						operatoreEconomicoDto.getCodiceForniotreEsterno());
				return ResponseEntity.notFound().build();
			}

			Impr impr = opimpr.get();
			impr.setDgenimp(Date.from(Instant.now()));
			impr.setCgenimp(operatoreEconomicoDto.getCodiceForniotreEsterno());
			imRepository.save(impr);
			
			G1msflussi flusso = new G1msflussi();
			Long id = wcManager.getNextId("G1MSFLUSSI");
			flusso.setId(id);
			flusso.setEntita("IMPR");
			flusso.setChiave_int(operatoreEconomicoDto.getCodice());
			flusso.setChiave_ext(operatoreEconomicoDto.getCodiceForniotreEsterno());
			flusso.setFonte("SACE");
			flusso.setTipo_flusso(2L);
			flusso.setData_richiesta(new Date());
			flusso.setStato(1L);						
			g1msflussiRepository.save(flusso);
						
			return ResponseEntity.ok(operatoreEconomicoDto);
		} catch (Exception e) {
			logger.error("Errore in updateImpr", e);
			return ResponseEntity.internalServerError().build();
		}
	}
}
