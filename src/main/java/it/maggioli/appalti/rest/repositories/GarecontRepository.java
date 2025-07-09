package it.maggioli.appalti.rest.repositories;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.maggioli.appalti.rest.entities.Garecont;
import it.maggioli.appalti.rest.entities.identities.GarecontIdentity;

@Repository
@Transactional
public interface GarecontRepository extends PagingAndSortingRepository<Garecont, GarecontIdentity> {
  /*
   * join gare g on g.codgar1=t.codgar and (g.genere is null or g.genere <> 3)-- lotti
 left join gare gg3 on gg3.codgar1=t.codgar and gg3.genere = 3
 left join gare1 g1 on g1.codgar1=g.codgar1 and g1.ngara=g.ngara  -- lotti campi aggiuntivi (cui)
 left join garcpv cpv on cpv.ngara=g.ngara and tipcpv=1  -- cpv
 join ditg d on d.codgar5=g.codgar1 and d.ngara5=g.ngara and d.dittao=g.ditta  -- ditta aggiudicataria; non consideriamo AQ a piu operatori
 join garecont gc on ((gc.codimp=g.ditta or gc.codimp is null) and ((gc.ngara=g.ngara and gc.ncont=1) or (gc.ngara=g.codgar1 and (gc.ngaral is null or gc.ngaral=g.ngara)))) 
   */
  @Query(nativeQuery = true,value = "select gc.* from gare g "
      + "join garecont gc on ((gc.codimp=g.ditta or gc.codimp is null) "
      + "and ((gc.ngara=g.ngara and gc.ncont=1) or "
      + "(gc.ngara=g.codgar1 and (gc.ngaral is null or gc.ngaral=g.ngara)))) "
      + "where (g.genere is null or g.genere <> 3) and g.codcig = :cig")
  public List<Garecont> findForUpdate(@Param("cig") String cig);
  
  @Query(nativeQuery = true,value = "select gc.* from gare g "
                                    + "join garecont gc on ((gc.codimp=g.ditta or gc.codimp is null) "
                                    + "and ((gc.ngara=g.ngara and gc.ncont=1) or "
                                    + "(gc.ngara=g.codgar1 and (gc.ngaral is null or gc.ngaral=g.ngara)))) "
                                    + "join torn t on t.codgar = g.codgar1 and t.cenint in (:uffint) "
                                    + "where (g.genere is null or g.genere <> 3) and g.codcig = :cig")
  public List<Garecont> findForUpdateWithUffint(@Param("cig") String cig,@Param("uffint") Collection<String> uffint);
  
  @Query("select gc from Gare g "
		  + "join Garecont gc on ((gc.codimp=g.ditta or gc.codimp is null) "
          + "and ((gc.id.ngara=g.ngara and gc.id.ncont=1) or "
          + "(gc.id.ngara=g.torn.codgar and (gc.ngaral is null or gc.ngaral=g.ngara)))) "
          + "join g.torn t "
          + "where t.cenint in (:uffint) and (g.genere is null or g.genere <> 3) and g.codcig = :cig "
          + "and g.ditta is not null ")
  public List<Garecont> findForUpdateWithUffintHQL(@Param("cig") String cig,@Param("uffint") Collection<String> uffint);

  @Query("select g.ditta from Gare g "
          + "join g.torn t "
          + "where t.cenint in (:uffint) and (g.genere is null or g.genere <> 3) and g.codcig = :cig "
          )
  public String checkForUpdateWithUffintHQL(@Param("cig") String cig,@Param("uffint") Collection<String> uffint);
  
  
}
