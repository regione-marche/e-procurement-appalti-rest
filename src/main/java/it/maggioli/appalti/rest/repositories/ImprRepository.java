package it.maggioli.appalti.rest.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import it.maggioli.appalti.rest.entities.Impr;

@Repository
@Transactional
public interface ImprRepository extends PagingAndSortingRepository<Impr, String>,QueryByExampleExecutor<Impr>,JpaSpecificationExecutor<Impr> {
  public List<Impr> findAllByCodimpIn(Collection<String> ids);
  
  @Query(value = "select i.codimp from Impr i where i.nazimp=:nazimp")
  public Set<String> findCodimpByNazimp(@Param(value = "nazimp") Integer nazimp);
  
  @Query(value = "select new it.maggioli.appalti.rest.entities.Impr(i.codimp, i.emai2ip, i.emaiip) from Impr i where i.codimp = :codimp")
  public Impr findEmailsById(@Param(value = "codimp") String codimp);
  
}
