package it.maggioli.appalti.rest.repositories;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.Winvcom;
import it.maggioli.appalti.rest.entities.identities.WinvcomIdentity;

@Repository
@Transactional
public interface WinvcomRepository extends PagingAndSortingRepository<Winvcom, WinvcomIdentity> {
  public List<Winvcom> findAllByComtipoAndComstatoAndComdatastatoBetweenOrderByComdatastatoAsc(String tipo, String stato,Date from, Date to);
  public List<Winvcom> findAllByComtipoAndComstatoAndComdatastatoAfterOrderByComdatastatoAsc(String tipo, String stato,Date from);
  public List<Winvcom> findAllByComtipoAndComstatoAndComdatastatoBeforeOrderByComdatastatoAsc(String tipo, String stato,Date to);
}
