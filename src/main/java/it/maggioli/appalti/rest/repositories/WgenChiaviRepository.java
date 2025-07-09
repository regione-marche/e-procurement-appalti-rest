package it.maggioli.appalti.rest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.WgenChiavi;

/**
 * Repository per la tabella {@code w_genchiavi}
 * i metodi 
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface WgenChiaviRepository extends JpaRepository<WgenChiavi, String> {

  @Transactional(propagation = Propagation.MANDATORY)
  @Override
  public Optional<WgenChiavi> findById(String id);
  
  @Transactional(propagation = Propagation.MANDATORY)
  public Optional<WgenChiavi> findByTabellaIgnoreCase(String id);
  
  @Transactional(propagation = Propagation.MANDATORY)
  @Modifying
  @Query(value = "UPDATE WgenChiavi w SET w.chiave = w.chiave + :incremento WHERE UPPER(w.tabella) = UPPER(:tabella)")
  public void incrementChiavePerTabella(@Param(value = "incremento") long incremento,@Param(value = "tabella") String tabella);

}
