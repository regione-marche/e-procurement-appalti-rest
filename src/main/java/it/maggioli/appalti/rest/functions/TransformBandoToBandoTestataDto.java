package it.maggioli.appalti.rest.functions;

import java.text.SimpleDateFormat;
import java.util.function.Function;

import it.maggioli.appalti.rest.dto.BandoTestataDto;
import it.maggioli.appalti.rest.entities.views.ws.Bando;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link it.maggioli.appalti.rest.entities.views.ws.Bando Bando} in uno di tipo 
 * {@link it.maggioli.appalti.rest.dto.BandoTestataDto BandoTestataDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformBandoToBandoTestataDto implements Function<Bando, BandoTestataDto> {
  private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private SimpleDateFormat sdfDate2 = new SimpleDateFormat("yyyy-MM-dd");
  
  @Override
  public BandoTestataDto apply(Bando bando) {
    BandoTestataDto dto = new BandoTestataDto();
    dto.setCig(bando.getCig());
    if(bando.getDataPubblicazione()!=null) {
      dto.setDataPubblicazione(sdfDate.format(bando.getDataPubblicazione()));
    }
    if(bando.getDataTermine()!=null) {
      dto.setDataScadenza(sdfDate2.format(bando.getDataTermine())+(bando.getOraTermine()!=null?" "+bando.getOraTermine()+":00":""));
    }
    dto.setImporto(bando.getImporto());
    dto.setRiferimentoProcedura(bando.getCodice());
    dto.setStato(bando.getStato());
    dto.setStazioneAppaltante(bando.getStazioneAppaltante());
    dto.setTipologiaAppalto(bando.getTipoAppalto());
    dto.setTitolo(bando.getOggetto());
    dto.setDataUltimaModifica(bando.getDataUltimaModifica());
    return dto;
  }

}
