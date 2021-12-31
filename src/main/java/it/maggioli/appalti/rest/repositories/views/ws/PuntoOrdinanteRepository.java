package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.PuntoOrdinante;

@Repository
@Transactional
public interface PuntoOrdinanteRepository extends JpaRepository<PuntoOrdinante, String>, JpaSpecificationExecutor<PuntoOrdinante> {
  @Query(value = "SELECT po.sysute FROM PuntoOrdinante po WHERE po.codice=?1 order by po.propri desc, po.numper asc")
  public List<String> getSysuteFromCodice(String codice);
}