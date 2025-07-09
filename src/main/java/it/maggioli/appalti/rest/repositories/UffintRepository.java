package it.maggioli.appalti.rest.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.maggioli.appalti.rest.entities.Uffint;

@Repository
@Transactional
public interface UffintRepository extends PagingAndSortingRepository<Uffint, String> {
	public List<Uffint> findByCfein(String cfein);
	
	@Query("select distinct u.codein from Uffint u")
	public List<String> findOnlyCodein();
}
