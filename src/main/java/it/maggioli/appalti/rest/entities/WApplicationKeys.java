package it.maggioli.appalti.rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="W_APPLICATION_KEYS")
public class WApplicationKeys {
  @Id
  private String clientid;
  private String chiave;
  private String note;
  
  /**
   * @return the clientid
   */
  public String getClientid() {
    return clientid;
  }
  
  /**
   * @param clientid the clientid to set
   */
  public void setClientid(String clientid) {
    this.clientid = clientid;
  }
  
  /**
   * @return the chiave
   */
  public String getChiave() {
    return chiave;
  }
  
  /**
   * @param chiave the chiave to set
   */
  public void setChiave(String chiave) {
    this.chiave = chiave;
  }
  
  /**
   * @return the note
   */
  public String getNote() {
    return note;
  }
  
  /**
   * @param note the note to set
   */
  public void setNote(String note) {
    this.note = note;
  }
  
  
}
