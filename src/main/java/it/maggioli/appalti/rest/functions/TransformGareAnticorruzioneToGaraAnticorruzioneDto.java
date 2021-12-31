package it.maggioli.appalti.rest.functions;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;

import it.maggioli.appalti.rest.dto.GaraAntiCorruzioneDto;
import it.maggioli.appalti.rest.dto.GaraAnticorruzioneDittaDto;
import it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzione;

/**
 * Questa funzione permette di trasformare {@link GareAnticorruzione} in {@link GaraAnticorruzioneDittaDto}
 * @author gabriele.nencini
 *
 */
public class TransformGareAnticorruzioneToGaraAnticorruzioneDto implements Function<GareAnticorruzione, GaraAntiCorruzioneDto> {

  private Map<Long, Map<String, List<GaraAnticorruzioneDittaDto>>> mapsForAll;
  
  public void setMapsForAll(final Map<Long, Map<String, List<GaraAnticorruzioneDittaDto>>> mapsForAll) {
    this.mapsForAll = mapsForAll;
  }
  
  @Override
  public GaraAntiCorruzioneDto apply(GareAnticorruzione t) {
    GaraAntiCorruzioneDto dto = new GaraAntiCorruzioneDto();
    BeanUtils.copyProperties(t, dto);
    Map<String, List<GaraAnticorruzioneDittaDto>> data = this.mapsForAll.get(t.getIdanticorlotti());
    if(data!=null) {
      if(data.get("1")!=null) dto.setAssegnatari(data.get("1"));
      if(data.get("2")!=null) dto.setPartecipanti(data.get("2"));
    }
    return dto;
  }

}
