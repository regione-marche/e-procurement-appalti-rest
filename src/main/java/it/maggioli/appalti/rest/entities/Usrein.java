package it.maggioli.appalti.rest.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import it.maggioli.appalti.rest.entities.identities.UsreinIdentity;

@Entity
@Table(name="usr_ein")
public class Usrein {
  @EmbeddedId
  private UsreinIdentity id;
  
  public UsreinIdentity getId() {
    return id;
  }
  
  public void setId(UsreinIdentity id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Usrein [" + (id != null ? "id=" + id : "") + "]";
  }
  
}
