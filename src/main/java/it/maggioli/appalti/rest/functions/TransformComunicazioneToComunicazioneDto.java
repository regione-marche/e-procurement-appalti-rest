package it.maggioli.appalti.rest.functions;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import it.maggioli.appalti.rest.dto.ComunicazioneDto;
import it.maggioli.appalti.rest.entities.views.ws.Comunicazione;
import it.maggioli.appalti.rest.entities.views.ws.ComunicazioneDocumento;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link it.maggioli.appalti.rest.entities.views.ws.Comunicazione Comunicazione} in uno di tipo 
 * {@link it.maggioli.appalti.rest.dto.ComunicazioneDto ComunicazioneDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformComunicazioneToComunicazioneDto implements Function<Comunicazione, ComunicazioneDto> {

  private TransformComunicazioneDocumentoToComunicazioneDocumentoDto function;

  /**
   * Constructor
   * @param function - {@link TransformComunicazioneDocumentoToComunicazioneDocumentoDto}
   */
  public TransformComunicazioneToComunicazioneDto(TransformComunicazioneDocumentoToComunicazioneDocumentoDto function) {
    this.function = function;
  }

  @Override
  public ComunicazioneDto apply(Comunicazione t) {
    ComunicazioneDto com = new ComunicazioneDto();
    com.setDataPubblicazione(t.getDataorainvio());
    com.setOggetto(t.getCommsgogg());
    com.setTesto(t.getCommsgtes());
    com.setIdcomunicazione(t.getIdcom());
    List<ComunicazioneDocumento> listDocs = t.getComunicazioni();
    if (listDocs != null && listDocs.size() > 0) {
      com.setDocumentiComunicazione(listDocs.stream().map(function::apply).collect(Collectors.toList()));
    }
    return com;
  }

}
