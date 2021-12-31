package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoPartecipante;

@Repository
@Transactional
public interface TraspContrattoPartecipanteRepository extends JpaRepository<TraspContrattoPartecipante, String>, JpaSpecificationExecutor<TraspContrattoPartecipante> {
  public Stream<TraspContrattoPartecipante> findAllByCodice(String codice);
}
