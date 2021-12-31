package it.maggioli.appalti.rest.repositories.views.ws;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.Avviso;

@Repository
@Transactional
public interface AvvisoRepository extends JpaRepository<Avviso, String>, JpaSpecificationExecutor<Avviso> {

}
