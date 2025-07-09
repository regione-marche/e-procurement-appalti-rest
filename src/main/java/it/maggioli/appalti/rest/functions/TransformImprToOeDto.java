package it.maggioli.appalti.rest.functions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import it.maggioli.appalti.rest.dto.OperatoreEconomicoDto;
import it.maggioli.appalti.rest.entities.Impr;
import it.maggioli.appalti.rest.entities.Ragimp;

@Component
@SuppressWarnings("java:S3749")
public class TransformImprToOeDto implements Function<Impr, OperatoreEconomicoDto> {
  private Map<String,String> mapProv;
  private Map<Integer,String> mapNaz;
  
  
  /**
   * @param mapNaz the mapNaz to set
   */
  public void setMapNaz(Map<Integer, String> mapNaz) {
    this.mapNaz = mapNaz;
  }
  
  /**
   * @param mapProv the mapProv to set
   */
  public void setMapProv(Map<String, String> mapProv) {
    this.mapProv = mapProv;
  }
  @Override
  public OperatoreEconomicoDto apply(Impr t) {
    OperatoreEconomicoDto oe = createFromImpr(t);
    if(t.getTipimp()!= null && (t.getTipimp()==3 || t.getTipimp()==10)) {
      oe.setRti(Boolean.TRUE);
      oe.setRaggruppamento(t.getRaggruppamento().parallelStream().map(el->createFromRagimp(el)).collect(Collectors.toList()));
    }
    return oe;
  }
  
  private OperatoreEconomicoDto createFromRagimp(Ragimp ri) {
    OperatoreEconomicoDto oe = createFromImpr(ri.getId().getCoddic());
    oe.setMandataria(Boolean.valueOf("1".equals(ri.getImpman())));
    return oe;
  }
  private OperatoreEconomicoDto createFromImpr(Impr t) {
    OperatoreEconomicoDto oe = new OperatoreEconomicoDto();
    oe.setCap(t.getCapimp());
    oe.setCellulare(t.getTelcel());
    oe.setCivico(t.getNciimp());
    oe.setCodice(t.getCodimp());
    oe.setCodiceFiscale(t.getCfimp());
    oe.setCodiceIstat(t.getPcciaa());
    oe.setComune(t.getLocimp());
    oe.setDenominazione(t.getNomimp());
    oe.setEmail(t.getEmaiip());
    oe.setFax(t.getFaximp());
    oe.setIndirizzo(t.getIndimp());
    if(t.getNazimp()!=null) {
      oe.setNazione(String.valueOf(t.getNazimp()));
      if(this.mapNaz!=null) {
        oe.setNazione(this.mapNaz.get(t.getNazimp()));
      }
    }
    oe.setPartitaIva(t.getPivimp());
    oe.setPec(t.getEmai2ip());
    oe.setProvinciaEstesa(t.getProimp());
    oe.setProvinciaSigla(t.getProimp());
    oe.setSito(t.getIndweb());
    oe.setTelefono(t.getTelimp());
    if(this.mapProv!=null) {
      oe.setProvinciaEstesa(this.mapProv.getOrDefault(t.getProimp(), t.getProimp()));
    }
//    oe.setUltimaDataAggiornamento(t.getDelareg());
    return oe;
  }

}
