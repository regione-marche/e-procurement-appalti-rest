package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Classe per la definizione della chiave primaria della tabella {@code Garecont}
 * <br> {@link it.maggioli.appalti.rest.entities.Garecont Garecont}
 * @author gabriele.nencini
 *
 */
@Embeddable
public class GarecontIdentity implements Serializable{

  private static final long serialVersionUID = 1L;
  private String ngara;
  private Integer ncont;
  
  /**
   * @return the ngara
   */
  public String getNgara() {
    return ngara;
  }
  
  /**
   * @param ngara the ngara to set
   */
  public void setNgara(String ngara) {
    this.ngara = ngara;
  }
  
  /**
   * @return the ncont
   */
  public Integer getNcont() {
    return ncont;
  }
  
  /**
   * @param ncont the ncont to set
   */
  public void setNcont(Integer ncont) {
    this.ncont = ncont;
  }

  @Override
  public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ncont == null) ? 0 : ncont.hashCode());
	result = prime * result + ((ngara == null) ? 0 : ngara.hashCode());
	return result;
  }

  @Override
  public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	GarecontIdentity other = (GarecontIdentity) obj;
	if (ncont == null) {
		if (other.ncont != null)
			return false;
	} else if (!ncont.equals(other.ncont))
		return false;
	if (ngara == null) {
		if (other.ngara != null)
			return false;
	} else if (!ngara.equals(other.ngara))
		return false;
	return true;
  }
}
