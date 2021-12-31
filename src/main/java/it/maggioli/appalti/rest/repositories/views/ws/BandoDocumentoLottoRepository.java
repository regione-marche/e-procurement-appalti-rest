package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.BandoDocumento;

@Repository
@Transactional
public interface BandoDocumentoLottoRepository extends JpaRepository<BandoDocumento, Long>, JpaSpecificationExecutor<BandoDocumento> {
  public List<BandoDocumento> findByCodiceInOrderByNumord(Collection<String> codici);
  /*
   * <select id="getAttiDocumentiBandoGara" ...>
  SELECT iddoc, urldoc, descdoc, filedoc, datpub 
    FROM v_ws_gare_documenti
   WHERE codice = #codiceGara#
     AND (gruppo = 10 OR gruppo = 15)
   ORDER BY datpub desc 
  </select>s
   */
  @Query("SELECT bd FROM BandoDocumento bd WHERE bd.codice = :codice AND bd.gruppo IN (10,15) ORDER BY dataPubblicazione DESC")
  public List<BandoDocumento> findAttiDocumentiBando(String codice);
  
}
