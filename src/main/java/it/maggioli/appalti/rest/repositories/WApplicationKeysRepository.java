package it.maggioli.appalti.rest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.WApplicationKeys;

/**
 * Repository per l'entità TabUno
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface WApplicationKeysRepository extends JpaRepository<WApplicationKeys, String> {
  public Optional<WApplicationKeys> findByClientidIgnoreCaseAndChiave(String clientid,String chiave);
}
