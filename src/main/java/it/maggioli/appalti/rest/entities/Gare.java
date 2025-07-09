package it.maggioli.appalti.rest.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la tabella <code>gare</code> <br>
 * questa classe è marcata come <code>@Immutable</code> per evitare che
 * erroneamente si provi a modificare i dati
 * 
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "gare")
public class Gare {
	@Id
	private String ngara;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codgar1", insertable = false, updatable = false, referencedColumnName = "codgar")
	@Fetch(FetchMode.JOIN)
	private Torn torn;

	private String codcig;
	private String genere;
	private String ditta;

	public String getNgara() {
		return ngara;
	}

	public void setNgara(String ngara) {
		this.ngara = ngara;
	}

	public Torn getTorn() {
		return torn;
	}

	public void setTorn(Torn torn) {
		this.torn = torn;
	}

	/**
	 * @return the codcig
	 */
	public String getCodcig() {
		return codcig;
	}

	/**
	 * @param codcig the codcig to set
	 */
	public void setCodcig(String codcig) {
		this.codcig = codcig;
	}

	@Override
	public String toString() {
		return "Gare [" + (ngara != null ? "ngara=" + ngara + ", " : "") + (torn != null ? "torn=" + torn + ", " : "")
				+ (codcig != null ? "codcig=" + codcig : "") + "]";
	}

	/**
	 * @return the genere
	 */
	public String getGenere() {
		return genere;
	}

	/**
	 * @param genere the genere to set
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}

	/**
	 * @return the ditta
	 */
	public String getDitta() {
		return ditta;
	}

	/**
	 * @param ditta the ditta to set
	 */
	public void setDitta(String ditta) {
		this.ditta = ditta;
	}

}
