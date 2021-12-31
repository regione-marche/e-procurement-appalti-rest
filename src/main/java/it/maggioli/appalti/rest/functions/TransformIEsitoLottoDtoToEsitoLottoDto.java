package it.maggioli.appalti.rest.functions;

import java.util.function.Function;

import it.maggioli.appalti.rest.dto.EsitoLottoDto;
import it.maggioli.appalti.rest.dto.IEsitoLottoDto;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link IEsitoLottoDto} in uno di tipo 
 * {@link EsitoLottoDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformIEsitoLottoDtoToEsitoLottoDto implements Function<IEsitoLottoDto, EsitoLottoDto> {

  @Override
  public EsitoLottoDto apply(IEsitoLottoDto t) {
    EsitoLottoDto eld = new EsitoLottoDto();
    eld.setTitolo(t.getOggetto());
    eld.setCig(t.getCodciglotto());
    eld.setCodiceGara(t.getNgara());
//    eld.setCodiceinterno(t.getCodiceinterno());
//    eld.setCodiceLotto(t.getNgara());
    eld.setCup(t.getCodcupprglotto());
    eld.setDataAggiudicazione(t.getDattoa());
    eld.setEsito(t.getEsito());
    eld.setImportoAggiudicazione(t.getIaggiu());
    eld.setImportoBaseGara(t.getImporto());
    eld.setStato(t.getStato());
    eld.setRiferimentoProcedura(t.getCodice());
    return eld;
  }

}
