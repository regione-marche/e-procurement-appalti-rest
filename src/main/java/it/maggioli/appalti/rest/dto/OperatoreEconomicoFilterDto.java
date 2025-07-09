package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author
 */
public class OperatoreEconomicoFilterDto {
	@ApiParam(example = "2021-01-01", format = "date", value = "Data Aggiornamento Da Portale Da")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date dataAggiornamentoDaPortaleDa;
	@ApiParam(example = "2021-01-10",format = "date",value = "Data Aggiornamento Da Portale A")
	@DateTimeFormat(pattern = "yyyy-MM-dd") Date dataAggiornamentoDaPortaleA;
	@ApiParam(value = "Codice dell'operatore economico") String codiceOe;
	@ApiParam(value = "Codice Ficale dell'operatore economico") String cfOe;
	@ApiParam(value = "Partita Iva / Estero dell'operatore economico") String pivaOe;
	@ApiParam(value = "Denominazione dell'operatore economico") String denomOe;

	public Date getDataAggiornamentoDaPortaleDa() {
		return dataAggiornamentoDaPortaleDa;
	}

	public void setDataAggiornamentoDaPortaleDa(Date dataAggiornamentoDaPortaleDa) {
		this.dataAggiornamentoDaPortaleDa = dataAggiornamentoDaPortaleDa;
	}

	public Date getDataAggiornamentoDaPortaleA() {
		return dataAggiornamentoDaPortaleA;
	}

	public void setDataAggiornamentoDaPortaleA(Date dataAggiornamentoDaPortaleA) {
		this.dataAggiornamentoDaPortaleA = dataAggiornamentoDaPortaleA;
	}

	public String getCodiceOe() {
		return codiceOe;
	}

	public void setCodiceOe(String codiceOe) {
		this.codiceOe = codiceOe;
	}

	public String getCfOe() {
		return cfOe;
	}

	public void setCfOe(String cfOe) {
		this.cfOe = cfOe;
	}

	public String getPivaOe() {
		return pivaOe;
	}

	public void setPivaOe(String pivaOe) {
		this.pivaOe = pivaOe;
	}

	public String getDenomOe() {
		return denomOe;
	}

	public void setDenomOe(String denomOe) {
		this.denomOe = denomOe;
	}

	@Override
	public String toString() {
		return "OperatoreEconomicoFilterDto ["
				+ (dataAggiornamentoDaPortaleDa != null
						? "dataAggiornamentoDaPortaleDa=" + dataAggiornamentoDaPortaleDa + ", "
						: "")
				+ (dataAggiornamentoDaPortaleA != null
						? "dataAggiornamentoDaPortaleA=" + dataAggiornamentoDaPortaleA + ", "
						: "")
				+ (codiceOe != null ? "codiceOe=" + codiceOe + ", " : "") + (cfOe != null ? "cfOe=" + cfOe + ", " : "")
				+ (pivaOe != null ? "pivaOe=" + pivaOe + ", " : "") + (denomOe != null ? "denomOe=" + denomOe : "")
				+ "]";
	}
	
	
}
