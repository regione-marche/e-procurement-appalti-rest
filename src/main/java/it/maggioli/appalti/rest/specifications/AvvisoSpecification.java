package it.maggioli.appalti.rest.specifications;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import it.maggioli.appalti.rest.entities.views.ws.Avviso;
import it.maggioli.appalti.rest.enums.StatoInCorsoScadutoEnum;

public class AvvisoSpecification {
  
  private static final Logger logger = LoggerFactory.getLogger(AvvisoSpecification.class);
  private static final String DOLLAR_CHAR = "$";
  public static String addDollarCharForTorn_codgar(String codgar) {
    return DOLLAR_CHAR + codgar;
  }
  
  public static Specification<Avviso> getAvvisoSpecification(final String stazioneAppaltante,
      final String oggetto,
      final Integer tipoAvviso,
      final Date dataPubblicazioneDa,
      final Date dataPubblicazioneA,
      final Date dataScadenzaDa,
      final Date dataScadenzaA,
      final Integer altriSoggetti,
      final StatoInCorsoScadutoEnum statoInCorsoScaduto,
      final Integer annoMinimoPubblicazione,
      final Date dataUltimaModificaDA,
      final Date dataUltimaModificaA){
    logger.info("Invoked getBandoSpecification");
    return new Specification<Avviso>() {

      private static final long serialVersionUID = 1L;
      @Override
      public Predicate toPredicate(Root<Avviso> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("annoinizioperscadenza"),annoMinimoPubblicazione));
        
        if(StatoInCorsoScadutoEnum.SCADUTO.equals(statoInCorsoScaduto)) {
          p.getExpressions().add(cb.lessThan(root.get("dataorascadenza"), new Date()));
        } else {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("dataorascadenza"), new Date()));          
        }
        
        if(StringUtils.hasText(stazioneAppaltante)) {
          p.getExpressions().add(cb.equal(root.get("codsa"), stazioneAppaltante));
        }
        if(StringUtils.hasText(oggetto)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("oggetto")), "%" +oggetto.toUpperCase()+"%"));
        }
        if(tipoAvviso!=null) {
          p.getExpressions().add(cb.equal(root.get("codtipoavv"), tipoAvviso));
        }
        if(dataPubblicazioneDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("datpub"), dataPubblicazioneDa));
        }
        if(dataPubblicazioneA!=null) {
          p.getExpressions().add(cb.lessThanOrEqualTo(root.get("datpub"), dataPubblicazioneA));
        }
        if(dataScadenzaDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("dataorascadenza"), dataScadenzaDa));
        }
        if(dataScadenzaA!=null) {
          p.getExpressions().add(cb.lessThanOrEqualTo(root.get("dataorascadenza"), dataScadenzaA));
        }
        if(altriSoggetti!=null) {
          p.getExpressions().add(cb.equal(root.get("altriSoggetti"), altriSoggetti));
        }
        
        if(dataUltimaModificaA!=null && dataUltimaModificaDA!=null) {
          p.getExpressions().add(cb.between(root.get("dultagg"), dataUltimaModificaDA, dataUltimaModificaA));
        } else if(dataUltimaModificaA!=null) {
          p.getExpressions().add(cb.lessThan(root.get("dultagg"), dataUltimaModificaA));
        } else if(dataUltimaModificaDA!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("dultagg"), dataUltimaModificaDA));
        }
        
        query.orderBy(
                cb.asc(root.get("dataorascadenza")),
                cb.asc(root.get("datpub"))
        );
        return p;
      }
      
    };
  }
  
}
