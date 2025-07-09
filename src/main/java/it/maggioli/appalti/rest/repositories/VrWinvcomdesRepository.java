package it.maggioli.appalti.rest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.VrWInvcomdes;
import it.maggioli.appalti.rest.entities.identities.VrWInvcomdesPK;

@Repository
@Transactional
public interface VrWinvcomdesRepository extends PagingAndSortingRepository<VrWInvcomdes, VrWInvcomdesPK> {

}
