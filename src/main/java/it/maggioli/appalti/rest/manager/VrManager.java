package it.maggioli.appalti.rest.manager;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.dto.VrDittaDto;
import it.maggioli.appalti.rest.dto.VrIpcDittaValoreDto;
import it.maggioli.appalti.rest.dto.VrIpcDittaValoriDto;
import it.maggioli.appalti.rest.dto.VrPubblicazioneImpresaDto;
import it.maggioli.appalti.rest.dto.VrPubblicazioneImpreseDto;
import it.maggioli.appalti.rest.dto.VrPubblicazioneResultDto;
import it.maggioli.appalti.rest.entities.Impr;
import it.maggioli.appalti.rest.entities.Imprvr;
import it.maggioli.appalti.rest.entities.VrWInvcom;
import it.maggioli.appalti.rest.entities.VrWInvcomdes;
import it.maggioli.appalti.rest.entities.Wlogeventi;
import it.maggioli.appalti.rest.entities.identities.VrWInvcomPK;
import it.maggioli.appalti.rest.entities.identities.VrWInvcomdesPK;
import it.maggioli.appalti.rest.manager.appalti.AppaltiRestClientManager;
import it.maggioli.appalti.rest.repositories.ImprRepository;
import it.maggioli.appalti.rest.repositories.ImprvrRepository;
import it.maggioli.appalti.rest.repositories.VrRepository;
import it.maggioli.appalti.rest.repositories.VrWinvcomRepository;
import it.maggioli.appalti.rest.repositories.VrWinvcomdesRepository;

/**
 * Servizio per la gestione delle richieste per il programma VR (Vendor Rating)
 * 
 * @author marco.pravato
 *
 */
