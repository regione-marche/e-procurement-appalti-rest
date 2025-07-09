package it.maggioli.appalti.rest.repositories;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.TabTre;
import it.maggioli.appalti.rest.entities.identities.TabTreIdentity;

/**
 * Repository per l'entità TabUno
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface TabulatoTreRepository extends JpaRepository<TabTre, TabTreIdentity> {
  public Stream<TabTre> findAllByIdCodice(String codice);
  public Stream<TabTre> findAllByIdCodiceAndArchiviatoOrArchiviatoIsNull(String codice,String archiviato);
}
