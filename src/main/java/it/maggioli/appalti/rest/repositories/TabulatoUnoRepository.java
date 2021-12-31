package it.maggioli.appalti.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.dto.TabulatoDto;
import it.maggioli.appalti.rest.entities.TabUno;

/**
 * Repository per l'entità TabUno
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface TabulatoUnoRepository extends JpaRepository<TabUno, String> {
  
  //PROBABLY FOUND BUG ON JPA IF TABLE AND COLUMN NAMES CONTAINS NUMBERS
  @Query(value = "select new it.maggioli.appalti.rest.dto.TabulatoDto(t.id,t.descrizione) from TabUno t where t.codice = ?1 "
      + "order by t.ordinamento asc,t.id asc")
  public List<TabulatoDto> findDtoByCodiceOrderByOrdinamento(String codice);
  //corrected query from WS Appalti
  @Query(value = "select new it.maggioli.appalti.rest.dto.TabulatoDto(t.id,t.descrizione) from TabUno t where t.codice = ?1 "
      + "and (t.archiviato is null or t.archiviato='2')"
      + "order by t.ordinamento asc,t.id asc")
  public List<TabulatoDto> findDtoByCodiceFilteringArchOrderByOrdinamento(String codice);
}
