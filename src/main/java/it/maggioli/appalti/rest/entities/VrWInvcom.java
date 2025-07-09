package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import it.maggioli.appalti.rest.entities.identities.VrWInvcomPK;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the w_invcom database table.
 * 
 */
@Entity
@Table(name="w_invcom")
public class VrWInvcom implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VrWInvcomPK id;

	private BigDecimal comcodope;

	private Timestamp comdatapub;

	private Timestamp comdatastato;

	private Timestamp comdatins;

	private Timestamp comdatlet;

	private Timestamp comdatprot;

	private Timestamp comdatsca;

	private String coment;

	private String comintest;

	private String comkey1;

	private String comkey2;

	private String comkey3;

	private String comkey4;

	private String comkey5;

	private String comkeysess;

	private String committ;

	private BigDecimal commodello;

	private String commsgogg;

	private String commsgtes;

	private String commsgtip;

	private String comnorispondi;

	private String comnumprot;

	private String comorasca;

	private BigDecimal compub;

	private String comstato;

	private BigDecimal comsyslet;

	private BigDecimal comtipma;

	private String comtipo;

	private String idcfg;

	private BigDecimal idcomris;

	private BigDecimal idgarpro;

	private String idprgris;

	public VrWInvcom() {
	}

	public VrWInvcomPK getId() {
		return this.id;
	}

	public void setId(VrWInvcomPK id) {
		this.id = id;
	}

	public BigDecimal getComcodope() {
		return this.comcodope;
	}

	public void setComcodope(BigDecimal comcodope) {
		this.comcodope = comcodope;
	}

	public Timestamp getComdatapub() {
		return this.comdatapub;
	}

	public void setComdatapub(Timestamp comdatapub) {
		this.comdatapub = comdatapub;
	}

	public Timestamp getComdatastato() {
		return this.comdatastato;
	}

	public void setComdatastato(Timestamp comdatastato) {
		this.comdatastato = comdatastato;
	}

	public Timestamp getComdatins() {
		return this.comdatins;
	}

	public void setComdatins(Timestamp comdatins) {
		this.comdatins = comdatins;
	}

	public Timestamp getComdatlet() {
		return this.comdatlet;
	}

	public void setComdatlet(Timestamp comdatlet) {
		this.comdatlet = comdatlet;
	}

	public Timestamp getComdatprot() {
		return this.comdatprot;
	}

	public void setComdatprot(Timestamp comdatprot) {
		this.comdatprot = comdatprot;
	}

	public Timestamp getComdatsca() {
		return this.comdatsca;
	}

	public void setComdatsca(Timestamp comdatsca) {
		this.comdatsca = comdatsca;
	}

	public String getComent() {
		return this.coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public String getComintest() {
		return this.comintest;
	}

	public void setComintest(String comintest) {
		this.comintest = comintest;
	}

	public String getComkey1() {
		return this.comkey1;
	}

	public void setComkey1(String comkey1) {
		this.comkey1 = comkey1;
	}

	public String getComkey2() {
		return this.comkey2;
	}

	public void setComkey2(String comkey2) {
		this.comkey2 = comkey2;
	}

	public String getComkey3() {
		return this.comkey3;
	}

	public void setComkey3(String comkey3) {
		this.comkey3 = comkey3;
	}

	public String getComkey4() {
		return this.comkey4;
	}

	public void setComkey4(String comkey4) {
		this.comkey4 = comkey4;
	}

	public String getComkey5() {
		return this.comkey5;
	}

	public void setComkey5(String comkey5) {
		this.comkey5 = comkey5;
	}

	public String getComkeysess() {
		return this.comkeysess;
	}

	public void setComkeysess(String comkeysess) {
		this.comkeysess = comkeysess;
	}

	public String getCommitt() {
		return this.committ;
	}

	public void setCommitt(String committ) {
		this.committ = committ;
	}

	public BigDecimal getCommodello() {
		return this.commodello;
	}

	public void setCommodello(BigDecimal commodello) {
		this.commodello = commodello;
	}

	public String getCommsgogg() {
		return this.commsgogg;
	}

	public void setCommsgogg(String commsgogg) {
		this.commsgogg = commsgogg;
	}

	public String getCommsgtes() {
		return this.commsgtes;
	}

	public void setCommsgtes(String commsgtes) {
		this.commsgtes = commsgtes;
	}

	public String getCommsgtip() {
		return this.commsgtip;
	}

	public void setCommsgtip(String commsgtip) {
		this.commsgtip = commsgtip;
	}

	public String getComnorispondi() {
		return this.comnorispondi;
	}

	public void setComnorispondi(String comnorispondi) {
		this.comnorispondi = comnorispondi;
	}

	public String getComnumprot() {
		return this.comnumprot;
	}

	public void setComnumprot(String comnumprot) {
		this.comnumprot = comnumprot;
	}

	public String getComorasca() {
		return this.comorasca;
	}

	public void setComorasca(String comorasca) {
		this.comorasca = comorasca;
	}

	public BigDecimal getCompub() {
		return this.compub;
	}

	public void setCompub(BigDecimal compub) {
		this.compub = compub;
	}

	public String getComstato() {
		return this.comstato;
	}

	public void setComstato(String comstato) {
		this.comstato = comstato;
	}

	public BigDecimal getComsyslet() {
		return this.comsyslet;
	}

	public void setComsyslet(BigDecimal comsyslet) {
		this.comsyslet = comsyslet;
	}

	public BigDecimal getComtipma() {
		return this.comtipma;
	}

	public void setComtipma(BigDecimal comtipma) {
		this.comtipma = comtipma;
	}

	public String getComtipo() {
		return this.comtipo;
	}

	public void setComtipo(String comtipo) {
		this.comtipo = comtipo;
	}

	public String getIdcfg() {
		return this.idcfg;
	}

	public void setIdcfg(String idcfg) {
		this.idcfg = idcfg;
	}

	public BigDecimal getIdcomris() {
		return this.idcomris;
	}

	public void setIdcomris(BigDecimal idcomris) {
		this.idcomris = idcomris;
	}

	public BigDecimal getIdgarpro() {
		return this.idgarpro;
	}

	public void setIdgarpro(BigDecimal idgarpro) {
		this.idgarpro = idgarpro;
	}

	public String getIdprgris() {
		return this.idprgris;
	}

	public void setIdprgris(String idprgris) {
		this.idprgris = idprgris;
	}

}