package it.maggioli.appalti.rest.specifications;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.criteria.Subquery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import it.maggioli.appalti.rest.entities.views.GareStatoEsito;
import it.maggioli.appalti.rest.entities.views.GareStatoEsitoLotti;
import it.maggioli.appalti.rest.entities.views.ws.AderenteLotto;
import it.maggioli.appalti.rest.entities.views.ws.GareLotti;
import it.maggioli.appalti.rest.entities.views.ws.TraspContratto;
import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEsteso;

public class ContrattoSpecification {

  private static final Logger logger      = LoggerFactory.getLogger(ContrattoSpecification.class);
  private static final String DOLLAR_CHAR = "$";

  public static String addDollarCharForTorn_codgar(String codgar) {
    return DOLLAR_CHAR + codgar;
  }

  public static Specification<TraspContratto> getContrattoSpecification(String cig, String codiceStazioneAppaltante, String oggetto, Date dataPubblicazioneEsitoDa,Date dataPubblicazioneEsitoA) {
    logger.info("Invoked getContrattoSpecification");
    return new Specification<TraspContratto>() {
      /*
       * <select id="getProspettoContratto" parameterClass="java.util.HashMap" resultMap="resultProspettoContratti">
      SELECT cig,codiceprop,codfiscprop,denomprop,oggetto,descsceltacontr,descaggiudicataria,impaggiudic,datainizio,datafine,
            impsommeliq,codice, NULL impultcontr
      FROM v_ws_trasp_contratti
      WHERE 1=1
        <isNotEmpty property="cig"  prepend="AND"> UPPER(cig)=#cig# </isNotEmpty>
        <isNotEmpty property="stazioneAppaltante"  prepend="AND"> 
        (codiceprop = #stazioneAppaltante#
         OR EXISTS (SELECT cenint FROM v_ws_aderente_lotto al 
                    WHERE (v_ws_trasp_contratti.codice = al.ngara OR v_ws_trasp_contratti.codice = al.codice)   
                    AND al.cenint = #stazioneAppaltante#)) 
        </isNotEmpty>
        <isNotEmpty property="oggetto"  prepend="AND"> UPPER(oggetto) like #oggetto# </isNotEmpty>
        <!-- <isNotEmpty property="tipoAppalto" prepend="AND"> tipgarg = #tipoAppalto#</isNotEmpty> -->
        <isNotEmpty property="dataPubblicazioneEsitoDa"  prepend="AND"> <![CDATA[ datapubbesito >= #dataPubblicazioneEsitoDa# ]]></isNotEmpty>
        <isNotEmpty property="dataPubblicazioneEsitoA"  prepend="AND"> <![CDATA[ datapubbesito <= #dataPubblicazioneEsitoA#  ]]></isNotEmpty>
      </select>
       */
      private static final long serialVersionUID = 1L;
      
      @Override
      public Predicate toPredicate(Root<TraspContratto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        
        if (StringUtils.hasText(codiceStazioneAppaltante)) {
          Predicate p2 = cb.disjunction();
          p2.getExpressions().add(cb.equal(root.get("codiceprop"), codiceStazioneAppaltante));
          Subquery<AderenteLotto> subquery = query.subquery(AderenteLotto.class);
          Root<AderenteLotto> subroot = subquery.from(AderenteLotto.class);
          Predicate sameCodice = cb.equal(subroot.get("codice"), root.get("codice"));
          Predicate sameNgara = cb.equal(subroot.get("ngara"), root.get("codice"));
          Predicate p3 = cb.disjunction();
          p3.getExpressions().add(sameCodice);
          p3.getExpressions().add(sameNgara);
          
          p2.getExpressions().add(cb.exists(subquery.select(subroot).where(p3)));
          
          p.getExpressions().add(p2);
        }
        if (StringUtils.hasText(cig)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("cig")), "%" + cig.toUpperCase() + "%"));
        }
        if (StringUtils.hasText(oggetto)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("oggetto")), "%" + oggetto.toUpperCase() + "%"));
        }
        if(dataPubblicazioneEsitoDa!=null && dataPubblicazioneEsitoA!=null) {
          p.getExpressions().add(cb.between(root.get("datapubbesito"), dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA));
        } else if(dataPubblicazioneEsitoDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("datapubbesito"), dataPubblicazioneEsitoDa));
        } else if(dataPubblicazioneEsitoA!=null) {
          p.getExpressions().add(cb.lessThan(root.get("datapubbesito"), dataPubblicazioneEsitoA));
        }
        
        return p;
      }
      
    };
  }
  public static Specification<TraspContrattoEsteso> getContrattoEstesoSpecification(String cig, String codiceStazioneAppaltante, String oggetto,Date dataPubblicazioneGaraDa,Date dataPubblicazioneGaraA, Date dataPubblicazioneEsitoDa,Date dataPubblicazioneEsitoA, List<String> codein) {
    logger.info("Invoked getContrattoSpecification");
    return new Specification<TraspContrattoEsteso>() {
    /*
     * <select id="getProspettoContratto" parameterClass="java.util.HashMap" resultMap="resultProspettoContratti">
      SELECT cig,codiceprop,codfiscprop,denomprop,oggetto,descsceltacontr,descaggiudicataria,impaggiudic,datainizio,datafine,
            impsommeliq,codice, NULL impultcontr
      FROM v_ws_trasp_contratti
      WHERE 1=1
        <isNotEmpty property="cig"  prepend="AND"> UPPER(cig)=#cig# </isNotEmpty>
        <isNotEmpty property="stazioneAppaltante"  prepend="AND"> 
        (codiceprop = #stazioneAppaltante#
         OR EXISTS (SELECT cenint FROM v_ws_aderente_lotto al 
                    WHERE (v_ws_trasp_contratti.codice = al.ngara OR v_ws_trasp_contratti.codice = al.codice)   
                    AND al.cenint = #stazioneAppaltante#)) 
        </isNotEmpty>
        <isNotEmpty property="oggetto"  prepend="AND"> UPPER(oggetto) like #oggetto# </isNotEmpty>
        <!-- <isNotEmpty property="tipoAppalto" prepend="AND"> tipgarg = #tipoAppalto#</isNotEmpty> -->
        <isNotEmpty property="dataPubblicazioneEsitoDa"  prepend="AND"> <![CDATA[ datapubbesito >= #dataPubblicazioneEsitoDa# ]]></isNotEmpty>
        <isNotEmpty property="dataPubblicazioneEsitoA"  prepend="AND"> <![CDATA[ datapubbesito <= #dataPubblicazioneEsitoA#  ]]></isNotEmpty>
      </select>
     */
      private static final long serialVersionUID = 1L;

      @Override
      public Predicate toPredicate(Root<TraspContrattoEsteso> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        
        if(codein.size()<=1000) { // know issue with rdbms with "in" containing more than 1000 objects
          In<String> inForUffint = cb.in(root.get("codiceprop"));
          for(String s : codein) {
            inForUffint.value(s);
          }
          p.getExpressions().add(inForUffint);
        } else {
          Predicate pIn = cb.disjunction();
          In<String> inForUffint = cb.in(root.get("codiceprop"));
          for(int i=0;i<codein.size();i++) {
            inForUffint.value(codein.get(i));
            if(i>0 && i%100 == 0) {
              pIn.getExpressions().add(inForUffint);
              inForUffint = cb.in(root.get("codiceprop"));
            }
          }
          p.getExpressions().add(pIn);
        }
        
        if (StringUtils.hasText(codiceStazioneAppaltante)) {
          Predicate p2 = cb.disjunction();
          p2.getExpressions().add(cb.equal(root.get("codiceprop"), codiceStazioneAppaltante));
          Subquery<AderenteLotto> subquery = query.subquery(AderenteLotto.class);
          Root<AderenteLotto> subroot = subquery.from(AderenteLotto.class);
          Predicate sameCodice = cb.equal(subroot.get("codice"), root.get("codice"));
          Predicate sameNgara = cb.equal(subroot.get("ngara"), root.get("codice"));
          Predicate p3 = cb.disjunction();
          p3.getExpressions().add(sameCodice);
          p3.getExpressions().add(sameNgara);
          
          p2.getExpressions().add(cb.exists(subquery.select(subroot).where(p3)));

          p.getExpressions().add(p2);
        }
        if (StringUtils.hasText(cig)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("cig")), "%" + cig.toUpperCase() + "%"));
        }
        if (StringUtils.hasText(oggetto)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("oggetto")), "%" + oggetto.toUpperCase() + "%"));
        }
        //dataPubblicazioneGaraDa,dataPubblicazioneGaraA,
        if(dataPubblicazioneGaraDa!=null && dataPubblicazioneGaraA!=null) {
          p.getExpressions().add(cb.between(root.get("datapubbgara"), dataPubblicazioneGaraDa, dataPubblicazioneGaraA));
        } else if(dataPubblicazioneGaraDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("datapubbgara"), dataPubblicazioneGaraDa));
        } else if(dataPubblicazioneGaraA!=null) {
          p.getExpressions().add(cb.lessThan(root.get("datapubbgara"), dataPubblicazioneGaraA));
        }
        
        if(dataPubblicazioneEsitoDa!=null && dataPubblicazioneEsitoA!=null) {
          p.getExpressions().add(cb.between(root.get("datapubbesito"), dataPubblicazioneEsitoDa, dataPubblicazioneEsitoA));
        } else if(dataPubblicazioneEsitoDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("datapubbesito"), dataPubblicazioneEsitoDa));
        } else if(dataPubblicazioneEsitoA!=null) {
          p.getExpressions().add(cb.lessThan(root.get("datapubbesito"), dataPubblicazioneEsitoA));
        }

        return p;
      }

    };
  }

  public static Specification<GareLotti> getEsitoLottoSpecification(String codiceGara) {
    /*
     * <select id="getLottiEsito" parameterClass="java.lang.String" resultMap="resultLottoEsito"> SELECT gl.codice, ngara, codiceinterno,
     * gl.oggetto, codciglotto, codcupprglotto, importo, iaggiu, dattoa, case when tipologia in (1,4) then gsel.stato else gse.stato end
     * stato, case when tipologia in (1,4) then gsel.esito else gse.esito end esito FROM v_ws_gare_lotti gl left outer join
     * v_gare_statoesito gse on (gl.ngara=gse.codice) left outer join v_gare_statoesitolotti gsel on (gl.ngara=gsel.codice) WHERE gl.codice
     * = #codiceGara# ORDER BY tipologia ASC, ngara ASC </select>
     */
    return new Specification<GareLotti>() {

      private static final long serialVersionUID = 1L;

      @Override
      public Predicate toPredicate(Root<GareLotti> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        In<Object> inForIterGara = cb.in(root.get("tipologia"));
        inForIterGara.value(1);
        inForIterGara.value(4);
        Join<GareLotti, GareStatoEsito> joinGareStatoEsito = root.join("garaStatoEsito", JoinType.LEFT);
        Join<GareLotti, GareStatoEsitoLotti> joinGareStatoEsitoLotti = root.join("gareStatoEsitoLotti", JoinType.LEFT);

        Selection<Object> selStato = cb.selectCase().when(inForIterGara, joinGareStatoEsito.get("stato")).otherwise(
            joinGareStatoEsitoLotti.get("stato")).alias("stato");
        Selection<Object> selEsito = cb.selectCase().when(inForIterGara, joinGareStatoEsito.get("esito")).otherwise(
            joinGareStatoEsitoLotti.get("esito")).alias("esito");

        query.multiselect(root.get("codice"), root.get("ngara"), root.get("codiceinterno"), root.get("oggetto"),
            root.get("codciglotto").alias("cig"), root.get("codcupprglotto").alias("cup"), root.get("importo"), root.get("iaggiu"),
            root.get("dattoa"), selStato, selEsito);
        // query.where(cb.equal(root.get("codice"),codiceGara));
        query.orderBy(cb.desc(root.get("dataesito")));
        Predicate p = cb.conjunction();
        p.getExpressions().add(cb.equal(root.get("codice"), codiceGara));
        return p;
      }
    };
  }
}
