package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VrDittaDto {

	private String ngara5;
	private String dittao;
	private String nomimo;
	private String pivimp;
	private String codnazione;
	private Date dabilitaz;
	private Date dattivaz;
	private Date dscad;
	private Date dricrin;
	private BigDecimal abilitaz;
	private Date dinizval;

	public VrDittaDto(String ngara5, String dittao, String nomimo, String pivimp, Date dabilitaz, Date dattivaz, Date dscad, Date dricrin, BigDecimal abilitaz, Date dinizval,
			String codnazione) {
		super();
		this.ngara5 = ngara5;
		this.dittao = dittao;
		this.nomimo = nomimo;
		this.pivimp = pivimp;
		this.dabilitaz = dabilitaz;
		this.dattivaz = dattivaz;
		this.dscad = dscad;
		this.dricrin = dricrin;
		this.abilitaz = abilitaz;
		this.dinizval = dinizval;
		this.codnazione = codnazione;
		
		if(StringUtils.isBlank(this.codnazione)) {
			this.codnazione = "IT";
		}
	}

	public String getPivimp() {
		return pivimp;
	}

	public void setPivimp(String pivimp) {
		this.pivimp = pivimp;
	}

	public String getNomimo() {
		return nomimo;
	}

	public void setNomimo(String nomimo) {
		this.nomimo = nomimo;
	}

	public String getNgara5() {
		return ngara5;
	}

	public void setNgara5(String ngara5) {
		this.ngara5 = ngara5;
	}

	public String getDittao() {
		return dittao;
	}

	public void setDittao(String dittao) {
		this.dittao = dittao;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Date getDabilitaz() {
		return dabilitaz;
	}

	public void setDabilitaz(Date dabilitaz) {
		this.dabilitaz = dabilitaz;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Date getDattivaz() {
		return dattivaz;
	}

	public void setDattivaz(Date dattivaz) {
		this.dattivaz = dattivaz;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Date getDscad() {
		return dscad;
	}

	public void setDscad(Date dscad) {
		this.dscad = dscad;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Date getDricrin() {
		return dricrin;
	}

	public void setDricrin(Date dricrin) {
		this.dricrin = dricrin;
	}

	public BigDecimal getAbilitaz() {
		return abilitaz;
	}

	public void setAbilitaz(BigDecimal abilitaz) {
		this.abilitaz = abilitaz;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Date getDinizval() {
		return dinizval;
	}

	public void setDinizval(Date dinizval) {
		this.dinizval = dinizval;
	}

	public String getCodnazione() {
		return codnazione;
	}

	public void setCodnazione(String codnazione) {
		this.codnazione = codnazione;
	}

}
