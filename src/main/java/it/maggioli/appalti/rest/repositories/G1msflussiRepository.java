package it.maggioli.appalti.rest.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.maggioli.appalti.rest.entities.G1msflussi;

@Repository
@Transactional
public interface G1msflussiRepository extends PagingAndSortingRepository<G1msflussi, Long> {

	
}
