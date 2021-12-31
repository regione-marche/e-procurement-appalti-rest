package it.maggioli.appalti.rest.versions.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import it.maggioli.appalti.rest.dto.AdempimentoAnticorruzioneDto;
import it.maggioli.appalti.rest.dto.AvvisoTestataDto;
import it.maggioli.appalti.rest.dto.BandoDocumentoDto;
import it.maggioli.appalti.rest.dto.BandoTestataDto;
import it.maggioli.appalti.rest.dto.ComunicazioneDto;
import it.maggioli.appalti.rest.dto.DatiGeneraliAvvisoDto;
import it.maggioli.appalti.rest.dto.DatiGeneraliDto;
import it.maggioli.appalti.rest.dto.DettaglioDto;
import it.maggioli.appalti.rest.dto.EsitoTestataDto;
import it.maggioli.appalti.rest.dto.FileDto;
import it.maggioli.appalti.rest.dto.GaraAntiCorruzioneDto;
import it.maggioli.appalti.rest.dto.JwtResponse;
import it.maggioli.appalti.rest.dto.PageDto;
import it.maggioli.appalti.rest.dto.TabulatoDto;
import it.maggioli.appalti.rest.dto.TraspContrattoDettaglioDto;
import it.maggioli.appalti.rest.dto.TraspContrattoDto;
import it.maggioli.appalti.rest.dto.TraspContrattoEstesoDto;
import it.maggioli.appalti.rest.entities.Wlogeventi;
import it.maggioli.appalti.rest.entities.views.ws.Bando;
import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltante;
import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltanteL190;
import it.maggioli.appalti.rest.enums.StatoInCorsoScadutoEnum;
import it.maggioli.appalti.rest.enums.TabulatiEnum;
import it.maggioli.appalti.rest.functions.TransformBandoToBandoTestataDto;
import it.maggioli.appalti.rest.manager.AuthenticationManager;
import it.maggioli.appalti.rest.manager.AvvisoManager;
import it.maggioli.appalti.rest.manager.BandoManager;
import it.maggioli.appalti.rest.manager.EsitoManager;
import it.maggioli.appalti.rest.manager.L190Manager;
import it.maggioli.appalti.rest.manager.TraspManager;
import it.maggioli.appalti.rest.manager.WlogEventiManager;
import it.maggioli.appalti.rest.repositories.TabulatoUnoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.BandoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.StazioneAppaltanteRepository;
import it.maggioli.appalti.rest.specifications.BandoSpecification;

@Api(tags = {"v1.0" })
@RestController
@RequestMapping("v1.0")
public class WsAppaltiControllerV10 {

  private final Logger                 logger = LoggerFactory.getLogger(WsAppaltiControllerV10.class);

  @Autowired
  private StazioneAppaltanteRepository saRepository;

  @Autowired
  private BandoRepository              baRepository;

  @Autowired
  private TabulatoUnoRepository        tabUnoRepository;

  @Autowired
  private BandoManager                 bandoManager;
  @Autowired
  private EsitoManager                 esitoManager;
  @Autowired
  private AvvisoManager                avManager;
  @Autowired
  private AuthenticationManager                authManager;
  @Autowired
  private L190Manager                l190Manager;
  @Autowired
  private TraspManager                tManager;
  @Autowired
  private WlogEventiManager wleManager;

