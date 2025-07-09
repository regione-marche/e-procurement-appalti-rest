package it.maggioli.appalti.rest.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.VrWInvcom;
import it.maggioli.appalti.rest.entities.Winvcom;
import it.maggioli.appalti.rest.entities.identities.VrWInvcomPK;
import it.maggioli.appalti.rest.entities.identities.WinvcomIdentity;

@Repository
@Transactional
public interface VrWinvcomRepository extends PagingAndSortingRepository<VrWInvcom, VrWInvcomPK> {
  
	@Query(value = "SELECT MAX(i.id.idcom) FROM VrWInvcom i")
	public Long getMaxIdCom();
	
}
