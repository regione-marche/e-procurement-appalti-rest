package it.maggioli.appalti.rest.functions;

import java.util.function.Function;

import org.springframework.beans.BeanUtils;

import it.maggioli.appalti.rest.dto.GaraAnticorruzioneDittaDto;
import it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzioneDitta;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzioneDitta GareAnticorruzioneDitta} in uno di tipo 
 * {@link it.maggioli.appalti.rest.dto.GaraAnticorruzioneDittaDto GaraAnticorruzioneDittaDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformGareAnticorruzioneDittaToGareAnticorruzioneDittaDto
    implements Function<GareAnticorruzioneDitta, GaraAnticorruzioneDittaDto> {

  @Override
  public GaraAnticorruzioneDittaDto apply(GareAnticorruzioneDitta t) {
    GaraAnticorruzioneDittaDto ga = new GaraAnticorruzioneDittaDto();
    BeanUtils.copyProperties(t, ga);
    return ga;
  }

}
