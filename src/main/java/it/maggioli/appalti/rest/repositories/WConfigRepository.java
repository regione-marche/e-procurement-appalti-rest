package it.maggioli.appalti.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.WConfig;
import it.maggioli.appalti.rest.entities.identities.WConfigIdentity;

/**
 * Repository per l'entità WConfig
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface WConfigRepository extends JpaRepository<WConfig, WConfigIdentity> {
  /*
   * from w_config where codapp = '<param>'
   */
  public List<WConfig> findByIdCodapp(String codapp);
}
