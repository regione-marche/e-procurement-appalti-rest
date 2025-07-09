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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import it.maggioli.appalti.rest.dto.OperatoreEconomicoFilterDto;
import it.maggioli.appalti.rest.dto.OperatoreEconomicoWithRegistersDto;
import it.maggioli.appalti.rest.exceptions.ErrorResponse;
import it.maggioli.appalti.rest.manager.OperatoriEconomiciManager;

@Api(tags = { "v1.3" })
@RestController
@RequestMapping("v1.3")
@CrossOrigin
public class WsAppaltiControllerV13 extends WsAppaltiControllerV12 {

	private final Logger logger = LoggerFactory.getLogger(WsAppaltiControllerV13.class);
	private final String versione = "v1.3";

	@Autowired
	private OperatoriEconomiciManager oeManager;
	
	@ApiOperation(value = "Esporta dati degli operatori economici, compresi i relativi elenchi a cui sono iscritti se presenti", authorizations = {
			@Authorization(value = "Bearer") }, produces = MediaType.APPLICATION_JSON_VALUE, nickname = "operatoriEconomici", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class) })
	@GetMapping(path = "/getOperatoriEconomiciConElenchi", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OperatoreEconomicoWithRegistersDto> getOperatoreEconomicoWithListOfRegisters(
			@ApiParam(hidden = true, value = "Parametro hidden dove sono inserite le uffint a cui l'utente autorizzato ha visibilità") @RequestAttribute(name = "codein", required = true) List<String> codein,
			@ApiParam(hidden = true, value = "Parametro hidden dove è inserita la syscon dell'utente") @RequestAttribute(name = "syscon", required = true) Long syscon,
			@ApiParam(hidden = true) HttpServletRequest request,
			Optional<OperatoreEconomicoFilterDto> operatoreEconomicoFilterDto) {
		return oeManager.getOperatoreEconomicoWithListOfRegisters(operatoreEconomicoFilterDto);
	}
	
	@ApiOperation(value = "Aggiorna i dati dell'operatore economico se trovato.", authorizations = {
			@Authorization(value = "Bearer") }, produces = MediaType.APPLICATION_JSON_VALUE, nickname = "operatoriEconomici", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class) })
	@PostMapping(path = "/updateOperatoriEconomici", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OperatoreEconomicoWithRegistersDto> updateImpr(
			@RequestBody OperatoreEconomicoWithRegistersDto operatoreEconomicoDto){
		return oeManager.updateImpr(operatoreEconomicoDto);
	}
	

}
