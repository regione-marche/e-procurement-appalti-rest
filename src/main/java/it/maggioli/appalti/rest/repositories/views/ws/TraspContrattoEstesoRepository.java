package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.ITraspContrattoCountGroupByCodice;
import it.maggioli.appalti.rest.entities.views.ws.ITraspContrattoEstesoCountGroupByCodiceAndCodprop;
import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEsteso;

@Repository
@Transactional
public interface TraspContrattoEstesoRepository extends JpaRepository<TraspContrattoEsteso, String>, JpaSpecificationExecutor<TraspContrattoEsteso> {

  /**
   * Questo metodo esegue la seguente query: <pre><code>
   * SELECT count(tc.codice) AS nelem
   *   ,tc.codice
   * FROM TraspContrattoEsteso tc
   * WHERE tc.singolaaggiudicataria = 1
   * GROUP BY tc.codice
   * HAVING count(tc.codice) > 1
   * </code></pre>
   * 
   * @return {@link Stream} di {@link ITraspContrattoCountGroupByCodice}
   */
  @Transactional(readOnly = true)
  @Query(value = "SELECT count(tc.codice) as nelem,tc.codice,tc.codiceprop FROM TraspContrattoEsteso tc WHERE tc.singolaaggiudicataria = 1 GROUP BY tc.codice,tc.codiceprop HAVING count(tc.codice)>1")
  public Stream<ITraspContrattoEstesoCountGroupByCodiceAndCodprop> getTraspContrattoCountGreaterThanOneGroupByCodice();
  
  /**
   * Ricerca se il contratto è ad aggiudicataria multipla
   * @param codice - il codice del contratto da verificare
   * @return <code>true</code> se è ad aggiudicataria multipla, <code>false</code> altrimenti 
   */
  @Transactional(readOnly = true)
  @Query(value = "SELECT count(tc.codice) > 1 as nelem FROM TraspContrattoEsteso tc WHERE tc.singolaaggiudicataria = 1 AND tc.codice = :codice")
  public Boolean isMultiplaAggiudicataria(@Param("codice") String codice);
}
