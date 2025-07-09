package it.maggioli.appalti.rest.specifications;

import java.util.Date;

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
import it.maggioli.appalti.rest.entities.views.ws.Esito;
import it.maggioli.appalti.rest.entities.views.ws.GareLotti;

public class EsitoSpecification {
  
  private static final Logger logger = LoggerFactory.getLogger(EsitoSpecification.class);
  private static final String DOLLAR_CHAR = "$";
  public static String addDollarCharForTorn_codgar(String codgar) {
    return DOLLAR_CHAR + codgar;
  }
  
  public static Specification<Esito> getEsitoSpecification(final String stazioneAppaltante,
      final String oggetto,
      final String cig,
      final Integer tipoAppalto,
      final Date dataPubblicazioneDa,
      final Date dataPubblicazioneA,
      final Boolean proceduraTelematica,
      final Integer altriSoggetti,
      final Boolean sommaUrgenza,
      final Integer annoMinimoPubblicazione,
      final Date dataUltimaModificaDA,
      final Date dataUltimaModificaA){
    logger.info("Invoked getBandoSpecification");
    return new Specification<Esito>() {

      private static final long serialVersionUID = 1L;
      // from iBatis getElencoBandiScaduti merged with getElencoBandi
      /*
       * <select id="searchEsiti" parameterClass="java.util.HashMap" resultMap="resultEsito">
           <include refid="selectListaEsiti"/>
           <include refid="whereEsiti"/>
           ORDER BY dataesito DESC
          </select>
          <sql id="selectListaEsiti">
            SELECT descsa as sa, codice, oggetto, codcig, codcupprg, tipologia, desctipoapp as tipoapp, descstatogara as stato, dataesito, datpub, descstatoesito as esito, gartel, isaccordoquadro, 
                  dultagg, sommaur
              FROM v_ws_esiti
            </sql>
          
       * <sql id="whereEsiti" >
        WHERE <![CDATA[#annoMinimoPubblicazione# <= annoinizioperscadenza]]>
        AND garpriv IS NULL
           <isNotEmpty property="stazioneAppaltante" prepend="AND"> 
           (codsa = #stazioneAppaltante#
            OR EXISTS (SELECT cenint FROM v_ws_aderente_lotto al WHERE v_ws_esiti.codice = al.codice AND al.cenint = #stazioneAppaltante#)) 
           </isNotEmpty> 
           <isNotEmpty property="oggetto" prepend="AND"> $operatoreUpper$(oggetto) like #oggetto#</isNotEmpty> 
           <isNotEmpty property="tipoAppalto" prepend="AND"> codtipoapp = #tipoAppalto#</isNotEmpty> 
           <isNotEmpty property="cig" prepend="AND"> EXISTS (SELECT codgar FROM v_ws_gare_lotti l WHERE v_ws_esiti.codgar = l.codgar AND $operatoreUpper$(l.codciglotto) like #cig#)</isNotEmpty>  
           <isNotEmpty property="dataPubblicazioneDa" prepend="AND"><![CDATA[ dataesito >= #dataPubblicazioneDa#]]></isNotEmpty> 
           <isNotEmpty property="dataPubblicazioneA" prepend="AND"><![CDATA[ dataesito <= #dataPubblicazioneA#]]></isNotEmpty> 
           <isNotEmpty property="proceduraTelematica" prepend="AND"> gartel = #proceduraTelematica#</isNotEmpty> 
           <isNotEmpty property="sommaUrgenza" prepend="AND"> (case when sommaur='1' then 1 else 0 end) = #sommaUrgenza# </isNotEmpty>
           <isNotEmpty property="altriSoggetti" prepend="AND"> altrisog = #altriSoggetti#</isNotEmpty>
        </sql>
       */
      @Override
      public Predicate toPredicate(Root<Esito> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("annoinizioperscadenza"),annoMinimoPubblicazione));
        p.getExpressions().add(cb.isNull(root.get("garpriv")));
        
        if(StringUtils.hasText(stazioneAppaltante)) {
          Predicate p2 = cb.disjunction();
          p2.getExpressions().add(cb.equal(root.get("codsa"), stazioneAppaltante));
          Subquery<AderenteLotto> subquery = query.subquery(AderenteLotto.class);
          Root<AderenteLotto> subroot = subquery.from(AderenteLotto.class);
          Predicate sameCodice = cb.equal(subroot.get("codice"), root.get("codice"));
          Predicate isCenint = cb.equal(subroot.get("cenint"), stazioneAppaltante);
          p2.getExpressions().add(cb.exists(subquery.select(subroot).where(sameCodice, isCenint)));
          
          p.getExpressions().add(p2);
        }
        if(StringUtils.hasText(cig)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("codcig")), "%" +cig.toUpperCase()+"%"));
        }
        if(StringUtils.hasText(oggetto)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("oggetto")), "%"+oggetto.toUpperCase()+"%"));
        }
        if(tipoAppalto!=null) {
          p.getExpressions().add(cb.equal(root.get("codtipoapp"), tipoAppalto));
        }
        if(dataPubblicazioneDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("dataesito"), dataPubblicazioneDa));
        }
        if(dataPubblicazioneA!=null) {
          p.getExpressions().add(cb.lessThanOrEqualTo(root.get("dataesito"), dataPubblicazioneA));
        }
        if(proceduraTelematica!=null) {
          p.getExpressions().add(cb.equal(root.get("gartel"), proceduraTelematica.booleanValue()));
        }
        if(altriSoggetti!=null) {
          p.getExpressions().add(cb.equal(root.get("altrisog"), altriSoggetti));
        }
        if(sommaUrgenza!=null) {
          p.getExpressions().add(cb.equal(root.get("sommaur"), sommaUrgenza));
        }
        
        if(dataUltimaModificaA!=null && dataUltimaModificaDA!=null) {
          p.getExpressions().add(cb.between(root.get("dultagg"), dataUltimaModificaDA, dataUltimaModificaA));
        } else if(dataUltimaModificaA!=null) {
          p.getExpressions().add(cb.lessThan(root.get("dultagg"), dataUltimaModificaA));
        } else if(dataUltimaModificaDA!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("dultagg"), dataUltimaModificaDA));
        }
        
        query.orderBy(
                cb.desc(root.get("dataesito"))
        );
        return p;
      }
      
    };
  }
  
  
  public static Specification<GareLotti> getEsitoLottoSpecification(String codiceGara){
    /*
     * <select id="getLottiEsito" parameterClass="java.lang.String" resultMap="resultLottoEsito">
        SELECT gl.codice, ngara, codiceinterno, gl.oggetto, codciglotto, codcupprglotto, importo, iaggiu, dattoa,
               case when tipologia in (1,4) then gsel.stato else gse.stato end stato,
               case when tipologia in (1,4) then gsel.esito  else gse.esito end esito 
          FROM v_ws_gare_lotti gl 
               left outer join v_gare_statoesito gse on (gl.ngara=gse.codice)
               left outer join v_gare_statoesitolotti gsel on (gl.ngara=gsel.codice)
         WHERE gl.codice = #codiceGara#
         ORDER BY tipologia ASC, ngara ASC
        </select>
     */
    return new Specification<GareLotti>() {

      private static final long serialVersionUID = 1L;

      @Override
      public Predicate toPredicate(Root<GareLotti> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        In<Object> inForIterGara = cb.in(root.get("tipologia"));
        inForIterGara.value(1);
        inForIterGara.value(4);
        Join<GareLotti,GareStatoEsito> joinGareStatoEsito = root.join("garaStatoEsito",JoinType.LEFT);
        Join<GareLotti,GareStatoEsitoLotti> joinGareStatoEsitoLotti = root.join("gareStatoEsitoLotti",JoinType.LEFT);
        
        Selection<Object> selStato = cb.selectCase().when(inForIterGara, joinGareStatoEsito.get("stato")).otherwise(joinGareStatoEsitoLotti.get("stato")).alias("stato");
        Selection<Object> selEsito = cb.selectCase().when(inForIterGara, joinGareStatoEsito.get("esito")).otherwise(joinGareStatoEsitoLotti.get("esito")).alias("esito");
        
        
        query.multiselect(root.get("codice"),root.get("ngara"),root.get("codiceinterno"),
            root.get("oggetto"),root.get("codciglotto").alias("cig"),root.get("codcupprglotto").alias("cup"),
            root.get("importo"),root.get("iaggiu"),root.get("dattoa"),selStato,selEsito
              );
//        query.where(cb.equal(root.get("codice"),codiceGara));
        query.orderBy(
            cb.desc(root.get("dataesito"))
            );
        Predicate p = cb.conjunction();
        p.getExpressions().add(cb.equal(root.get("codice"),codiceGara));
        return  p;
      }};
  }
}
