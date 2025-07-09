package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.dto.IEsitoLottoDto;
import it.maggioli.appalti.rest.entities.views.ws.Esito;

@Repository
@Transactional
public interface EsitoRepository extends JpaRepository<Esito, String>, JpaSpecificationExecutor<Esito> {
  @Query(nativeQuery = true,value = "SELECT gl.codice, ngara, codiceinterno, gl.oggetto, codciglotto, " +
      "               codcupprglotto, importo, iaggiu, dattoa," + 
      "               case when tipologia in (1,4) then gsel.stato else gse.stato end stato," + 
      "               case when tipologia in (1,4) then gsel.esito  else gse.esito end esito " + 
      "          FROM v_ws_gare_lotti gl " + 
      "               left outer join v_gare_statoesito gse on (gl.ngara=gse.codice)" + 
      "               left outer join v_gare_statoesitolotti gsel on (gl.ngara=gsel.codice)" + 
      "         WHERE gl.codice = :codiceGara" + 
      "         ORDER BY tipologia ASC, ngara ASC")
  public List<IEsitoLottoDto> findViewIEsitoLottoDto(@Param(value = "codiceGara") String codiceGara);

  /**
  * {@code @Query("select} (count(e) > 0) from Esito e where e.codice = ?1 and e.isaccordoquadro = ?2 and e.naggiudicatari = ?3")
   */
  boolean existsByCodiceAndIsaccordoquadroAndNaggiudicatari(String codice, Boolean isaccordoquadro, Integer naggiudicatari);

}
