package it.maggioli.appalti.rest.anticor.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.anticor.entities.Anticor;

@Repository
@Transactional
public interface AnticorRepository  extends JpaRepository<Anticor, Long>, JpaSpecificationExecutor<Anticor>{
	
  public Optional<Anticor> findOneByCompletatoOrderByAnnorifDesc(String completato);
  public Optional<Anticor> findByAnnorifAndCodein(Integer annorif,String codein);

  @Query(nativeQuery = true, value = "select count(*) from anticor where codein = :stazioneAppaltante and annorif = :annoRifPrec and completato = '1'")
  public int checkAnnoPrec(@Param("stazioneAppaltante") String stazioneAppaltante,@Param("annoRifPrec") int annoRifPrec);
  
  @Query(nativeQuery = true, value = "select max(annorif) as annoRif from anticor where codein = :stazioneAppaltante")
  public Integer maxAnnorifBySa(@Param("stazioneAppaltante") String stazioneAppaltante);
  
  @Query(nativeQuery = true, value = "  select id from anticor where codein = :stazioneAppaltante and annorif = (select max(annorif) as annoRif from anticor where codein = :stazioneAppaltante)")
  public Long getIdbymaxAnnorifAndSa(@Param("stazioneAppaltante") String stazioneAppaltante);
  
  @Query(nativeQuery = true, value = "  select annorif from anticor where codein = :stazioneAppaltante")
  public List<Integer> getAnnorifBySA(@Param("stazioneAppaltante") String stazioneAppaltante);
}
