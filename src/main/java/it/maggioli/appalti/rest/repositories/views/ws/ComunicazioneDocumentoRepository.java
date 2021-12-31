package it.maggioli.appalti.rest.repositories.views.ws;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.views.ws.ComunicazioneDocumento;

@Repository
@Transactional
public interface ComunicazioneDocumentoRepository extends JpaRepository<ComunicazioneDocumento, Long>, JpaSpecificationExecutor<ComunicazioneDocumento> {
  @Query("SELECT cd FROM ComunicazioneDocumento cd WHERE idprg = ?1 AND idcom = ?2 AND iddoc = ?3 AND filedoc = ?4")
  public ComunicazioneDocumento findByIdprg_idcom_iddoc_filedoc(String idprg, Long idcom, Long iddoc, String filedoc);
}
