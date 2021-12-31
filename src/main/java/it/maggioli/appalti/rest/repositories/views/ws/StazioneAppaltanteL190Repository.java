package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltante;
import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltanteL190;

@Repository
@Transactional
public interface StazioneAppaltanteL190Repository extends JpaRepository<StazioneAppaltanteL190, String>, JpaSpecificationExecutor<StazioneAppaltante> {
  public List<StazioneAppaltanteL190> findDistinctByDenominazioneNotNullOrderByCodiceAsc();
}