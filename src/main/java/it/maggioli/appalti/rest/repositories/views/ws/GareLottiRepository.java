package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.GareLotti;

@Repository
@Transactional
public interface GareLottiRepository extends JpaRepository<GareLotti, String>, JpaSpecificationExecutor<GareLotti> {
  public List<GareLotti> findAllByCodice(String codice);
  public Stream<GareLotti> findAllByNgaraInAndAggiudicatariaNotNull(Collection<String> ids);
}
