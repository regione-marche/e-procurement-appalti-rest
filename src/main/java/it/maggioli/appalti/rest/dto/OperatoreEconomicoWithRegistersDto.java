package it.maggioli.appalti.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * Classe DTO per IMPR per Aset
 * 
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "operatoreEconomicoElenchi")
@JsonIgnoreProperties({ "ultimaDataAggiornamento" })
public class OperatoreEconomicoWithRegistersDto extends OperatoreEconomicoDto {

	private List<String> registers;
	private String codiceForniotreEsterno;

	@JsonProperty(value = "elenchi")
	public List<String> getRegisters() {
		return registers;
	}

	public void setRegisters(List<String> registers) {
		this.registers = registers;
	}

	/**
	 * @return the codiceForniotreEsterno
	 */
	public String getCodiceForniotreEsterno() {
		return codiceForniotreEsterno;
	}

	/**
	 * @param codiceForniotreEsterno the codiceForniotreEsterno to set
	 */
	public void setCodiceForniotreEsterno(String codiceForniotreEsterno) {
		this.codiceForniotreEsterno = codiceForniotreEsterno;
	}

	@Override
	public String toString() {
		return "OperatoreEconomicoWithRegistersDto ["
				+ (codiceForniotreEsterno != null ? "codiceForniotreEsterno=" + codiceForniotreEsterno + ", " : "")
				+ (getCodice() != null ? "getCodice()=" + getCodice() + ", " : "")
				+ (getCodiceFiscale() != null ? "getCodiceFiscale()=" + getCodiceFiscale() + ", " : "")
				+ (getPartitaIva() != null ? "getPartitaIva()=" + getPartitaIva() : "") + "]";
	}
	
	
}
