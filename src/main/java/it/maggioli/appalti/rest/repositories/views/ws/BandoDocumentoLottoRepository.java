package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.BandoDocumento;

@Repository
@Transactional
public interface BandoDocumentoLottoRepository extends JpaRepository<BandoDocumento, Long>, JpaSpecificationExecutor<BandoDocumento> {
  @Query("SELECT bd FROM BandoDocumento bd WHERE bd.codice = :codice AND bd.gruppo IN (10,15) ORDER BY dataPubblicazione DESC")
  List<BandoDocumento> findAttiDocumentiBando(@Param("codice") String codice);

  @Query("select b from BandoDocumento b where b.id = ?1 and b.codice = ?2 and b.nomefile = ?3 and b.gruppo in ?4")
  BandoDocumento findByIdAndCodiceAndNomefileAndGruppoIn(Long id, String codice, String nomefile,
                                                         Collection<Integer> gruppos);

  @Query("select b from BandoDocumento b " +
          "where b.id = ?1 and b.codice = ?2 and b.ngara = ?3 and b.nomefile = ?4 and b.gruppo in ?5")
  BandoDocumento findByIdAndCodiceAndNgaraAndNomefileAndGruppoIn(Long id, String codice, String ngara, String nomefile,
                                                                 Collection<Integer> gruppos);

  @Query("select b from BandoDocumento b " +
          "where b.id = ?1 and b.codice = ?2 and b.ngara IS NULL or b.ngara = '' and b.nomefile = ?3 and b.gruppo in ?4")
  BandoDocumento findEsitoFile(Long id, String codice, String nomefile, Collection<Integer> gruppos);

}
