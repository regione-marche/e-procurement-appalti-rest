package it.maggioli.appalti.rest.configuration.response;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "configuration")
public class ConfigurationResponse {
  private String codapp;
  private String chiave;
  private String valore;
  private String sezione;
  private String descrizione;
  private String criptato;
  
  /**
   * @return the codapp
   */
  public String getCodapp() {
    return codapp;
  }
  
  /**
   * @param codapp the codapp to set
   */
  public void setCodapp(String codapp) {
    this.codapp = codapp;
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
   * @return the valore
   */
  public String getValore() {
    return valore;
  }
  
  /**
   * @param valore the valore to set
   */
  public void setValore(String valore) {
    this.valore = valore;
  }
  
  /**
   * @return the sezione
   */
  public String getSezione() {
    return sezione;
  }
  
  /**
   * @param sezione the sezione to set
   */
  public void setSezione(String sezione) {
    this.sezione = sezione;
  }
  
  /**
   * @return the descrizione
   */
  public String getDescrizione() {
    return descrizione;
  }
  
  /**
   * @param descrizione the descrizione to set
   */
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  /**
   * @return the criptato
   */
  public String getCriptato() {
    return criptato;
  }
  
  /**
   * @param criptato the criptato to set
   */
  public void setCriptato(String criptato) {
    this.criptato = criptato;
  }

  @Override
  public String toString() {
    return "ConfigurationDto ["
        + (codapp != null ? "codapp=" + codapp + ", " : "")
        + (chiave != null ? "chiave=" + chiave + ", " : "")
        + (criptato != null ? "criptato=" + criptato : "")
        + "]";
  }
  
  
}
