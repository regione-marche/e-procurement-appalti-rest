package it.maggioli.appalti.rest.functions;

import java.util.function.Function;

import it.maggioli.appalti.rest.dto.CategoriePrestazioniDto;
import it.maggioli.appalti.rest.entities.views.ws.GareCategorie;

/**
 * Funzione che transforma un oggetto di tipo 
 * {@link GareCategorie} in uno di tipo 
 * {@link CategoriePrestazioniDto}
 * @author gabriele.nencini
 * @see Function
 */
public class TransformGareCategorieToCategoriePrestazioniDto implements Function<GareCategorie, CategoriePrestazioniDto> {

  @Override
  public CategoriePrestazioniDto apply(GareCategorie t) {
    CategoriePrestazioniDto cpd = new CategoriePrestazioniDto();
    cpd.setCategoriaPrestazione(t.getDescrizione());
    cpd.setCodice(t.getCodice());
    cpd.setPerlavori(t.getPerlavori());
    cpd.setPrevalentePrincipale(t.getPrevalente());
    return cpd;
  }

}
