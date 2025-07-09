package it.maggioli.appalti.rest.versions.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import it.maggioli.appalti.rest.dto.*;
import it.maggioli.appalti.rest.entities.WlogeventiBase;
import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltante;
import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltanteL190;
import it.maggioli.appalti.rest.enums.StatoInCorsoScadutoEnum;
import it.maggioli.appalti.rest.enums.TabulatiEnum;
import it.maggioli.appalti.rest.manager.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Rest controller che ingloba tutti i metodi del controller V1 e ne rimuove i metodi con autenticazione+
 * o che permettono di autenticarsi.
 */
@Api(tags = {"v1.0.1"})
@RestController
@RequestMapping("1.0.1")
@CrossOrigin
public class WsAppaltiControllerV10_1 extends WsAppaltiControllerV10 {

    private final Logger logger = LoggerFactory.getLogger(WsAppaltiControllerV10_1.class);

    @Override
    @ApiOperation(value = "Servizio per la autenticazione", hidden = true)
    public ResponseEntity<JwtResponse> authenticate(
            @ApiParam(value = "User/username", required = true, hidden = true)
            @RequestHeader(name = "username", required = true) String username,
            @ApiParam(value = "User/password", required = true, format = "password", hidden = true)
            @RequestHeader(name = "password", required = true) String password,
            @ApiParam(value = "Client/Application key", required = true, hidden = true) @RequestHeader("clientKey") String clientKey,
            @ApiParam(value = "Client/Application Id", required = true, hidden = true) @RequestHeader("clientId") String clientId,
            @ApiParam(hidden = true) HttpServletRequest request
    ) {
        return ResponseEntity.notFound().build();
    }

    @Override
    @ApiOperation(value = "Servizio per ottenere il dettaglio del contratto esteso", hidden = true)
    public ResponseEntity<TraspContrattoDettaglioDto> getDettaglioContrattoEsteso(
            @ApiParam(value = "Identificativo della procedura di riferimento", required = true, hidden = true) @PathVariable(required = true) String riferimentoProcedura,
            @ApiParam(hidden = true, value = "Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità")
            @RequestAttribute(name = "codein", required = true) List<String> codein,
            @ApiParam(hidden = true, value = "Parametro hidden dove è inserita la syscon dell'utente")
            @RequestAttribute(name = "syscon", required = true) Long syscon,
            @ApiParam(hidden = true) HttpServletRequest request
    ) {
        return ResponseEntity.notFound().build();
    }

    @Override
    @ApiOperation(value = "Servizio per ottenere il dettaglio del contratto esteso", hidden = true)
    public ResponseEntity<TraspContrattoDettaglioDto> getDettaglioContrattoEstesoWithParams(
//      @ApiParam(value = "Identificativo della procedura di riferimento",required = true) @PathVariable(required = true) String riferimentoProcedura,
            @ApiParam(hidden = true, value = "Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità")
            @RequestAttribute(name = "codein", required = true) List<String> codein,
            @ApiParam(hidden = true, value = "Parametro hidden dove è inserita la syscon dell'utente")
            @RequestAttribute(name = "syscon", required = true) Long syscon,
            @ApiParam(hidden = true) HttpServletRequest request
    ) {
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Servizio per ottenere l'elenco dei contratti esteso con la data di acquisizione del cig", hidden = true)
    public ResponseEntity<PageDto<TraspContrattoEstesoDacDto>> getElencoContrattiEsteso(
            @ApiParam(allowableValues = "range[1,infinity]", example = "1", value = "Numero della pagina che deve essere restituita.", required = true, hidden = true) @PathVariable(required = true) int page,
            @ApiParam(allowableValues = "range[1,infinity]", example = "100", value = "Massimo numero di elementi che devono essere restituiti nella pagina.", required = true, hidden = true) @PathVariable(required = true) int pageSize,
            @ApiParam(value = "Filtro per il cig del contratto", hidden = true) @RequestParam(required = false) String cig,
            @ApiParam(value = "Filtro per la stazione appaltante", hidden = true) @RequestParam(required = false) String codiceStazioneAppaltante,
            @ApiParam(value = "Filtro per l'oggetto del contratto", hidden = true) @RequestParam(required = false) String oggetto,
            @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di pubblicazione della gara dal", hidden = true) @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date dataPubblicazioneGaraDa,
            @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di pubblicazione della gara fino al", hidden = true) @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date dataPubblicazioneGaraA,
            @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di pubblicazione dell'esito dal", hidden = true) @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date dataPubblicazioneEsitoDa,
            @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di pubblicazione dell'esito fino al", hidden = true) @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date dataPubblicazioneEsitoA,
            @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di acquisizione cig dal", hidden = true) @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date dataAcquisizioneCigDa,
            @ApiParam(example = "2020-01-15", format = "date", value = "Filtro dei Contratti con data di acquisizione cig fino al", hidden = true) @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date dataAcquisizioneCigA,
            @ApiParam(hidden = true, value = "Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità")
            @RequestAttribute(name = "codein", required = true) List<String> codein,
            @ApiParam(hidden = true, value = "Parametro hidden dove è inserita la syscon dell'utente")
            @RequestAttribute(name = "syscon", required = true) Long syscon
            , @ApiParam(hidden = true) HttpServletRequest request
    ) {
        return ResponseEntity.notFound().build();
    }


}
