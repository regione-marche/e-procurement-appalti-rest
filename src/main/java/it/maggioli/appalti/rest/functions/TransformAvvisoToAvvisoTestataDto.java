package it.maggioli.appalti.rest.functions;

import java.text.SimpleDateFormat;
import java.util.function.Function;

import it.maggioli.appalti.rest.dto.AvvisoTestataDto;
import it.maggioli.appalti.rest.entities.views.ws.Avviso;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link it.maggioli.appalti.rest.entities.views.ws.Avviso Avviso} in uno di tipo 
 * {@link it.maggioli.appalti.rest.dto.AvvisoTestataDto AvvisoTestataDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformAvvisoToAvvisoTestataDto implements Function<Avviso, AvvisoTestataDto> {
  private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  @Override
  public AvvisoTestataDto apply(Avviso t) {
    AvvisoTestataDto at = new AvvisoTestataDto();
    if(t.getDatpub()!=null)
      at.setDataPubblicazione(sdfDate.format(t.getDatpub()));
    if(t.getDataorascadenza()!=null)
      at.setDataScadenza(sdfDate.format(t.getDataorascadenza()));
    at.setRiferimentoProcedura(t.getCodice());
    at.setStazioneAppaltante(t.getDescsa());
    at.setTipologiaAppalto(t.getDesctipoapp());
    at.setTitolo(t.getOggetto());
    at.setTipologiaAvviso(t.getDesctipoavv());
    at.setDataUltimaModifica(t.getDultagg());
    return at;
  }

}
