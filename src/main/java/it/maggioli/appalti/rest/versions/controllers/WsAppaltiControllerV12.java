package it.maggioli.appalti.rest.versions.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import it.maggioli.appalti.rest.dto.JwtResponse;
import it.maggioli.appalti.rest.dto.OepvConfermaDatiDto;
import it.maggioli.appalti.rest.dto.OepvCriterioDettaglioDto;
import it.maggioli.appalti.rest.dto.OepvCriterioListaDto;
import it.maggioli.appalti.rest.dto.OepvCriterioTabellareDto;
import it.maggioli.appalti.rest.dto.OepvDocumentoDto;
import it.maggioli.appalti.rest.dto.OepvDocumentoLottoDownloadDto;
import it.maggioli.appalti.rest.dto.OepvDocumentoPartecipanteDto;
import it.maggioli.appalti.rest.dto.OepvExportEsitoDto;
import it.maggioli.appalti.rest.dto.OepvGarPesiDto;
import it.maggioli.appalti.rest.dto.OepvInserisciCoefficientiEsitoDto;
import it.maggioli.appalti.rest.dto.OepvLottoDettaglioDto;
import it.maggioli.appalti.rest.dto.OepvPartecipanteDettaglioDto;
import it.maggioli.appalti.rest.dto.OepvPartecipanteListaDto;
import it.maggioli.appalti.rest.dto.StazioneAppaltanteEsteso;
import it.maggioli.appalti.rest.dto.VrDittaDto;
import it.maggioli.appalti.rest.dto.VrIpcDittaValoriDto;
import it.maggioli.appalti.rest.dto.VrPubblicazioneImpreseDto;
import it.maggioli.appalti.rest.dto.VrPubblicazioneResultDto;
import it.maggioli.appalti.rest.entities.GareOepv;
import it.maggioli.appalti.rest.manager.OepvManager;
import it.maggioli.appalti.rest.manager.VrManager;

@Api(tags = { "v1.2" })
@RestController
@RequestMapping("v1.2")
@CrossOrigin
public class WsAppaltiControllerV12 extends WsAppaltiControllerV11 {

	private final Logger logger = LoggerFactory.getLogger(WsAppaltiControllerV12.class);
	private final String versione = "v1.2";

	@Autowired
	private OepvManager oepvManager;

	@Autowired
	private VrManager vrManager;

	@ApiOperation(value = "Estrae dati della gara da tabella Gare per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getGaraById", produces = MediaType.APPLICATION_JSON_VALUE) // MediaType.ALL_VALUE
	public ResponseEntity<GareOepv> getGaraByIdOepv(@ApiParam(value = "Numero gara", required = true) @RequestParam(required = true) String ngara) {
		return ResponseEntity.of(oepvManager.getGaraById(ngara));
	}

	@ApiOperation(value = "Estrae dettaglio del lotto per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getDettaglioLottoOepv", produces = MediaType.APPLICATION_JSON_VALUE) // MediaType.ALL_VALUE
	public ResponseEntity<OepvLottoDettaglioDto> getDettaglioLottoOepv(
			@ApiParam(value = "Codice fiscale stazione appaltante", required = true) @RequestParam(required = true) String cfein,
			@ApiParam(value = "Codice fiscale utente", required = true) @RequestParam(required = true) String cftec,
			@ApiParam(value = "Numero gara", required = true) @RequestParam(required = true) String ngara) {
		return ResponseEntity.of(oepvManager.getDettaglioLotto(cfein, cftec, ngara));
	}

	@ApiOperation(value = "Estrae elenco documenti del lotto per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getDocumentiLottoOepv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OepvDocumentoDto>> getDocumentiLottoOepv(@ApiParam(value = "Codice gara", required = true) @RequestParam(required = true) String codiceGara,
			@ApiParam(value = "Codice lotto", required = false) @RequestParam(required = false) String codiceLotto) {
		return ResponseEntity.of(oepvManager.getDocumentiLotto(codiceGara, codiceLotto));
	}

	@ApiOperation(value = "Estrae elenco documenti del lotto per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getDocumentoLottoDownloadOepv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OepvDocumentoLottoDownloadDto> getDocumentoLottoDownloadOepv(
			@ApiParam(value = "ID Documento", required = true) @RequestParam(required = true) Long iddocdig) {
		return ResponseEntity.of(oepvManager.getDocumentoLottoDownload(iddocdig));
	}

	@ApiOperation(value = "Estrae elenco partecipanti alla gara per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getPartecipantiGaraOepv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OepvPartecipanteListaDto>> getPartecipantiGaraOepv(@ApiParam(value = "Numero gara", required = true) @RequestParam(required = true) String ngara) {
		return ResponseEntity.of(oepvManager.getPartecipantiGara(ngara));
	}

