package it.maggioli.appalti.rest.specifications;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzione;

/**
 * Classe che permette di effettuare query dinamiche tramite {@link Specification} per gli oggetti di tipo {@link GareAnticorruzione}
 * @author gabriele.nencini
 *
 */
public class AnticorruzioneSpecification {
  /**
   * Metodo per effettuare query dinamiche
   * 
   * @param annorif - anno di riferimento
   * @param codiceStazioneAppaltante - codice della stazione appaltante
   * @param codicegara - codice della gara
   * @param cig - cig
   * @param oggetto - oggetto dell'appalto ricerca tramite <code>like</code> e <code>case insensitive</code>
   * @param dataPubblicazione - data di pubblicazione
   * @return {@link Specification}
   */
  @Deprecated
  public static Specification<GareAnticorruzione> getAvvisoSpecification(
      final Integer annorif,
      final String codiceStazioneAppaltante,
      final String codicegara,
      final String cig,
      final String oggetto,
      final Date dataPubblicazione
      
      ){
    return new Specification<GareAnticorruzione>() {
      
      private static final long serialVersionUID = 1L;
      
      @Override
      public Predicate toPredicate(Root<GareAnticorruzione> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        if(StringUtils.hasText(codiceStazioneAppaltante)) {
          p.getExpressions().add(cb.equal(root.get("codfiscprop"), codiceStazioneAppaltante));
        }
        if(StringUtils.hasText(codicegara)) {
          p.getExpressions().add(cb.equal(root.get("codicegara"), codicegara));
        }
        if(StringUtils.hasText(cig)) {
          p.getExpressions().add(cb.equal(root.get("cig"), cig));
        }
        if(StringUtils.hasText(oggetto)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("oggetto")), "%"+oggetto.toUpperCase()+"%"));
        }
        if(annorif!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("annorif"), annorif));
        }
        if(dataPubblicazione!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("datapubbl"), dataPubblicazione));
        }
        
        return p;
      }
      
    };
  }
  /**
   * Metodo per effettuare query dinamiche
   * 
   * @param annorif - anno di riferimento
   * @param codiceStazioneAppaltante - codice della stazione appaltante
   * @param codicegara - codice della gara
   * @param cig - cig
   * @param oggetto - oggetto dell'appalto ricerca tramite <code>like</code> e <code>case insensitive</code>
   * @return {@link Specification}
   */
  public static Specification<GareAnticorruzione> getAvvisoSpecification(
      final Integer annorif,
      final String codiceStazioneAppaltante,
      final String codicegara,
      final String cig,
      final String oggetto      
      ){
    return new Specification<GareAnticorruzione>() {

      private static final long serialVersionUID = 1L;

      @Override
      public Predicate toPredicate(Root<GareAnticorruzione> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        if(StringUtils.hasText(codiceStazioneAppaltante)) {
          p.getExpressions().add(cb.equal(root.get("codfiscprop"), codiceStazioneAppaltante));
        }
        if(StringUtils.hasText(codicegara)) {
          p.getExpressions().add(cb.equal(root.get("codicegara"), codicegara));
        }
        if(StringUtils.hasText(cig)) {
          p.getExpressions().add(cb.equal(root.get("cig"), cig));
        }
        if(StringUtils.hasText(oggetto)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("oggetto")), "%"+oggetto.toUpperCase()+"%"));
        }
        if(annorif!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("annorif"), annorif));
        }
        return p;
      }
      
    };
  }
}
