package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the g1cf_pubb database table.
 * 
 */
@Entity
@Table(name="g1cf_pubb")
@NamedQuery(name="G1cfPubb.findAll", query="SELECT g FROM G1cfPubb g")
public class G1cfPubb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="cl_where_ult")
	private String clWhereUlt;

	@Column(name="cl_where_vis")
	private String clWhereVis;

	private BigDecimal gruppo;

	private String invioscp;

	private String nome;

	private BigDecimal numord;

	public G1cfPubb() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClWhereUlt() {
		return this.clWhereUlt;
	}

	public void setClWhereUlt(String clWhereUlt) {
		this.clWhereUlt = clWhereUlt;
	}

	public String getClWhereVis() {
		return this.clWhereVis;
	}

	public void setClWhereVis(String clWhereVis) {
		this.clWhereVis = clWhereVis;
	}

	public BigDecimal getGruppo() {
		return this.gruppo;
	}

	public void setGruppo(BigDecimal gruppo) {
		this.gruppo = gruppo;
	}

	public String getInvioscp() {
		return this.invioscp;
	}

	public void setInvioscp(String invioscp) {
		this.invioscp = invioscp;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getNumord() {
		return this.numord;
	}

	public void setNumord(BigDecimal numord) {
		this.numord = numord;
	}

}