  @ApiOperation(value = "Restituisce l'elenco dei Bandi di Gara in pagine.", 
      produces = MediaType.APPLICATION_JSON_VALUE, nickname = "getElencoBandi"
      ,response = PageDto.class,responseReference = "PageDto<BandoTestataDto>")
  @GetMapping(path = "/getElencoBandi/{page}/{pageSize}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PageDto<BandoTestataDto>> getElencoBandi(
      @ApiParam(allowableValues = "range[1,infinity]", example = "1", value = "Numero della pagina che deve essere restituita.",required = true) @PathVariable int page,
      @ApiParam(allowableValues = "range[1,infinity]", example = "100", value = "Massimo numero di elementi che devono essere restituiti nella pagina.",required = true) @PathVariable int pageSize,
      @ApiParam(value = "Codice della stazione appaltante per cui filtrare l'elenco dei Bandi di Gara") @RequestParam(required = false) String stazioneAppaltante,
      @ApiParam(value = "Titolo o porzione di esso per cui filtrare l'elenco dei Bandi di Gara") @RequestParam(required = false) String titolo,
      @ApiParam(value = "CIG per cui filtrare l'elenco dei Bandi di Gara") @RequestParam(required = false) String cig,
      @ApiParam(value = "Codice della stazione appaltante per cui filtrare l'elenco dei Bandi di Gara", allowableValues = "range[1,infinity]") @RequestParam(required = false) Integer tipoAppalto,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Bandi di Gara con data pubblicazione dal") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPubblicazioneDa,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Bandi di Gara con data pubblicazione fino al") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPubblicazioneA,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Bandi di Gara con data di scadenza dal") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataScadenzaDa,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Bandi di Gara con data di scadenza fino al") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataScadenzaA,
      @ApiParam(value = "Filtro dei Bandi di Gara per somma urgenza") @RequestParam(required = false) Boolean sommaUrgenza,
      @ApiParam(value = "Filtro dei Bandi di Gara scaduti o in corso", defaultValue = "INCORSO") @RequestParam(required = true) StatoInCorsoScadutoEnum statoInCorsoScaduto,
      @ApiParam(value = "Filtro dei Bandi di Gara pubblicati negli ultimi N anni" ,defaultValue = "6") @RequestParam(defaultValue = "6") Integer numAnniPubblicazione,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Bandi di Gara con data di ultima modifica dal") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataUltimaModificaDA, 
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Bandi di Gara con data di ultima modifica fino al") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataUltimaModificaA) {
    PageRequest pageRequest = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);

    GregorianCalendar dataMinimaPubblicazione = new GregorianCalendar();
    Integer annoMinimoPubblicazione = dataMinimaPubblicazione.get(Calendar.YEAR) - numAnniPubblicazione;

    Page<Bando> pageBa = baRepository.findAll(
        BandoSpecification.getBandoSpecification(stazioneAppaltante, titolo, cig, tipoAppalto, dataPubblicazioneDa, dataPubblicazioneA,
            dataScadenzaDa, dataScadenzaA, null, null, null, sommaUrgenza, statoInCorsoScaduto, annoMinimoPubblicazione,dataUltimaModificaDA, dataUltimaModificaA),
        pageRequest);

    PageDto<BandoTestataDto> pageDto = new PageDto<BandoTestataDto>();
    BeanUtils.copyProperties(pageBa, pageDto,"content");
    TransformBandoToBandoTestataDto function = new TransformBandoToBandoTestataDto();
    pageDto.setContent(pageBa.getContent().stream().map(function::apply).collect(Collectors.toList()));
    return ResponseEntity.of(Optional.ofNullable(pageDto));
  }

  @ApiOperation(value = "Restituisce l'elenco delle stazioni appaltanti")
  @GetMapping(path = "/getElencoStazioniAppaltanti", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<StazioneAppaltante>> getElencoStazioniAppaltanti() {
    List<StazioneAppaltante> saList = saRepository.findAll();
    return ResponseEntity.of(Optional.ofNullable(saList));
  }

  /**
   * Tipologia Appalto
   * 
   * @return
   */
  @ApiOperation(value = "Restituisce le tipologie di appalto")
  @GetMapping(path = "/getTipologiaAppalto", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TabulatoDto>> getTipologiaAppalto() {
    List<TabulatoDto> tab1List = tabUnoRepository.findDtoByCodiceFilteringArchOrderByOrdinamento(TabulatiEnum.A1007.name());
    logger.debug("Tabulati.A1007.name(): {}", TabulatiEnum.A1007.name());
    return ResponseEntity.of(Optional.ofNullable(tab1List));
  }

  /**
   * Dettaglio Bando
   * 
   * @return
   */
  @ApiOperation(value = "Restituisce il dettaglio del Bando")
  @GetMapping(path = "/getDettaglioBando/{riferimentoProcedura}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DettaglioDto<DatiGeneraliDto, BandoDocumentoDto, ComunicazioneDto>> getDettaglioBando(
      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable String riferimentoProcedura) {
    return ResponseEntity.of(bandoManager.getBandoDettaglio(riferimentoProcedura));
  }

  /**
   * Download documento da comunicazione
   * 
   * @return
   */
  @ApiOperation(value = "Restituisce il file allegato alla comunicazione")
  @GetMapping(path = "/getDocumentoDaComunicazione/{idcomunicazione}/{iddocumento}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FileDto> getDocumentoDaComunicazione(
      @ApiParam(value = "Identificativo della comunicazione",required = true) @PathVariable(required = true) Long idcomunicazione,
      @ApiParam(value = "Identificativo del documento",required = true) @PathVariable(required = true) Long iddocumento,
      @ApiParam(value = "Nome del file del documento",required = true) @RequestParam(required = true) String nomefile) {
    return ResponseEntity.of(bandoManager.downloadFileDaComunicazione(idcomunicazione, iddocumento, nomefile));
  }

  /**
   * Download documento da documenti gara
   * 
   * @return
   */
  @ApiOperation(value = "Restituisce il file allegato al Bando di Gara")
  @GetMapping(path = "/getDocumentoDaBando/{iddocumento}/{proceduraRiferimento}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FileDto> getDocumentoDaBando(
      @ApiParam(value = "Identificativo del documento",required = true) @PathVariable(required = true) Long iddocumento,
      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable(required = true) String proceduraRiferimento,
      @ApiParam(value = "Nome del file del documento",required = true) @RequestParam(required = true) String nomefile) {
    return ResponseEntity.of(bandoManager.downloadFileDaGara(iddocumento, nomefile, proceduraRiferimento));
  }

  /**
   * Download documento da documenti esito gara
   * 
   * @return
   */
  @ApiOperation(value = "Restituisce il file allegato all' Esito")
  @GetMapping(path = "/getDocumentoDaEsito/{iddocumento}/{proceduraRiferimento}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FileDto> getDocumentoDaEsito(
      @ApiParam(value = "Identificativo del documento",required = true) @PathVariable(required = true) Long iddocumento,
      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable(required = true) String proceduraRiferimento,
      @ApiParam(value = "Nome del file del documento",required = true) @RequestParam(required = true) String nomefile) {
    return ResponseEntity.of(bandoManager.downloadFileDaEsito(iddocumento, nomefile, proceduraRiferimento));
  }

  /**
   * Download documento da documenti esito gara
   * 
   * @return
   */
  @ApiOperation(value = "Restituisce il file allegato all' Avviso")
  @GetMapping(path = "/getDocumentoDaAvviso/{iddocumento}/{proceduraRiferimento}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FileDto> getDocumentoDaAvviso(
      @ApiParam(value = "Identificativo del documento",required = true) @PathVariable(required = true) Long iddocumento,
      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable(required = true) String proceduraRiferimento,
      @ApiParam(value = "Nome del file del documento",required = true) @RequestParam(required = true) String nomefile) {
    return ResponseEntity.of(bandoManager.downloadFileDaAvviso(iddocumento, nomefile, proceduraRiferimento));
  }

  /**
   * Download documento da gara
   * 
   * @return
   */
  @ApiOperation(value = "Restituisce il file allegato rispetto agli Atti e documenti (art.29 c.1 DLgs 50/2016) ")
  @GetMapping(path = "/getAttoDocumento/{iddocumento}/{proceduraRiferimento}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<FileDto> getAttoDocumento(
      @ApiParam(value = "Identificativo del documento",required = true) @PathVariable(required = true) Long iddocumento,
      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable(required = true) String proceduraRiferimento,
      @ApiParam(value = "Nome del file del documento",required = true) @RequestParam(required = true) String nomefile) {
    return ResponseEntity.of(bandoManager.downloadAttoDocumentoFileDaGara(iddocumento, nomefile, proceduraRiferimento));
  }

  @ApiOperation(value = "Restituisce l'elenco degli esiti in pagine.")
  @GetMapping(path = "/getElencoEsiti/{page}/{pageSize}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PageDto<EsitoTestataDto>> getElencoEsiti(
      @ApiParam(allowableValues = "range[1,infinity]", example = "1", value = "Numero della pagina che deve essere restituita.",required = true) @PathVariable int page,
      @ApiParam(allowableValues = "range[1,infinity]", example = "100", value = "Massimo numero di elementi che devono essere restituiti nella pagina.",required = true) @PathVariable int pageSize,
      @ApiParam(value = "Codice della stazione appaltante per cui filtrare l'elenco degli esiti") @RequestParam(required = false) String stazioneAppaltante,
      @ApiParam(value = "Titolo per cui filtrare l'elenco degli esiti") @RequestParam(required = false) String titolo,
      @ApiParam(value = "CIG per cui filtrare l'elenco degli esiti") @RequestParam(required = false) String cig,
      @ApiParam(value = "Codice del tipo appalto per cui filtrare l'elenco degli esiti", example = "1", allowableValues = "range[1,infinity]") @RequestParam(required = false) Integer tipoAppalto,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Esiti con data di pubblicazione dal") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPubblicazioneDa,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Esiti con data di pubblicazione fino al") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPubblicazioneA,
      @ApiParam(value = "Filtro degli Esiti pubblicati negli ultimi N anni",defaultValue = "6") @RequestParam(defaultValue = "6") Integer numAnniPubblicazione,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Esiti di Gara con data di ultima modifica dal") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataUltimaModificaDA, 
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Esiti di Gara con data di ultima modifica fino al") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataUltimaModificaA) {

    return ResponseEntity.of(esitoManager.getEsiti(stazioneAppaltante, titolo, cig, tipoAppalto, dataPubblicazioneDa, dataPubblicazioneA,
        null, null, null, numAnniPubblicazione, page, pageSize,dataUltimaModificaDA, dataUltimaModificaA));
  }

  @ApiOperation(value = "Restituisce il dettaglio dell'esito.")
  @GetMapping(path = "/getDettaglioEsito/{riferimentoProcedura}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DettaglioDto<DatiGeneraliDto, BandoDocumentoDto, Void>> getDettaglioEsito(
      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable String riferimentoProcedura) {
    return ResponseEntity.of(esitoManager.getDettaglioEsito(riferimentoProcedura));
  }

  @ApiOperation(value = "Restituisce l'elenco degli avvisi in pagine.")
  @GetMapping(path = "/getElencoAvvisi/{page}/{pageSize}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PageDto<AvvisoTestataDto>> getElencoAvvisi(
      @ApiParam(allowableValues = "range[1,infinity]", example = "1", value = "Numero della pagina che deve essere restituita.",required = true) @PathVariable(required = true) int page,
      @ApiParam(allowableValues = "range[1,infinity]", example = "100", value = "Massimo numero di elementi che devono essere restituiti nella pagina.",required = true) @PathVariable(required = true) int pageSize,
      @ApiParam(value = "Codice della stazione appaltante per cui filtrare l'elenco degli Avvisi") @RequestParam(required = false) String stazioneAppaltante,
      @ApiParam(value = "Filtro per il titolo degli Avvisi") @RequestParam(required = false) String titolo,
      @ApiParam(value = "Identificativo del tipo dell'appalto per cui filtrare l'elenco degli Avvisi") @RequestParam(required = false) Integer tipoAppalto,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Avvisi con data pubblicazione dal") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPubblicazioneDa,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Avvisi con data pubblicazione fino al") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPubblicazioneA,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Avvisi con data scadenza dal") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataScadenzaDa,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Avvisi con data scadenza fino al") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataScadenzaA,
      @ApiParam(value = "Filtro degli Avvisi scaduti o in corso", defaultValue = "INCORSO") @RequestParam(required = true) StatoInCorsoScadutoEnum statoInCorsoScaduto,
      @ApiParam(value = "Filtro degli Avvisi pubblicati negli ultimi N anni" ,defaultValue = "6",type="int") @RequestParam(defaultValue = "6") Integer numAnniPubblicazione,
      @ApiParam(value = "Filtro degli Avvisi per numero di altri soggetti") @RequestParam(required = false) Integer altriSoggetti,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Avvisi con data ultima modifica dal") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataUltimaModificaDA, 
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro degli Avvisi con data utima modifica fino al") @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataUltimaModificaA) {
    return ResponseEntity.of(avManager.getAvvisi(stazioneAppaltante, titolo, tipoAppalto, dataPubblicazioneDa, dataPubblicazioneDa,
        dataScadenzaDa, dataScadenzaA, altriSoggetti, statoInCorsoScaduto, numAnniPubblicazione, page, pageSize,dataUltimaModificaDA,dataUltimaModificaA ));
  }

  @ApiOperation(value = "Restituisce il dettaglio dell' Avviso.")
  @GetMapping(path = "/getDettaglioAvviso/{riferimentoProcedura}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DettaglioDto<DatiGeneraliAvvisoDto, BandoDocumentoDto, ComunicazioneDto>> getDettaglioAvviso(
      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable(required = true) String riferimentoProcedura) {
    return ResponseEntity.of(avManager.getDettaglioAvviso(riferimentoProcedura));
  }

  /**
   * Tipologia Appalto
   * 
   * @return
   */
  @ApiOperation(value = "Restituisce le tipologie degli Avvisi.")
  @GetMapping(path = "/getTipologiaAvviso", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TabulatoDto>> getTipologiaAvviso() {
    List<TabulatoDto> tab1List = tabUnoRepository.findDtoByCodiceFilteringArchOrderByOrdinamento(TabulatiEnum.A1081.name());
    TabulatoDto tabElencoOperatoreEconomico = new TabulatoDto(0, "Elenco operatori economici");
    if (!tab1List.contains(tabElencoOperatoreEconomico)) {
      tab1List.add(tabElencoOperatoreEconomico);
    }
    logger.debug("Tabulati.A1081.name(): {}", TabulatiEnum.A1081.name());
    return ResponseEntity.of(Optional.ofNullable(tab1List));
  }
  
  
  @ApiOperation(value = "Servizio per la autenticazione")
  @PostMapping(path = "/authenticate", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<JwtResponse> authenticate (
      @RequestHeader(name = "username",required = true) String username,
      @RequestHeader(name = "password",required = true) String password,
      @ApiParam(value = "Client/Application key", required = true) @RequestHeader("clientKey") String clientKey,
      @ApiParam(value = "Client/Application Id", required = true) @RequestHeader("clientId") String clientId,
      @ApiParam(hidden = true)HttpServletRequest request
      ) throws Exception{
    logger.info("request.getRemoteAddr(): {}",request.getRemoteAddr());
    JwtResponse resp = new JwtResponse(authManager.authenticate(username, password, clientKey, clientId,request.getRemoteAddr()));
    return ResponseEntity.ok(resp);
  }
  
  @ApiOperation(value= "Elenco Stazioni Appaltanti per la Legge 190"
//      ,authorizations = { @Authorization(value="Bearer") }
      ,hidden = true
  )
  @GetMapping(path = "/trasp/getElencoStazioniAppaltanti", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<StazioneAppaltanteL190>> getElencoStazioniAppaltantiL190(
      @ApiParam(hidden = true)
      @RequestAttribute(name = "codein",required = false) List<String> codein){
    logger.info("Called getElencoStazioniAppaltantiL190.");
    logger.info("coein: {}",codein);
    return ResponseEntity.of(Optional.ofNullable(l190Manager.getAllStazioneAppaltanteL190()));
  }
  
  @ApiOperation(value= "Servizio di consultazione dei dati Legge 190"
//      ,authorizations = { @Authorization(value="Bearer") }
      ,hidden = true
      )
  @GetMapping(path = "/trasp/getElencoDati/{page}/{pageSize}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PageDto<GaraAntiCorruzioneDto>> getElencoDati(
      @ApiParam(allowableValues = "range[1,infinity]", example = "1", value = "Numero della pagina che deve essere restituita.",required = true) @PathVariable(required = true) int page,
      @ApiParam(allowableValues = "range[1,infinity]", example = "100", value = "Massimo numero di elementi che devono essere restituiti nella pagina.",required = true) @PathVariable(required = true) int pageSize,
      @RequestParam(required = true) Integer annorif,
      @RequestParam(required = false) String codiceStazioneAppaltante,
      @RequestParam(required = false) String codicegara,
      @RequestParam(required = false) String cig,
      @RequestParam(required = false) String oggetto
      ,
      @ApiParam(hidden = true)//NOT USED
      @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPubblicazione
      ){
    logger.info("Called getElencoDati.");
    return ResponseEntity.of(Optional.ofNullable(l190Manager.getElencoDati(page,pageSize,annorif, codiceStazioneAppaltante, codicegara, cig, oggetto)));
  }
  
  @ApiOperation(value= "Servizio di consultazione degli adempimenti per la Legge 190"
//      ,authorizations = { @Authorization(value="Bearer") }
      ,hidden = true
  )
  @GetMapping(path = "/trasp/getElencoAdempimenti/{page}/{pageSize}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PageDto<AdempimentoAnticorruzioneDto>> getElencoAdempimenti(
      @ApiParam(allowableValues = "range[1,infinity]", example = "1", value = "Numero della pagina che deve essere restituita.",required = true) @PathVariable(required = true) int page,
      @ApiParam(allowableValues = "range[1,infinity]", example = "100", value = "Massimo numero di elementi che devono essere restituiti nella pagina.",required = true) @PathVariable(required = true) int pageSize,
      @RequestParam(required = true) Integer annorif
      ){
    logger.info("Called getElencoDati.");
    return ResponseEntity.of(Optional.ofNullable(l190Manager.getElencoAdempimenti(page, pageSize, annorif)));
  }
  
  @ApiOperation(value = "Servizio per ottenere l'elenco dei contratti")
  @GetMapping(path = "/trasp/getElencoContratti/{page}/{pageSize}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PageDto<TraspContrattoDto>> getElencoContratti(
      @ApiParam(allowableValues = "range[1,infinity]", example = "1", value = "Numero della pagina che deve essere restituita.",required = true) @PathVariable(required = true) int page,
      @ApiParam(allowableValues = "range[1,infinity]", example = "100", value = "Massimo numero di elementi che devono essere restituiti nella pagina.",required = true) @PathVariable(required = true) int pageSize,
      @ApiParam(value = "Filtro per il cig del contratto")@RequestParam(required = false)String cig, 
      @ApiParam(value = "Filtro per la stazione appaltante")@RequestParam(required = false) String codiceStazioneAppaltante, 
      @ApiParam(value = "Filtro per l'oggetto del contratto")@RequestParam(required = false)String oggetto, 
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti sulla data di pubblicazione dell'esito dal") @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date dataPubblicazioneEsitoDa,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di pubblicazione dell'esito fino al") @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date dataPubblicazioneEsitoA
      
      
      ){
    return ResponseEntity.of(Optional.ofNullable(tManager.getContratti(page, pageSize,cig,codiceStazioneAppaltante,oggetto,dataPubblicazioneEsitoDa,dataPubblicazioneEsitoA )));
  }
  
  @ApiOperation(value = "Servizio per ottenere il dettaglio del contratto")
  @GetMapping(path = "/trasp/getDettaglioContratto/{riferimentoProcedura}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TraspContrattoDettaglioDto> getDettaglioContratto(
      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable(required = true) String riferimentoProcedura) {
    return ResponseEntity.of(Optional.ofNullable(tManager.getContratto(riferimentoProcedura)));
  }
  
  @ApiOperation(value = "Servizio per ottenere l'elenco dei contratti esteso",authorizations = { @Authorization(value="Bearer") })
  @GetMapping(path = "/trasp/getElencoContrattiEsteso/{page}/{pageSize}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PageDto<TraspContrattoEstesoDto>> getElencoContrattiEsteso(
      @ApiParam(allowableValues = "range[1,infinity]", example = "1", value = "Numero della pagina che deve essere restituita.",required = true) @PathVariable(required = true) int page,
      @ApiParam(allowableValues = "range[1,infinity]", example = "100", value = "Massimo numero di elementi che devono essere restituiti nella pagina.",required = true) @PathVariable(required = true) int pageSize,
      @ApiParam(value = "Filtro per il cig del contratto")@RequestParam(required = false)String cig, 
      @ApiParam(value = "Filtro per la stazione appaltante")@RequestParam(required = false) String codiceStazioneAppaltante, 
      @ApiParam(value = "Filtro per l'oggetto del contratto")@RequestParam(required = false)String oggetto, 
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di pubblicazione della gara dal") @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date dataPubblicazioneGaraDa,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di pubblicazione della gara fino al") @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date dataPubblicazioneGaraA,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di pubblicazione dell'esito dal") @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date dataPubblicazioneEsitoDa,
      @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di pubblicazione dell'esito fino al") @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date dataPubblicazioneEsitoA,
      @ApiParam(hidden = true,value="Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità")
      @RequestAttribute(name = "codein",required = true) List<String> codein,
      @ApiParam(hidden = true,value="Parametro hidden dove è inserita la syscon dell'utente")
      @RequestAttribute(name = "syscon",required = true) Long syscon
      , @ApiParam(hidden = true)HttpServletRequest request
      ) throws Exception{
    return ResponseEntity.of(Optional.ofNullable(tManager.getContrattiEstesa(page, pageSize, cig, codiceStazioneAppaltante, oggetto,dataPubblicazioneGaraDa,dataPubblicazioneGaraA, dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA, codein,syscon,request.getRemoteAddr())));
  }
  
  @ApiOperation(value = "Servizio per ottenere il dettaglio del contratto esteso",authorizations = { @Authorization(value="Bearer") })
  @GetMapping(path = "/trasp/getDettaglioContrattoEsteso/{riferimentoProcedura}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TraspContrattoDettaglioDto> getDettaglioContrattoEsteso(
      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable(required = true) String riferimentoProcedura,
      @ApiParam(hidden = true,value="Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità")
      @RequestAttribute(name = "codein",required = true) List<String> codein,
      @ApiParam(hidden = true,value="Parametro hidden dove è inserita la syscon dell'utente")
      @RequestAttribute(name = "syscon",required = true) Long syscon,
      @ApiParam(hidden = true)HttpServletRequest request
      ) throws Exception {
    return ResponseEntity.of(Optional.ofNullable(tManager.getContrattoEsteso(riferimentoProcedura,codein,syscon,request.getRemoteAddr())));
  }
  
  @ApiOperation(hidden = true, value = "Metodo per la creazione di un evento nella wlog eventi")
  @PostMapping(path = "/wlog/createWlogEventi")
  public ResponseEntity<Long> createWlogEventi(@RequestBody(required = true) Wlogeventi evento) throws Exception{
    return ResponseEntity.ok(wleManager.saveWlogEventi(evento));
  }
}
