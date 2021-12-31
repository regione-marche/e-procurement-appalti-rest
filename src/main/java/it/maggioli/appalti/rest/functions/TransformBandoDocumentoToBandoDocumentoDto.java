package it.maggioli.appalti.rest.functions;

import java.util.function.Function;

import it.maggioli.appalti.rest.dto.BandoDocumentoDto;
import it.maggioli.appalti.rest.entities.views.ws.BandoDocumento;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link it.maggioli.appalti.rest.entities.views.ws.BandoDocumento BandoDocumento} in uno di tipo 
 * {@link it.maggioli.appalti.rest.dto.BandoDocumentoDto BandoDocumentoDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformBandoDocumentoToBandoDocumentoDto implements Function<BandoDocumento, BandoDocumentoDto> {

  @Override
  public BandoDocumentoDto apply(BandoDocumento t) {
    BandoDocumentoDto bdd = new BandoDocumentoDto();
    bdd.setDataPubblicazione(t.getDataPubblicazione());
    bdd.setDescrizione(t.getDescrizione());
    bdd.setId(t.getId());
    bdd.setNomefile(t.getNomefile());
    bdd.setUrl(t.getUrl());
    return bdd;
  }

}
