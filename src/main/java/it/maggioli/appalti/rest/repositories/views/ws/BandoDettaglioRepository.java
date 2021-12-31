package it.maggioli.appalti.rest.repositories.views.ws;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.BandoDettaglio;

@Repository
@Transactional
public interface BandoDettaglioRepository extends JpaRepository<BandoDettaglio, String>, JpaSpecificationExecutor<BandoDettaglio> {

}
