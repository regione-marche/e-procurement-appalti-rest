package it.maggioli.appalti.rest.repositories.views.ws;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.maggioli.appalti.rest.entities.views.ws.AdempimentiAnticor;
import it.maggioli.appalti.rest.entities.views.ws.identities.AdempimentiAnticorIdentity;

public interface AdempimentiAnticorRepository extends JpaRepository<AdempimentiAnticor, AdempimentiAnticorIdentity> {
  public Page<AdempimentiAnticor> findAllByIdentityAnnorif(Pageable pageable, Integer annorif);
}
