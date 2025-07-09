package it.maggioli.appalti.rest.repositories.views.ws;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEstesoDataAcqCig;

public interface TraspContrattoEstesoDataAcqCigRepository extends JpaRepository<TraspContrattoEstesoDataAcqCig, String>, JpaSpecificationExecutor<TraspContrattoEstesoDataAcqCig> {

}
