package it.maggioli.appalti.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.Wlogeventi;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface WlogEventiRepository extends JpaRepository<Wlogeventi, Long>{
  
}