	@ApiOperation(value = "Estrae dettaglio del partecipante alla gara per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getDettaglioPartecipanteOepv", produces = MediaType.APPLICATION_JSON_VALUE) // MediaType.ALL_VALUE
	public ResponseEntity<OepvPartecipanteDettaglioDto> getDettaglioPartecipanteOepv(
			@ApiParam(value = "Codice gara", required = true) @RequestParam(required = true) String codiceGara,
			@ApiParam(value = "Numero gara", required = true) @RequestParam(required = true) String ngara,
			@ApiParam(value = "Codice impresa partecipante", required = true) @RequestParam(required = true) String codiceImpresa) {
		return ResponseEntity.of(oepvManager.getDettaglioPartecipante(codiceGara, ngara, codiceImpresa));
	}

	@ApiOperation(value = "Estrae elenco documenti di un partecipante alla gara per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getDocumentiPartecipanteGaraOepv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OepvDocumentoPartecipanteDto>> getDocumentiPartecipanteGaraOepv(
			@ApiParam(value = "Codice gara", required = true) @RequestParam(required = true) String codiceGara,
			@ApiParam(value = "Numero gara", required = true) @RequestParam(required = true) String ngara,
			@ApiParam(value = "Codice impresa partecipante", required = true) @RequestParam(required = true) String codiceImpresa) {
		return ResponseEntity.of(oepvManager.getDocumentiPartecipanteGara(codiceGara, ngara, codiceImpresa));
	}

	@ApiOperation(value = "Estrae contenuti di un documento di un partecipante per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getDocumentoPartecipanteDownloadOepv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OepvDocumentoLottoDownloadDto> getDocumentoPartecipanteDownloadOepv(
			@ApiParam(value = "ID Documento", required = true) @RequestParam(required = true) Long iddocdig,
			@ApiParam(value = "ID Programma", required = true) @RequestParam(required = true) String idprg) {
		return ResponseEntity.of(oepvManager.getDocumentoPartecipanteDownload(iddocdig, idprg));
	}

	@ApiOperation(value = "Estrae elenco criteri di gara per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getCriteriGaraOepv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OepvCriterioListaDto>> getCriteriGaraOepv(@ApiParam(value = "Numero gara", required = true) @RequestParam(required = true) String ngara) {
		return ResponseEntity.of(oepvManager.getCriteriGara(ngara));
	}

	@ApiOperation(value = "Estrae dettaglio del criterio alla gara per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getDettaglioCriterioGaraOepv", produces = MediaType.APPLICATION_JSON_VALUE) // MediaType.ALL_VALUE
	public ResponseEntity<OepvCriterioDettaglioDto> getDettaglioCriterioGaraOepv(@ApiParam(value = "Numero gara", required = true) @RequestParam(required = true) String ngara,
			@ApiParam(value = "Codice criterio", required = true) @RequestParam(required = true) Long necvan) {
		return ResponseEntity.of(oepvManager.getDettaglioCriterioGara(ngara, necvan));
	}

	@ApiOperation(value = "Estrae tabella pesi coefficienti per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getCoefficientiOepv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OepvGarPesiDto>> getCoefficientiOepv(@ApiParam(value = "Codice gara", required = true) @RequestParam(required = true) String codiceGara) {
		return ResponseEntity.of(oepvManager.getCoefficienti(codiceGara));
	}

	@ApiOperation(value = "Estrae tabellato per criteri manuali per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getCriterioTabellareOepv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OepvCriterioTabellareDto>> getCriterioTabellareOepv() {
		return ResponseEntity.of(oepvManager.getCriterioTabellareOepv());
	}

