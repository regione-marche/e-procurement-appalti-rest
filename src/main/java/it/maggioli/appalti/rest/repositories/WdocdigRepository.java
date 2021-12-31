package it.maggioli.appalti.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.Wdocdig;
import it.maggioli.appalti.rest.entities.identities.WdocdigIdentity;

/**
 * Repository per l'entità Wdocdig
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface WdocdigRepository extends JpaRepository<Wdocdig, WdocdigIdentity> {

}
