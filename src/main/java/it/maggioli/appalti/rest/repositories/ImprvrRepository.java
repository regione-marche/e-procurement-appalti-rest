package it.maggioli.appalti.rest.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.maggioli.appalti.rest.entities.Imprvr;

@Repository
@Transactional
public interface ImprvrRepository extends PagingAndSortingRepository<Imprvr, Long> {

}
