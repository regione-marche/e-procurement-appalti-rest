package it.maggioli.appalti.rest.versions.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import it.maggioli.appalti.rest.entities.Cais;
import it.maggioli.appalti.rest.exceptions.ErrorResponse;
import it.maggioli.appalti.rest.manager.BandoManager;

@Api(tags = { "v1.4" })
@RestController
@RequestMapping("v1.4")
@CrossOrigin
public class WsAppaltiControllerV14 extends WsAppaltiControllerV13 {

	private final Logger logger = LoggerFactory.getLogger(WsAppaltiControllerV14.class);
	private final String versione = "v1.4";

	@Autowired
	private BandoManager bManager;
	
	@ApiOperation(value = "Restituisce la lista di categorie merceologiche", authorizations = {
			@Authorization(value = "Bearer") }, produces = MediaType.APPLICATION_JSON_VALUE, nickname = "operatoriEconomici", responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse.class) })
	@GetMapping(path = "/getCategorieMerc", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cais> getCategorieMerceologiche(
			@ApiParam(value = "Codice categoria per filtrare le categorie merceologiche") @RequestParam(required = false) String codiceCategoria) {
		return bManager.getCategorieMerceologiche(codiceCategoria);
	}
	
	
	

}
