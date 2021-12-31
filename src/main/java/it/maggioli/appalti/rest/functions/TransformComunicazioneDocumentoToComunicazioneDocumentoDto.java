package it.maggioli.appalti.rest.functions;

import java.util.function.Function;

import it.maggioli.appalti.rest.dto.ComunicazioneDocumentoDto;
import it.maggioli.appalti.rest.entities.views.ws.ComunicazioneDocumento;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link it.maggioli.appalti.rest.entities.views.ws.ComunicazioneDocumento ComunicazioneDocumento} in uno di tipo 
 * {@link it.maggioli.appalti.rest.dto.ComunicazioneDocumentoDto ComunicazioneDocumentoDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformComunicazioneDocumentoToComunicazioneDocumentoDto
    implements Function<ComunicazioneDocumento, ComunicazioneDocumentoDto> {

  @Override
  public ComunicazioneDocumentoDto apply(ComunicazioneDocumento t) {
    ComunicazioneDocumentoDto cdd = new ComunicazioneDocumentoDto();
    cdd.setDataPubblicazione(t.getDatpub());
    cdd.setDescrizione(t.getDescdoc());
    cdd.setIddocumento(t.getIddoc());
    cdd.setNomefile(t.getFiledoc());
    return cdd;
  }

}
