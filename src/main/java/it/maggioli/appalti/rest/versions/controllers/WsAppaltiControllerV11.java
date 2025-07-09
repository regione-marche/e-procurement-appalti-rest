package it.maggioli.appalti.rest.versions.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import it.maggioli.appalti.rest.dto.AggiudicazioniDto;
import it.maggioli.appalti.rest.dto.JwtResponse;
import it.maggioli.appalti.rest.dto.OperatoreEconomicoDto;
import it.maggioli.appalti.rest.exceptions.Error404Exception;
import it.maggioli.appalti.rest.exceptions.ErrorResponse;
import it.maggioli.appalti.rest.exceptions.MissingMinimumDataException;
import it.maggioli.appalti.rest.manager.LfsManager;
import it.maggioli.appalti.rest.manager.OperatoriEconomiciManager;

@Api(tags = {"v1.1" })
@RestController
@RequestMapping("v1.1")
@CrossOrigin
public class WsAppaltiControllerV11 extends WsAppaltiControllerV10 {

  private final Logger logger = LoggerFactory.getLogger(WsAppaltiControllerV11.class);
  private final String versione = "v1.1";
  
  @Autowired
  private LfsManager lfsManager;
  @Autowired
  private OperatoriEconomiciManager oeManager;
  
  @ApiOperation(value = "Servizio per la autenticazione",response = JwtResponse.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Unauthorized",response = ErrorResponse.class),
      @ApiResponse(code = 400, message = "Bad Request",response = ErrorResponse.class)
  })
  @Override
  public ResponseEntity<JwtResponse> authenticate(
      @ApiParam(value = "User/username", required = true )
      @RequestHeader(name = "username",required = true) String username,
      @ApiParam(value = "User/password", required = true,format = "password" )
      @RequestHeader(name = "password",required = true) String password,
      @ApiParam(value = "Client/Application key", required = true) @RequestHeader("clientKey") String clientKey,
      @ApiParam(value = "Client/Application Id", required = true) @RequestHeader("clientId") String clientId,
      @ApiParam(hidden = true)HttpServletRequest request) throws Exception {
    return super.authenticate(username, password, clientKey, clientId, request);
  }

  @ApiOperation(value = "Esporta dati aggiudicazione",authorizations = { @Authorization(value="Bearer") }, 
      produces = MediaType.APPLICATION_JSON_VALUE, nickname = "lfs-getDatiAggiudicazione"
      ,response = AggiudicazioniDto.class,responseContainer = "List")
  @GetMapping(path = "/getDatiAggiudicazione", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<AggiudicazioniDto>> getDatiAggiudicazione(
      @ApiParam(value="Identificativo della procedura di riferimento",required = true, allowMultiple = true)
      @RequestParam(name = "cig",required = true) List<String> cig,
      @ApiParam(hidden = true,value="Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità")
      @RequestAttribute(name = "codein",required = true) List<String> codein,
      @ApiParam(hidden = true,value="Parametro hidden dove è inserita la syscon dell'utente")
      @RequestAttribute(name = "syscon",required = true) Long syscon,
      @ApiParam(hidden = true)HttpServletRequest request
      ){
    logger.info("getVersione: {}",versione);
    return ResponseEntity.ok(lfsManager.getLfsAggiudicazioniByCigAndUffint(cig, codein));
  }
  
  @ApiOperation(value = "Esporta dati degli operatori economici",authorizations = { @Authorization(value="Bearer") }, 
      produces = MediaType.APPLICATION_JSON_VALUE, nickname = "operatoriEconomici"
      ,responseContainer = "List")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Unauthorized",response = ErrorResponse.class),
      @ApiResponse(code = 400, message = "Bad Request",response = ErrorResponse.class),
      @ApiResponse(code = 500, message = "Internal Server Error",response = ErrorResponse.class)
  })
  @GetMapping(path = "/getOperatoriEconomici", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<OperatoreEconomicoDto>> getOperatoriEconomici(
      @ApiParam(example = "2021-01-01",format = "date", value = "Data Aggiornamento Da Portale Da")
      @RequestParam(required = false) 
      @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataAggiornamentoDaPortaleDa,
      @ApiParam(example = "2021-01-10",format = "date",value = "Data Aggiornamento Da Portale A")
      @RequestParam(required = false)
      @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataAggiornamentoDaPortaleA,
      @ApiParam(value = "Codice dell'operatore economico") @RequestParam(required = false) String codiceOe,
      @ApiParam(value = "Codice Ficale dell'operatore economico") @RequestParam(required = false) String cfOe,
      @ApiParam(value = "Partita Iva / Estero dell'operatore economico") @RequestParam(required = false) String pivaOe,
      @ApiParam(value = "Denominazione dell'operatore economico") @RequestParam(required = false) String denomOe,      
      @ApiParam(hidden = true,value="Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità")
      @RequestAttribute(name = "codein",required = true) List<String> codein,
      @ApiParam(hidden = true,value="Parametro hidden dove è inserita la syscon dell'utente")
      @RequestAttribute(name = "syscon",required = true) Long syscon,
      @ApiParam(hidden = true)HttpServletRequest request
      ){
    List<OperatoreEconomicoDto> lista = oeManager.findOperatoriEconomici(dataAggiornamentoDaPortaleDa, dataAggiornamentoDaPortaleA, codiceOe, cfOe, pivaOe, denomOe);
    if(lista.isEmpty()) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(lista);
  }
  @ApiOperation(value = "Aggiorna data inizio, data ultimazione e importo liquidato di un CIG",authorizations = { @Authorization(value="Bearer") }, 
      produces = MediaType.APPLICATION_JSON_VALUE, nickname = "updateDatiCig")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 400, message = "Bad Request",response = ErrorResponse.class),
      @ApiResponse(code = 401, message = "Unauthorized",response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "Not Found",response = ErrorResponse.class),
      @ApiResponse(code = 500, message = "Internal Server Error",response = ErrorResponse.class)
  })
  @PostMapping(path = "/updateDatiCig", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> updateDatiCig(
      @ApiParam(value = "CIG di riferimento per aggiornare i dati.",required = true) @RequestParam(required = true) String cig,  
      @ApiParam(value = "Codice Fiscale Stazione Appaltante.",required = true) @RequestParam(required = true) String codiceFiscaleSA,  
      @ApiParam(value = "Importo liquidato",type="number",format = "double",allowableValues = "range[0,infinity]") @RequestParam(required = false) Double importoLiquidato,
      @ApiParam(example = "2021-01-01",format = "date", value = "Data inizio")
      @RequestParam(required = false) 
      @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInizio,
      @ApiParam(example = "2021-01-10",format = "date",value = "Data fine")
      @RequestParam(required = false)
      @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFine,
      @ApiParam(value = "Opzioni",type="number",format = "double",allowableValues = "1,2",defaultValue = "1",allowEmptyValue = false) @RequestParam(defaultValue = "1") Integer opzione,
      @ApiParam(hidden = true,value="Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità")
      @RequestAttribute(name = "codein",required = true) List<String> codein,
      @ApiParam(hidden = true,value="Parametro hidden dove è inserita la syscon dell'utente")
      @RequestAttribute(name = "syscon",required = true) Long syscon,
      @ApiParam(hidden = true)HttpServletRequest request
      ) throws Exception{
    if(importoLiquidato==null && dataInizio==null && dataFine == null) throw new MissingMinimumDataException("importoLiquidato, dataInizio, dataFine");
    Optional<Integer> update = l190Manager.updateDatiCig(cig, codiceFiscaleSA, importoLiquidato, dataInizio, dataFine, opzione, syscon, request.getRemoteAddr());
    if(update.isPresent()) return ResponseEntity.ok().build();
    return ResponseEntity.notFound().build();
  }
  @ApiOperation(value = "Aggiorna dati lotto dell'ultimo Adempimento L190/2012 in stato non approvato",authorizations = { @Authorization(value="Bearer") }, 
      produces = MediaType.APPLICATION_JSON_VALUE, nickname = "updateDatiLottoAdempimentoCig")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success"),
      @ApiResponse(code = 401, message = "Unauthorized",response = ErrorResponse.class),
      @ApiResponse(code = 400, message = "Bad Request",response = ErrorResponse.class),
      @ApiResponse(code = 404, message = "Not Found",response = ErrorResponse.class),
      @ApiResponse(code = 500, message = "Internal Server Error",response = ErrorResponse.class)
  })
  @PostMapping(path = "/updateDatiLottoAdempimentoCig", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> updateDatiLottoAdempimentoCig(
      @ApiParam(value = "CIG di riferimento per aggiornare i dati.",required = true) @RequestParam(required = true) String cig,  
      @ApiParam(value = "Codice Fiscale Stazione Appaltante.",required = true) @RequestParam(required = true) String codiceFiscaleSA,  
      @ApiParam(value = "Importo liquidato",type="number",format = "double",allowableValues = "range[0,infinity]") @RequestParam(required = false) Double importoLiquidato,
      @ApiParam(example = "2021-01-01",format = "date", value = "Data inizio")
        @RequestParam(required = false) 
        @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInizio,
      @ApiParam(example = "2021-01-10",format = "date",value = "Data fine")
        @RequestParam(required = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFine,
      @ApiParam(value = "Opzioni",type="number",format = "double",allowableValues = "1,2",defaultValue = "1",allowEmptyValue = false) @RequestParam(defaultValue = "1") Integer opzione,
      @ApiParam(hidden = true,value="Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità")
      @RequestAttribute(name = "codein",required = true) List<String> codein,
      @ApiParam(hidden = true,value="Parametro hidden dove è inserita la syscon dell'utente")
      @RequestAttribute(name = "syscon",required = true) Long syscon,
      @ApiParam(hidden = true)HttpServletRequest request
      ) throws Exception{
    if(importoLiquidato==null && dataInizio==null && dataFine == null) throw new MissingMinimumDataException("importoLiquidato, dataInizio, dataFine");
      Optional<Integer> update = l190Manager.updateDatiAnticorCig(cig, importoLiquidato, dataInizio, dataFine, codiceFiscaleSA, opzione, syscon, request.getRemoteAddr());
      if(update.isPresent()) return ResponseEntity.ok().build();
      logger.warn("Impossibile trovare il cig {} oppure un adempimento non approvato per la SA con C.F. {}",cig,codiceFiscaleSA);
      throw new Error404Exception("Impossibile trovare il cig '"+cig+"' oppure un adempimento non approvato per la SA con C.F. '"+codiceFiscaleSA+"'");
  }
  
}
