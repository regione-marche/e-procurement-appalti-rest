package it.maggioli.appalti.rest.functions;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.function.Function;

import it.maggioli.appalti.rest.dto.EsitoTestataDto;
import it.maggioli.appalti.rest.entities.views.ws.Esito;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link it.maggioli.appalti.rest.entities.views.ws.Esito Esito} in uno di tipo 
 * {@link it.maggioli.appalti.rest.dto.EsitoTestataDto EsitoTestataDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformEsitoToEsitoTestataDto implements Function<Esito, EsitoTestataDto> {
  private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  @Override
  public EsitoTestataDto apply(Esito t) {
    EsitoTestataDto etd = new EsitoTestataDto();
    etd.setCig(t.getCodcig());
    if(Objects.nonNull(t.getDataesito()))
      etd.setDataPubblicazione(sdfDate.format(t.getDataesito()));
    etd.setImporto(t.getImporto());
    etd.setRiferimentoProcedura(t.getCodice());
    etd.setStato(t.getDescstatoesito());
    etd.setStazioneAppaltante(t.getDescsa());
    etd.setTipologiaAppalto(t.getDesctipoapp());
    etd.setTitolo(t.getOggetto());
    if(Objects.nonNull(t.getDultagg()))
      etd.setDataUltimaModifica(t.getDultagg());
    return etd;
  }

}