@Service
public class VrManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(VrManager.class);

	@Autowired
	private VrRepository vrRepository;

	@Autowired
	private AppaltiRestClientManager appaltiRestClientManager;

	@Autowired
	private WgenChiaviManager wcManager;
	@Autowired
	private WlogEventiManager wleManager;

	@Autowired
	private ImprvrRepository imprvrRepository;
	@Autowired
	private VrWinvcomRepository vrWinvcomRepository;
	@Autowired
	private VrWinvcomdesRepository vrWinvcomdesRepository;
	@Autowired
	private ImprRepository imprRepository;

	public Optional<List<VrDittaDto>> getListaDitte(String ngara) {
		List<VrDittaDto> items = vrRepository.findListaDitte(ngara);

		// Fix field "PIVA"
		for (VrDittaDto item : items) {
			item.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
		}

		return Optional.of(items);
	}

	public Optional<List<VrIpcDittaValoriDto>> getDatiImportIcp(String ngara, String datastart, String dataend) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date dateStart = sdf.parse(datastart);
			Date dateEnd = sdf.parse(dataend);

			// Group results by PIVA, use an Hashmap so it's easier to group by
			List<VrIpcDittaValoreDto> roInviti = vrRepository.findIpcRoInviti(ngara, dateStart, dateEnd);
			HashMap<String, VrIpcDittaValoriDto> resultsMap = new HashMap<String, VrIpcDittaValoriDto>();
			for (VrIpcDittaValoreDto item : roInviti) {
				if (item.getPivimp() == null || item.getPivimp().length() == 0)
					continue;
				if (resultsMap.containsKey(item.getPivimp()))
					resultsMap.get(item.getPivimp()).setCountRoInviti(item.getCountGare());
				else {
					VrIpcDittaValoriDto dto = new VrIpcDittaValoriDto();
					dto.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
					dto.setCountRoInviti(item.getCountGare());
					resultsMap.put(item.getPivimp(), dto);
				}
			}

			List<VrIpcDittaValoreDto> roInvitiRM = vrRepository.findIpcRoInvitiRicercaMercato(dateStart, dateEnd);
			for (VrIpcDittaValoreDto item : roInvitiRM) {
				if (item.getPivimp() == null || item.getPivimp().length() == 0)
					continue;
				if (resultsMap.containsKey(item.getPivimp()))
					resultsMap.get(item.getPivimp()).setCountRoInvitiRicercaMercato(item.getCountGare());
				else {
					VrIpcDittaValoriDto dto = new VrIpcDittaValoriDto();
					dto.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
					dto.setCountRoInvitiRicercaMercato(item.getCountGare());
					resultsMap.put(item.getPivimp(), dto);
				}
			}

			List<VrIpcDittaValoreDto> roOfferte = vrRepository.findIpcRoOfferte(ngara, dateStart, dateEnd);
			for (VrIpcDittaValoreDto item : roOfferte) {
				if (item.getPivimp() == null || item.getPivimp().length() == 0)
					continue;
				if (resultsMap.containsKey(item.getPivimp()))
					resultsMap.get(item.getPivimp()).setCountRoOfferte(item.getCountGare());
				else {
					VrIpcDittaValoriDto dto = new VrIpcDittaValoriDto();
					dto.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
					dto.setCountRoOfferte(item.getCountGare());
					resultsMap.put(item.getPivimp(), dto);
				}
			}

			List<VrIpcDittaValoreDto> roOfferteRM = vrRepository.findIpcRoOfferteRicercaMercato(dateStart, dateEnd);
			for (VrIpcDittaValoreDto item : roOfferteRM) {
				if (item.getPivimp() == null || item.getPivimp().length() == 0)
					continue;
				if (resultsMap.containsKey(item.getPivimp()))
					resultsMap.get(item.getPivimp()).setCountRoOfferteRicercaMercato(item.getCountGare());
				else {
					VrIpcDittaValoriDto dto = new VrIpcDittaValoriDto();
					dto.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
					dto.setCountRoOfferteRicercaMercato(item.getCountGare());
					resultsMap.put(item.getPivimp(), dto);
				}
			}

			List<VrIpcDittaValoreDto> gaPartecipazioniMultiLotto = vrRepository.findIpcGaPartecipazioniMultiLotto(ngara, dateStart, dateEnd);
			for (VrIpcDittaValoreDto item : gaPartecipazioniMultiLotto) {
				if (item.getPivimp() == null || item.getPivimp().length() == 0)
					continue;
				if (resultsMap.containsKey(item.getPivimp()))
					resultsMap.get(item.getPivimp()).setCountGaPartecipazioniMultiLotto(item.getCountGare());
				else {
					VrIpcDittaValoriDto dto = new VrIpcDittaValoriDto();
					dto.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
					dto.setCountGaPartecipazioniMultiLotto(item.getCountGare());
					resultsMap.put(item.getPivimp(), dto);
				}
			}

			List<VrIpcDittaValoreDto> gaPartecipazioniSingoloLotto = vrRepository.findIpcGaPartecipazioniSingoloLotto(ngara, dateStart, dateEnd);
			for (VrIpcDittaValoreDto item : gaPartecipazioniSingoloLotto) {
				if (item.getPivimp() == null || item.getPivimp().length() == 0)
					continue;
				if (resultsMap.containsKey(item.getPivimp()))
					resultsMap.get(item.getPivimp()).setCountGaPartecipazioniSingoloLotto(item.getCountGare());
				else {
					VrIpcDittaValoriDto dto = new VrIpcDittaValoriDto();
					dto.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
					dto.setCountGaPartecipazioniSingoloLotto(item.getCountGare());
					resultsMap.put(item.getPivimp(), dto);
				}
			}

			List<VrIpcDittaValoreDto> gaPartecipazioniRicercaMercato = vrRepository.findIpcGaPartecipazioniRicercaMercato(dateStart, dateEnd);
			for (VrIpcDittaValoreDto item : gaPartecipazioniRicercaMercato) {
				if (item.getPivimp() == null || item.getPivimp().length() == 0)
					continue;
				if (resultsMap.containsKey(item.getPivimp()))
					resultsMap.get(item.getPivimp()).setCountGaPartecipazioniRicercaMercato(item.getCountGare());
				else {
					VrIpcDittaValoriDto dto = new VrIpcDittaValoriDto();
					dto.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
					dto.setCountGaPartecipazioniRicercaMercato(item.getCountGare());
					resultsMap.put(item.getPivimp(), dto);
				}
			}

			List<VrIpcDittaValoreDto> gaAggiudicazioni = vrRepository.findIpcGaAggiudicazioni(ngara, dateStart, dateEnd);
			for (VrIpcDittaValoreDto item : gaAggiudicazioni) {
				if (item.getPivimp() == null || item.getPivimp().length() == 0)
					continue;
				if (resultsMap.containsKey(item.getPivimp()))
					resultsMap.get(item.getPivimp()).setCountGaAggiudicazioni(item.getCountGare());
				else {
					VrIpcDittaValoriDto dto = new VrIpcDittaValoriDto();
					dto.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
					dto.setCountGaAggiudicazioni(item.getCountGare());
					resultsMap.put(item.getPivimp(), dto);
				}
			}

			List<VrIpcDittaValoreDto> gaAggiudicazioniRicercaMercato = vrRepository.findIpcGaAggiudicazioniRicercaMercato(dateStart, dateEnd);
			for (VrIpcDittaValoreDto item : gaAggiudicazioniRicercaMercato) {
				if (item.getPivimp() == null || item.getPivimp().length() == 0)
					continue;
				if (resultsMap.containsKey(item.getPivimp()))
					resultsMap.get(item.getPivimp()).setCountGaAggiudicazioniRicercaMercato(item.getCountGare());
				else {
					VrIpcDittaValoriDto dto = new VrIpcDittaValoriDto();
					dto.setPivimp(preparePivimp(item.getPivimp(), item.getCodnazione()));
					dto.setCountGaAggiudicazioniRicercaMercato(item.getCountGare());
					resultsMap.put(item.getPivimp(), dto);
				}
			}

			// Convert to list and return
			List<VrIpcDittaValoriDto> results = new ArrayList<VrIpcDittaValoriDto>(resultsMap.values());
			return Optional.of(results);
		} catch (ParseException ex) {
			logger.error("Error extracing dati import data", ex);
		}

		return null;
	}

	private String preparePivimp(String pivimp, String codnazione) {
		if(StringUtils.isNotBlank(pivimp)) {
			if(StringUtils.isNotBlank(codnazione)) {
				if (!pivimp.toLowerCase().startsWith(codnazione.toLowerCase())) {
					return codnazione + pivimp;
				}				
			} else {
				codnazione = "IT";
				if (!pivimp.toLowerCase().startsWith(codnazione.toLowerCase())) {
					return codnazione + pivimp;
				}				
			}
		}
		return pivimp;
	}

	@Transactional
	public VrPubblicazioneResultDto pubblicaIvr(VrPubblicazioneImpreseDto pubblicazioneParams, Long syscon, String ipAdress) {
		VrPubblicazioneResultDto result = new VrPubblicazioneResultDto();

		try {
			ArrayList<VrPubblicazioneImpresaDto> imprese = pubblicazioneParams.getImprese();

			ArrayList<Imprvr> imprvrs = new ArrayList<Imprvr>();
			ArrayList<VrWInvcom> winvcoms = new ArrayList<VrWInvcom>();
			ArrayList<VrWInvcomdes> winvcomdess = new ArrayList<VrWInvcomdes>();

			// Load sequences
			Long idImprVr = wcManager.getNextId("IMPRVR");
			Long idCom = vrWinvcomRepository.getMaxIdCom();
			if (idCom == null) {
				idCom = Long.valueOf(1);
			} else {
				idCom++;
			}

			for (VrPubblicazioneImpresaDto impresa : imprese) {

				// Extract data from IMPR
				Impr impr = imprRepository.findEmailsById(impresa.getCodImp());

				// Prepare data for IMPRVR
				Imprvr imprvr = new Imprvr();
				imprvr.setId(idImprVr.longValue());
				imprvr.setIdcalcolo(impresa.getIdCalcolo());
				imprvr.setIdcalcolorow(impresa.getIdCalcoloRow());
				imprvr.setCodimp(impresa.getCodImp());
				imprvr.setElencoe(impresa.getElencoe());
				imprvr.setDataInserimento(new Timestamp(System.currentTimeMillis()));
				imprvr.setIvr(impresa.getIvr());
				imprvr.setIvrDataInizio(impresa.getIvrDataInizio());
				imprvr.setIvrDataFine(impresa.getIvrDataFine());
				imprvr.setSospensioneMesi(impresa.getSospensioneMesi());
				imprvr.setSospensioneDataInizio(impresa.getSospensioneDataInizio());
				imprvr.setSospensioneDataFine(impresa.getSospensioneDataFine());
				imprvr.setSospensioneRevocata(impresa.getSospensioneRevocata());
				imprvrs.add(imprvr);

				// Prepare data for W_INVCOM
				VrWInvcom winvcom = new VrWInvcom();
				VrWInvcomPK invComPk = new VrWInvcomPK();
				invComPk.setIdprg("PG");
				invComPk.setIdcom(idCom);
				winvcom.setId(invComPk);
				winvcom.setComent("IMPRVR");
				winvcom.setComkey1(String.valueOf(imprvr.getId()));
				winvcom.setComdatins(new Timestamp(System.currentTimeMillis()));
				winvcom.setCommitt("APPALTI-VR");
				winvcom.setComstato("2");
				winvcom.setCommsgogg(impresa.getEmailOggetto());
				winvcom.setCommsgtes(impresa.getEmailTesto());
				winvcom.setCommsgtip("2");
				winvcom.setCompub(new BigDecimal(2));
				winvcom.setIdcfg("STD");
				winvcoms.add(winvcom);

				// Prepare data for W_INVCOMDES
				VrWInvcomdes winvcomdes = new VrWInvcomdes();
				VrWInvcomdesPK pkDes = new VrWInvcomdesPK();
				pkDes.setIdprg(invComPk.getIdprg());
				pkDes.setIdcom(invComPk.getIdcom());
				pkDes.setIdcomdes(1);

				winvcomdes.setId(pkDes);
				if (impr.getEmai2ip() != null && impr.getEmai2ip().trim().length() > 0) {
					winvcomdes.setDesmail(impr.getEmai2ip());
					winvcomdes.setComtipma(new BigDecimal(2));
				} else {
					winvcomdes.setDesmail(impr.getEmaiip());
					winvcomdes.setComtipma(new BigDecimal(1));
				}
				winvcomdess.add(winvcomdes);

				idImprVr++;
				idCom++;
			}

			// Save all data
			imprvrRepository.saveAll(imprvrs);
			vrWinvcomRepository.saveAll(winvcoms);
			vrWinvcomdesRepository.saveAll(winvcomdess);

			// Inserimento in log eventi
			Wlogeventi evento = new Wlogeventi();
			evento.setCod_profilo(null);
			evento.setCodapp("VR");
			evento.setLivevento(1);
			evento.setIpevento(ipAdress);
			evento.setSyscon(syscon);
			evento.setOggevento(pubblicazioneParams.getCalcPeriodDesc());
			evento.setCodevento("VR_PUBBLICAZIONE");
			evento.setDescr("Pubblicato calcolo VR per il trimestre " + pubblicazioneParams.getCalcPeriodDesc());

			wleManager.saveWlogEventi(evento);

			result.setEsito(true);

		} catch (Exception ex) {
			logger.error("Error in pubblica Ivr", ex);
			result.setEsito(false);
			result.setErrorData(ex.getMessage());
		}
		return result;
	}
}
