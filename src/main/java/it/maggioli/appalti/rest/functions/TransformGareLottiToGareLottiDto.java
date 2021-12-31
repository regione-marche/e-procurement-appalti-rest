package it.maggioli.appalti.rest.functions;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import it.maggioli.appalti.rest.dto.GareLottiDto;
import it.maggioli.appalti.rest.entities.views.ws.GareCategorie;
import it.maggioli.appalti.rest.entities.views.ws.GareLotti;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link GareLotti} in uno di tipo 
 * {@link GareLottiDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformGareLottiToGareLottiDto implements Function<GareLotti, GareLottiDto> {
  private final TransformGareCategorieToCategoriePrestazioniDto function;
  
  /**
   * Constructor
   * @param function - {@link TransformGareCategorieToCategoriePrestazioniDto}
   */
  public TransformGareLottiToGareLottiDto(final TransformGareCategorieToCategoriePrestazioniDto function) {
    this.function = function;
  }

  @Override
  public GareLottiDto apply(GareLotti t) {
    GareLottiDto gld = new GareLottiDto();
    gld.setRiferimentoProcedura(t.getCodice());
    gld.setTitolo(t.getOggetto());
    gld.setImportoBaseGara(t.getImporto());
    gld.setCodiceGara(t.getNgara());
    List<GareCategorie> categorie = t.getCategoriePrestazioni();
    if(categorie!=null && categorie.size()>0) {
      gld.setCategoriePrestazioni(categorie.stream().map(e->this.function.apply(e)).collect(Collectors.toList()));
    }
    return gld;
  }

}
