package it.maggioli.appalti.rest.dto.appalti;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CgResponse {
	private List<Coefficienti> coefficienti;
	private List<PunteggiMassimi> punteggiMassimi;
	private List<PunteggiTecniciImprese> punteggiTecniciImprese;
	/**
	 * @return the coefficienti
	 */
	public List<Coefficienti> getCoefficienti() {
		return coefficienti;
	}
	/**
	 * @param coefficienti the coefficienti to set
	 */
	public void setCoefficienti(List<Coefficienti> coefficienti) {
		this.coefficienti = coefficienti;
	}
	/**
	 * @return the punteggiMassimi
	 */
	public List<PunteggiMassimi> getPunteggiMassimi() {
		return punteggiMassimi;
	}
	/**
	 * @param punteggiMassimi the punteggiMassimi to set
	 */
	public void setPunteggiMassimi(List<PunteggiMassimi> punteggiMassimi) {
		this.punteggiMassimi = punteggiMassimi;
	}
	/**
	 * @return the punteggiTecniciImprese
	 */
	public List<PunteggiTecniciImprese> getPunteggiTecniciImprese() {
		return punteggiTecniciImprese;
	}
	/**
	 * @param punteggiTecniciImprese the punteggiTecniciImprese to set
	 */
	public void setPunteggiTecniciImprese(List<PunteggiTecniciImprese> punteggiTecniciImprese) {
		this.punteggiTecniciImprese = punteggiTecniciImprese;
	}
	
	
}
