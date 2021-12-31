package it.maggioli.appalti.rest.repositories.views.ws;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzione;

@Repository
@Transactional
public interface GareAnticorruzioneRepository extends JpaRepository<GareAnticorruzione, Long>, JpaSpecificationExecutor<GareAnticorruzione> {

}
