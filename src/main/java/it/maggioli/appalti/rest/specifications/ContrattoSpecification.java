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

import it.maggioli.appalti.rest.utils.SpecificationBuilder;
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
import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEstesoDataAcqCig;

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
  
  public static Specification<TraspContrattoEstesoDataAcqCig> getContrattoEstesoSpecification(String cig, String codiceStazioneAppaltante, String oggetto,Date dataPubblicazioneGaraDa,Date dataPubblicazioneGaraA, Date dataPubblicazioneEsitoDa,Date dataPubblicazioneEsitoA, Date dataAcquisizioneCigDa, Date dataAcquisizioneCigA , List<String> codein) {
    logger.info("Invoked getContrattoSpecification with dataacquisizionecig");
    return new Specification<TraspContrattoEstesoDataAcqCig>() {
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
      public Predicate toPredicate(Root<TraspContrattoEstesoDataAcqCig> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();

        p.getExpressions().add(SpecificationBuilder.in(root, cb, codein, "codiceprop"));
        
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
          p.getExpressions().add(cb.lessThanOrEqualTo(root.get("datapubbgara"), dataPubblicazioneGaraA));
        }
        
        if(dataPubblicazioneEsitoDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("datapubbesito"), dataPubblicazioneEsitoDa));
        }
        if(dataPubblicazioneEsitoA!=null) {
          p.getExpressions().add(cb.lessThanOrEqualTo(root.get("datapubbesito"), dataPubblicazioneEsitoA));
        }
        //, Date dataAcquisizioneCigDa, Date dataAcquisizioneCigA
        if(dataAcquisizioneCigDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("dataacquisizionecig"), dataAcquisizioneCigDa));
        } 
        if(dataAcquisizioneCigA!=null) {
          p.getExpressions().add(cb.lessThanOrEqualTo(root.get("dataacquisizionecig"), dataAcquisizioneCigA));
        }
        
        /*
         * create or replace view v_ws_trasp_contratti_estesa_dacqcig as
select g.ngara codice,
    case when pubblicazioni_bando.mindatpub is null then t.dpubav else pubblicazioni_bando.mindatpub end datapubbgara,
    t.dinvit datainvito,
    g.dattoa dataaggiudicazione,
    pubblicazioni_esito.mindatpub datapubbesito,
    g.codcig cig,
    uffint.codein codiceprop,
    uffint.cfein codfiscprop,
    uffint.nomein denomprop,
    g.not_gar oggetto,
    g.tipgarg,
    coalesce(tab1.tab1desc, 'NON DEFINITO') descsceltacontr,
    case when t.accqua=1 and g1.aqoper=2 then 0 else 1 end singolaaggiudicataria,
    g.ditta codaggiudicataria,
    impr.nomest descaggiudicataria, 
    impr.cfimp codfiscaggiudicataria, 
    impr.pivimp partivaaggiudicataria,
    case when (t.accqua is null or t.accqua <>'1') then g.iaggiu else gc.impqua end impaggiudic,
    case when lotticustom.lotto is null then gc.dverbc else lotticustom.datainizio end datainizio, 
    case when lotticustom.lotto is null then gc.dcertu else lotticustom.dataultimazione end datafine, 
    case when lotticustom.lotto is null then gc.impliq else lotticustom.impsommeliq_custom end impsommeliq,
    case when cu.nimpco is null then g.iaggiu else cu.nimpco end impultcontr,
    t.dtepar, t.otepar,
    t.dteoff, t.oteoff,
   case when t.dtepar is not null then
    to_timestamp(to_char(t.dtepar,'YYYY/MM/DD') || ' ' || 
     case when t.otepar is not null and length(t.otepar)=5  
     and (to_number(substr(t.otepar,1,2),'9999D0000') between 0 and 23)
     and (to_number(substr(t.otepar,4,2),'9999D0000') between 0 and 60)
     and substr(t.otepar,3,1)=':' 
     then t.otepar || ':00' else '23:59:59' end, 'YYYY/MM/DD HH24:MI:SS')::timestamp without time zone 
     else NULL end dataoraterminepar,
   case when t.dteoff is not null then
    to_timestamp(to_char(t.dteoff,'YYYY/MM/DD') || ' ' || 
     case when t.oteoff is not null and length(t.oteoff)=5  
     and (to_number(substr(t.oteoff,1,2),'9999D0000') between 0 and 23)
     and (to_number(substr(t.oteoff,4,2),'9999D0000') between 0 and 60)
     and substr(t.oteoff,3,1)=':'
     then t.oteoff || ':00' else '23:59:59' end, 'YYYY/MM/DD HH24:MI:SS')::timestamp without time zone
     else NULL end dataoratermineoff
     ,coalesce(g.dacqcig,g3.dacqcig) as dataacquisizionecig
from gare g inner join torn t on (g.codgar1=t.codgar)
    inner join gare1 g1 on (g.ngara=g1.ngara)
    left outer join gare g3 on (g3.codgar1=t.codgar) and g3.genere = 3
    left outer join v_ws_gare_pubb_esito pubblicazioni_esito on (pubblicazioni_esito.codgar=t.codgar)
    left outer join v_dati_lotti_pubblicazioni pubblicazioni_bando on (pubblicazioni_bando.codgar9=t.codgar)
    left outer join uffint on (t.cenint=uffint.codein)
    left outer join tab2 on (tab2.tab2cod = 'A1z05' and (tab2.tab2tip = g.tipgarg or (',' || tab2.tab2d2 || ',') like ('%,' || cast(g.tipgarg as text) || ',%')))
    left outer join tab1 on (tab1.tab1cod = 'A2044' and tab1tip = tab2.tab2tip)
    left outer join impr on (g.ditta=impr.codimp)
    left outer join garecont gc on ((gc.codimp=g.ditta or gc.codimp is null) and ((gc.ngara=g.ngara and gc.ncont=1)
            or (gc.ngara=g.codgar1 and (gc.ngaral is null or gc.ngaral=g.ngara))))
    left outer join v_dati_lotti_completa_custom lotticustom on (lotticustom.lotto = g.ngara)
    left outer join v_ws_trasp_contratti_ult_contr cu on (cu.codlav=g.clavor and cu.nappal=g.numera and g.ditta is not null)
where (g.genere is null or g.genere<>3) and g.codcig is not null;
         */
        
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
        
        p.getExpressions().add(SpecificationBuilder.in(root, cb, codein, "codiceprop"));

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
        
        if(dataPubblicazioneEsitoDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("datapubbesito"), dataPubblicazioneEsitoDa));
        } 
        if(dataPubblicazioneEsitoA!=null) {
          p.getExpressions().add(cb.lessThanOrEqualTo(root.get("datapubbesito"), dataPubblicazioneEsitoA));
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
