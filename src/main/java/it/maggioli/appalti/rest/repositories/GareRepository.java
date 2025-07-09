package it.maggioli.appalti.rest.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.Gare;

@Repository
@Transactional
public interface GareRepository extends PagingAndSortingRepository<Gare, String> {
  public List<Gare> findByCodcigAndTornCenintIn(String codcig, Collection<String> uffint);
}
