package it.maggioli.appalti.rest.specifications;

import it.maggioli.appalti.rest.entities.Impr;
import it.maggioli.appalti.rest.entities.views.ws.Esito;
import it.maggioli.appalti.rest.utils.SpecificationBuilder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class ImprSpecification {

    private static final Logger logger = LoggerFactory.getLogger(ImprSpecification.class);

    private ImprSpecification() { }

    public static Specification<Impr> getImprSpecification(
            Date dataAggiornamentoDaPortaleDa
            , Date dataAggiornamentoDaPortaleA
            , String cfOe
            , String pivaOe
            , String denomOe
            , Set<String> listaCodiceImprese
    ) {
        return (root, criteriaQuery, cb) -> {
            Predicate predicateForOrCondition = cb.disjunction();
            Predicate predicateForInCondition = cb.conjunction();
            Predicate predicateImprDirect = cb.conjunction();
            if (dataAggiornamentoDaPortaleDa != null)
                predicateImprDirect.getExpressions().add(cb.greaterThanOrEqualTo(root.get("delareg"), dataAggiornamentoDaPortaleDa));
            if (dataAggiornamentoDaPortaleA != null)
                predicateImprDirect.getExpressions().add(cb.lessThan(root.get("delareg"), dataAggiornamentoDaPortaleA));
            if (StringUtils.isNotBlank(cfOe))
                predicateImprDirect.getExpressions().add(cb.equal(root.get("cfimp"), cfOe));
            if (StringUtils.isNotBlank(pivaOe))
                predicateImprDirect.getExpressions().add(cb.equal(root.get("pivimp"), pivaOe));
            if (StringUtils.isNotBlank(denomOe))
                predicateImprDirect.getExpressions().add(cb.like(root.get("nomimp"), "%" + StringUtils.trim(denomOe) + "%"));
            if (!listaCodiceImprese.isEmpty())
                predicateForOrCondition.getExpressions().add(SpecificationBuilder.in(root, cb, new ArrayList<>(listaCodiceImprese), "codimp"));
            predicateForInCondition.getExpressions().add(predicateImprDirect);
            predicateForOrCondition.getExpressions().add(predicateForInCondition);

            return predicateForOrCondition;
        };
    }

}
