package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzioneDitta;

@Repository
@Transactional
public interface GareAnticorruzioneDittaRepository extends JpaRepository<GareAnticorruzioneDitta, Long>, JpaSpecificationExecutor<GareAnticorruzioneDitta> {
  public List<GareAnticorruzioneDitta> findByIdanticorlottiIn(Set<Long> ids);
}