	@ApiOperation(value = "Verifica numero commissari gara per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getDiffCountCommissariGara", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> getDiffCountCommissariGaraOepv(@ApiParam(value = "Codice gara", required = true) @RequestParam(required = true) String codiceGara) {
		return ResponseEntity.of(oepvManager.getDiffCountCommissariGara(codiceGara));
	}

	@ApiOperation(value = "Salva i coefficienti di tutti i criteri per tutti i partecipanti per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@PostMapping(path = "/inserisciCoefficienti", consumes = { MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OepvInserisciCoefficientiEsitoDto> inserisciCoefficienti(
			@ApiParam(value = "Dati da confermare", required = true) @RequestBody OepvConfermaDatiDto datiConferma, @ApiParam(hidden = true) HttpServletRequest request) {
		OepvInserisciCoefficientiEsitoDto result = new OepvInserisciCoefficientiEsitoDto();
		try {
			Long syscon = (Long) request.getAttribute("syscon"); // Non uso @RequestAttribute altrimenti il generatore del client lo aggiunge come parametro
			result = oepvManager.inserisciCoefficienti(datiConferma, syscon, request.getRemoteAddr());
		} catch (Exception e) {
			logger.error("Errore in inserisciCoefficienti", e);
			result.setEsito(false);
			result.setErrorData(e.getMessage());
		}
		return ResponseEntity.of(Optional.of(result));
	}

	@ApiOperation(value = "Esposta in formato Excel i coefficienti di tutti i criteri per tutti i partecipanti per OEPV", authorizations = { @Authorization(value = "Bearer") })
	@PostMapping(path = "/exportExcel", consumes = { MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OepvExportEsitoDto> exportExcel(@ApiParam(value = "Dati da esportare", required = true) @RequestBody OepvConfermaDatiDto datiExport,
			@ApiParam(hidden = true) HttpServletRequest request) {
		OepvExportEsitoDto result = new OepvExportEsitoDto();
		try {
			Long syscon = (Long) request.getAttribute("syscon"); // Non uso @RequestAttribute altrimenti il generatore del client lo aggiunge come parametro
			String authorization = request.getHeader("Authorization");
//			oepvManager.inserisciCoefficienti(datiExport, true);
			logger.debug("Chiamata metodo export Excel");
			result = oepvManager.exportExcel(datiExport, authorization, syscon, request.getRemoteAddr());
		} catch (Exception e) {
			logger.error("Errore in exportExcel", e);
			result.setEsito(false);
			result.setErrorData(e.getMessage());
		}
		return ResponseEntity.of(Optional.of(result));
	}

	@ApiOperation(value = "Estrae elenco ditte per VR", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getListaDitteVr", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VrDittaDto>> getListaDitteVr(@ApiParam(value = "Numero gara", required = true) @RequestParam(required = true) String ngara) {
		return ResponseEntity.of(vrManager.getListaDitte(ngara));
	}

	@ApiOperation(value = "Estrae dati di import IPC", authorizations = { @Authorization(value = "Bearer") })
	@GetMapping(path = "/getDatiImportIcp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VrIpcDittaValoriDto>> getDatiImportIcp(@ApiParam(value = "Numero gara", required = true) @RequestParam(required = true) String ngara,
			@ApiParam(value = "Data da", required = true) @RequestParam(required = true) String datastart,
			@ApiParam(value = "Data a", required = true) @RequestParam(required = true) String dataend) {
		return ResponseEntity.of(vrManager.getDatiImportIcp(ngara, datastart, dataend));
	}

	@ApiOperation(value = "Pubblica i dati IVR ed invia le e-mails", authorizations = { @Authorization(value = "Bearer") })
	@PostMapping(path = "/pubblicaIvr", consumes = { MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VrPubblicazioneResultDto> pubblicaIvr(@ApiParam(value = "Dati da pubblicare", required = true) @RequestBody VrPubblicazioneImpreseDto pubblicazioneParams,
			@ApiParam(hidden = true) HttpServletRequest request) {
		Long syscon = (Long) request.getAttribute("syscon"); // Non uso @RequestAttribute altrimenti il generatore del client lo aggiunge come parametro
		return ResponseEntity.of(Optional.of(vrManager.pubblicaIvr(pubblicazioneParams, syscon, request.getRemoteAddr())));
	}

	@ApiOperation(value = "Servizio per la autenticazione con consumes JSON", response = JwtResponse.class)
	@PostMapping(path = "/authenticateJson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JwtResponse> authenticateJson(@ApiParam(value = "User/username", required = true) @RequestHeader(name = "username", required = true) String username,
			@ApiParam(value = "User/password", required = true, format = "password") @RequestHeader(name = "password", required = true) String password,
			@ApiParam(value = "Client/Application key", required = true) @RequestHeader("clientKey") String clientKey,
			@ApiParam(value = "Client/Application Id", required = true) @RequestHeader("clientId") String clientId, @ApiParam(hidden = true) HttpServletRequest request)
			throws Exception {
		logger.info("request.getRemoteAddr(): {}", request.getRemoteAddr());
		String token = authManager.authenticate(username, password, clientKey, clientId, request.getRemoteAddr());
		JwtResponse resp = new JwtResponse(token);
		return ResponseEntity.ok(resp);
	}

	@ApiOperation(value = "Restituisce l'elenco delle stazioni appaltanti con il codice fiscale")
	@GetMapping(path = "/getElencoStazioniAppaltantiEsteso", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StazioneAppaltanteEsteso>> getElencoStazioniAppaltantiEsteso() {
		return ResponseEntity.of(Optional.ofNullable(saManager.findAllEsteso()));
	}

}
