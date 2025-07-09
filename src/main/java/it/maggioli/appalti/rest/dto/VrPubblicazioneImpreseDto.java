package it.maggioli.appalti.rest.dto;

import java.util.ArrayList;

public class VrPubblicazioneImpreseDto {

	private String calcPeriodDesc;

	private ArrayList<VrPubblicazioneImpresaDto> imprese;

	public String getCalcPeriodDesc() {
		return calcPeriodDesc;
	}

	public void setCalcPeriodDesc(String calcPeriodDesc) {
		this.calcPeriodDesc = calcPeriodDesc;
	}

	public ArrayList<VrPubblicazioneImpresaDto> getImprese() {
		return imprese;
	}

	public void setImprese(ArrayList<VrPubblicazioneImpresaDto> imprese) {
		this.imprese = imprese;
	}

}
