package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.PuntoIstruttore;

@Repository
@Transactional
public interface PuntoIstruttoreRepository extends JpaRepository<PuntoIstruttore, String>, JpaSpecificationExecutor<PuntoIstruttore> {
  @Query(value = "SELECT pi.sysute FROM PuntoIstruttore pi WHERE pi.codice=?1 order by pi.propri desc, pi.numper asc")
  public List<String> getSysuteFromCodice(String codice);
}