package it.maggioli.appalti.rest.dto;

import java.util.Date;

/**
 * Interfaccia per leggere dal DB solo i dati strettamenti necessari dalla vista <code>v_ws_gare_lotti</code>
 * @see it.maggioli.appalti.rest.repositories.views.ws.EsitoRepository#findViewIEsitoLottoDto
 * @author gabriele.nencini
 *
 */
public interface IEsitoLottoDto {
  
  public String getCodice();
  
  public String getNgara();
  
  public String getCodiceinterno();
  
  public String getOggetto();
  
  public String getCodciglotto();
  
  public String getCodcupprglotto();
  
  public Double getImporto();
  
  public Double getIaggiu();
  
  public Date getDattoa();
  
  public String getStato();
  
  public String getEsito();
  
}
