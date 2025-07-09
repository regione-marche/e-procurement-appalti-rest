package it.maggioli.appalti.rest.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Questa classe mappa la tabella <code>cais</code>
 * <br>Marcata come Immutable per evitare modifiche
 * @author alessio.iezzi
 *
 */
@Entity
@Immutable
@Table(name = "cais")
public class Cais {
	
	@Id
  	private String caisim;
  	private String descat;
  	private Long tiplavg;
  	private String quaobb;
  	private String acontec;
  	private Long caisord;
  	private String titcat;
  	private String isarchi;
  	private String codliv1;
  	private String codliv2;
  	private String codliv3;
  	private String codliv4;
  	
	public String getCaisim() {
		return caisim;
	}
	public void setCaisim(String caisim) {
		this.caisim = caisim;
	}
	public String getDescat() {
		return descat;
	}
	public void setDescat(String descat) {
		this.descat = descat;
	}
	public Long getTiplavg() {
		return tiplavg;
	}
	public void setTiplavg(Long tiplavg) {
		this.tiplavg = tiplavg;
	}
	public String getQuaobb() {
		return quaobb;
	}
	public void setQuaobb(String quaobb) {
		this.quaobb = quaobb;
	}
	public String getAcontec() {
		return acontec;
	}
	public void setAcontec(String acontec) {
		this.acontec = acontec;
	}
	public Long getCaisord() {
		return caisord;
	}
	public void setCaisord(Long caisord) {
		this.caisord = caisord;
	}
	public String getTitcat() {
		return titcat;
	}
	public void setTitcat(String titcat) {
		this.titcat = titcat;
	}
	public String getIsarchi() {
		return isarchi;
	}
	public void setIsarchi(String isarchi) {
		this.isarchi = isarchi;
	}
	public String getCodliv1() {
		return codliv1;
	}
	public void setCodliv1(String codliv1) {
		this.codliv1 = codliv1;
	}
	public String getCodliv2() {
		return codliv2;
	}
	public void setCodliv2(String codliv2) {
		this.codliv2 = codliv2;
	}
	public String getCodliv3() {
		return codliv3;
	}
	public void setCodliv3(String codliv3) {
		this.codliv3 = codliv3;
	}
	public String getCodliv4() {
		return codliv4;
	}
	public void setCodliv4(String codliv4) {
		this.codliv4 = codliv4;
	}
  
  
  
}
