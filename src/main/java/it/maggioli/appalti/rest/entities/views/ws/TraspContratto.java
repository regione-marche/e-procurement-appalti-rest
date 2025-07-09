package it.maggioli.appalti.rest.entities.views.ws;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_ws_trasp_contratti")
public class TraspContratto extends TraspContrattoBasic {
  
  
}
