package it.maggioli.appalti.rest.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.maggioli.appalti.rest.entities.Cais;

@Repository
@Transactional
public interface CaisRepository extends PagingAndSortingRepository<Cais, String> {

	List<Cais> findByisarchiNot(String isarchi);
	List<Cais> findByIsarchiNotAndCaisim(String isarchi, String caisim);
	
}
