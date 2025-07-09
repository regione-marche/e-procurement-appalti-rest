package it.maggioli.appalti.rest.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="w_puser")
public class Wpuser implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private String iduser;
  private String usernome;
  private String userent;
  private String userkey1;
  
  /**
   * @return the iduser
   */
  public String getIduser() {
    return iduser;
  }
  
  /**
   * @param iduser the iduser to set
   */
  public void setIduser(String iduser) {
    this.iduser = iduser;
  }
  
  /**
   * @return the usernome
   */
  public String getUsernome() {
    return usernome;
  }
  
  /**
   * @param usernome the usernome to set
   */
  public void setUsernome(String usernome) {
    this.usernome = usernome;
  }
  
  /**
   * @return the userent
   */
  public String getUserent() {
    return userent;
  }
  
  /**
   * @param userent the userent to set
   */
  public void setUserent(String userent) {
    this.userent = userent;
  }
  
  /**
   * @return the userkey1
   */
  public String getUserkey1() {
    return userkey1;
  }
  
  /**
   * @param userkey1 the userkey1 to set
   */
  public void setUserkey1(String userkey1) {
    this.userkey1 = userkey1;
  }
  
  
}
