package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.Collection;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.GareNAggiudicatari;
import it.maggioli.appalti.rest.entities.views.ws.identities.GareNAggiudicatariIdentity;

@Repository
@Transactional
public interface GareNAggiudicatariRepository extends JpaRepository<GareNAggiudicatari, GareNAggiudicatariIdentity>, JpaSpecificationExecutor<GareNAggiudicatari> {
  /*
   * select * from v_ws_gare_n_aggiudicatari where codice = ? order by numord
   */
  public Stream<GareNAggiudicatari> findByIdentityCodiceOrderByNumord(String codice);
  /*
   * select * from v_ws_gare_n_aggiudicatari where codice in (?,?) order by codice,numord
   */
  public Stream<GareNAggiudicatari> findByIdentityCodiceInOrderByIdentityCodiceAscNumordAsc(Collection<String> codice);
}
