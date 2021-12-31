package it.maggioli.appalti.rest.specifications;

import java.util.Date;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import it.maggioli.appalti.rest.entities.Gare;
import it.maggioli.appalti.rest.entities.Torn;
import it.maggioli.appalti.rest.entities.views.ws.AderenteLotto;
import it.maggioli.appalti.rest.entities.views.ws.Bando;
import it.maggioli.appalti.rest.entities.views.ws.BandoDocumento;
import it.maggioli.appalti.rest.entities.views.ws.Comunicazione;
import it.maggioli.appalti.rest.entities.views.ws.ComunicazioneDocumento;
import it.maggioli.appalti.rest.enums.StatoInCorsoScadutoEnum;

public class BandoSpecification {
  
  private static final Logger logger = LoggerFactory.getLogger(BandoSpecification.class);
  private static final String DOLLAR_CHAR = "$";
  public static String addDollarCharForTorn_codgar(String codgar) {
    return DOLLAR_CHAR + codgar;
  }
  
  public static Specification<Bando> getBandoSpecification(final String stazioneAppaltante,
      final String oggetto,
      final String cig,
      final Integer tipoAppalto,
      final Date dataPubblicazioneDa,
      final Date dataPubblicazioneA,
      final Date dataScadenzaDa,
      final Date dataScadenzaA,
      final Boolean proceduraTelematica,
      final Integer stato,
      final String altriSoggetti,
      final Boolean sommaUrgenza,
      final StatoInCorsoScadutoEnum statoInCorsoScaduto,
      final Integer annoMinimoPubblicazione,
      final Date dataUltimaModificaDA,
      final Date dataUltimaModificaA){
    logger.info("Invoked getBandoSpecification");
    return new Specification<Bando>() {

      private static final long serialVersionUID = 1L;
      // from iBatis getElencoBandiScaduti merged with getElencoBandi
      /*
       * 
       * <select id="getElencoBandiScaduti" resultMap="resultBando">
          <include refid="selectListaBandi"/>
          FROM v_ws_bandi
          <include refid="whereElencoBandiScaduti"/>
         ORDER BY dattermine DESC, oratermine DESC
        </select>
       * 
       * 
       * <select id="getElencoBandi" resultMap="resultBando">
            <include refid="selectListaBandi"/>
            FROM v_ws_bandi
            <include refid="whereElencoBandi"/>
           ORDER BY dattermine ASC, oratermine ASC
          </select>
       * 
       * <sql id="whereElencoBandi">
           WHERE codstatogara = 1 AND coditergara not in (3,5,6)
             <isNotEmpty property="stazioneAppaltante" prepend="AND"> 
             (codsa = #stazioneAppaltante# 
              OR EXISTS (SELECT cenint FROM v_ws_aderente_lotto l WHERE v_ws_bandi.codice = l.codice AND l.cenint = #stazioneAppaltante#) )
             </isNotEmpty> 
             <isNotEmpty property="oggetto" prepend="AND"> $operatoreUpper$(oggetto) like #oggetto#</isNotEmpty> 
             <isNotEmpty property="cig" prepend="AND"> $operatoreUpper$(codcigall) like #cig#</isNotEmpty>  
             <isNotEmpty property="tipoAppalto" prepend="AND"> codtipoapp = #tipoAppalto#</isNotEmpty> 
             <isNotEmpty property="dataPubblicazioneDa" prepend="AND"><![CDATA[ datpub >= #dataPubblicazioneDa#]]></isNotEmpty> 
             <isNotEmpty property="dataPubblicazioneA" prepend="AND"><![CDATA[ datpub <= #dataPubblicazioneA#]]></isNotEmpty> 
             <isNotEmpty property="dataScadenzaDa" prepend="AND"><![CDATA[ dattermine >= #dataScadenzaDa#]]></isNotEmpty> 
             <isNotEmpty property="dataScadenzaA" prepend="AND"><![CDATA[ dattermine <= #dataScadenzaA#]]></isNotEmpty>
             <isNotEmpty property="proceduraTelematica" prepend="AND"> gartel = #proceduraTelematica#</isNotEmpty> 
             <isNotEmpty property="stato" prepend="AND"> codstatogara = #stato#</isNotEmpty>
             <isNotEmpty property="altriSoggetti" prepend="AND"> altrisog = #altriSoggetti#</isNotEmpty>
             <isNotEmpty property="sommaUrgenza" prepend="AND"> sommaur = #sommaUrgenza#</isNotEmpty>
          </sql>
       * 
       * <sql id="whereElencoBandiScaduti">
         WHERE <![CDATA[codstatogara <> 1 ]]>
           AND <![CDATA[#annoMinimoPubblicazione# <= annoinizioperscadenza]]>
           <isNotEmpty property="stazioneAppaltante" prepend="AND"> 
           (codsa = #stazioneAppaltante# 
            OR EXISTS (SELECT cenint FROM v_ws_aderente_lotto l WHERE v_ws_bandi.codice = l.codice AND l.cenint = #stazioneAppaltante#) )
           </isNotEmpty> 
           <isNotEmpty property="oggetto" prepend="AND"> $operatoreUpper$(oggetto) like #oggetto#</isNotEmpty>
           <isNotEmpty property="cig" prepend="AND"> $operatoreUpper$(codcigall) like #cig#</isNotEmpty> 
           <isNotEmpty property="tipoAppalto" prepend="AND"> codtipoapp = #tipoAppalto#</isNotEmpty> 
           <isNotEmpty property="dataPubblicazioneDa" prepend="AND"><![CDATA[ datpub >= #dataPubblicazioneDa#]]></isNotEmpty> 
           <isNotEmpty property="dataPubblicazioneA" prepend="AND"><![CDATA[ datpub <= #dataPubblicazioneA#]]></isNotEmpty> 
           <isNotEmpty property="dataScadenzaDa" prepend="AND"><![CDATA[ dattermine >= #dataScadenzaDa#]]></isNotEmpty> 
           <isNotEmpty property="dataScadenzaA" prepend="AND"><![CDATA[ dattermine <= #dataScadenzaA#]]></isNotEmpty>
           <isNotEmpty property="proceduraTelematica" prepend="AND"> gartel = #proceduraTelematica#</isNotEmpty> 
           <isNotEmpty property="stato" prepend="AND"> codstatogara = #stato#</isNotEmpty> 
           <isNotEmpty property="esito" prepend="AND"> descstatoesito = #esito#</isNotEmpty>  
           <isNotEmpty property="altriSoggetti" prepend="AND"> altrisog = #altriSoggetti#</isNotEmpty>
           <isNotEmpty property="sommaUrgenza" prepend="AND"> sommaur = #sommaUrgenza#</isNotEmpty>   
        </sql>
       */
      @Override
      public Predicate toPredicate(Root<Bando> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        if(StatoInCorsoScadutoEnum.INCORSO.equals(statoInCorsoScaduto)) {
          p.getExpressions().add(cb.equal(root.get("codstatogara"),1));
          
          In<Object> inForIterGara = cb.in(root.get("iterGara"));
          inForIterGara.value(3);
          inForIterGara.value(5);
          inForIterGara.value(6);
          
          p.getExpressions().add(cb.not(inForIterGara));
        } else {
          p.getExpressions().add(cb.notEqual(root.get("codstatogara"),1));
          //AND <![CDATA[#annoMinimoPubblicazione# <= annoinizioperscadenza]]>
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("annoinizioperscadenza"),annoMinimoPubblicazione));
        }
        
        
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
          p.getExpressions().add(cb.like(cb.upper(root.get("cig")), "%" +cig.toUpperCase()+"%"));
        }
        if(StringUtils.hasText(oggetto)) {
          p.getExpressions().add(cb.like(cb.upper(root.get("oggetto")), "%" +oggetto.toUpperCase()+"%"));
        }
        if(tipoAppalto!=null) {
          p.getExpressions().add(cb.equal(root.get("tipoAppalto"), tipoAppalto));
        }
        if(dataPubblicazioneDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("dataPubblicazione"), dataPubblicazioneDa));
        }
        if(dataPubblicazioneA!=null) {
          p.getExpressions().add(cb.lessThanOrEqualTo(root.get("dataPubblicazione"), dataPubblicazioneA));
        }
        if(dataScadenzaDa!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("dataTermine"), dataScadenzaDa));
        }
        if(dataScadenzaA!=null) {
          p.getExpressions().add(cb.lessThanOrEqualTo(root.get("dataTermine"), dataScadenzaA));
        }
        if(proceduraTelematica!=null) {
          p.getExpressions().add(cb.equal(root.get("proceduraTelematica"), proceduraTelematica.booleanValue()));
        }
        if(stato!=null) {
          p.getExpressions().add(cb.equal(root.get("codstatogara"), stato));
        }
        if(StringUtils.hasText(altriSoggetti)) {
          p.getExpressions().add(cb.equal(root.get("altriSoggetti"), altriSoggetti));
        }
        if(sommaUrgenza!=null) {
          p.getExpressions().add(cb.equal(root.get("sommaUrgenza"), sommaUrgenza.booleanValue()));
        }
        if(dataUltimaModificaA!=null && dataUltimaModificaDA!=null) {
          p.getExpressions().add(cb.between(root.get("dataUltimaModifica"), dataUltimaModificaDA, dataUltimaModificaA));
        } else if(dataUltimaModificaA!=null) {
          p.getExpressions().add(cb.lessThan(root.get("dataUltimaModifica"), dataUltimaModificaA));
        } else if(dataUltimaModificaDA!=null) {
          p.getExpressions().add(cb.greaterThanOrEqualTo(root.get("dataUltimaModifica"), dataUltimaModificaDA));
        }
        
        query.orderBy(
                cb.asc(root.get("dataTermine")),
                cb.asc(root.get("oraTermine"))
        );
        return p;
      }
      
    };
  }
  
  public static Specification<BandoDocumento> getBandoDocumentoLottoSpecification(final String codice,final String codiceLotto, final Set<Integer> gruppoList){
    return new Specification<BandoDocumento>() {
      private static final long serialVersionUID = 1L;
      //from mybatis
      /*
       * <select id="getDocumentiBandoLotto" parameterClass="java.util.HashMap" resultMap="resultDocumentoBando">
            SELECT iddoc, urldoc, descdoc, filedoc, datpub 
              FROM v_ws_gare_documenti
             WHERE codice = #codiceGara#
             <isEmpty property="codiceLotto" prepend="AND"> ngara is null</isEmpty>
             <isNotEmpty property="codiceLotto" prepend="AND"> ngara = #codiceLotto#</isNotEmpty>
               AND gruppo = 1
             ORDER BY numord ASC 
            </select>
            
            <select id="getDocumentiInvitoLotto" parameterClass="java.util.HashMap" resultMap="resultDocumentoBando">
            SELECT iddoc, urldoc, descdoc, filedoc, datpub
              FROM v_ws_gare_documenti
             WHERE codice = #codiceGara#
             <isEmpty property="codiceLotto" prepend="AND"> (ngara is null or ngara=#codiceGara#)</isEmpty>
             <isNotEmpty property="codiceLotto" prepend="AND"> ngara = #codiceLotto#</isNotEmpty>
               AND gruppo = 6
             ORDER BY numord ASC 
            </select>
          
            <select id="getDocumentiInvitoAstaLotto" parameterClass="java.util.HashMap" resultMap="resultDocumentoBando">
            SELECT iddoc, urldoc, descdoc, filedoc, datpub
              FROM v_ws_gare_documenti
             WHERE codice = #codiceGara#
             <isEmpty property="codiceLotto" prepend="AND"> (ngara is null or ngara=#codiceGara#)</isEmpty>
             <isNotEmpty property="codiceLotto" prepend="AND"> ngara = #codiceLotto#</isNotEmpty>
               AND gruppo = 12
             ORDER BY numord ASC 
            </select>
          
            <select id="getRequisitiRichiestiBandoLotto" parameterClass="java.util.HashMap" resultMap="resultRequisitoRichiestoBando">
            SELECT descdoc as nome, obbligatorio, ordine
              FROM v_ws_gare_documenti
             WHERE codice = #codiceGara#
             <isEmpty property="codiceLotto" prepend="AND"> ngara is null</isEmpty>
             <isNotEmpty property="codiceLotto" prepend="AND"> ngara = #codiceLotto#</isNotEmpty>
               AND gruppo = 2
             ORDER BY numord ASC 
            </select>
            
            <select id="getRequisitiRichiestiBando" parameterClass="java.util.HashMap" resultMap="resultRequisitoRichiestoLottoBando">
            SELECT descdoc as nome, obbligatorio, ordine,
                   ngara
              FROM v_ws_gare_documenti
             WHERE codice = #codiceGara#
               AND gruppo = 2
             ORDER BY ngara, numord ASC 
            </select>
       */
      @Override
      public Predicate toPredicate(Root<BandoDocumento> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        p.getExpressions().add(cb.equal(root.get("codice"),codice));
        if(StringUtils.hasText(codiceLotto)) {
          p.getExpressions().add(cb.equal(root.get("ngara"),codiceLotto));          
        } else {
          p.getExpressions().add(cb.isNull(root.get("ngara")));
        }
        logger.debug("gruppoList: {}",gruppoList);
        if(gruppoList!=null && gruppoList.size()>0) {
          if(gruppoList.size()>1) {
            final In<Integer> inForGruppo = cb.in(root.get("gruppo"));
            gruppoList.forEach(e->{inForGruppo.value(e);});
            p.getExpressions().add(inForGruppo);
          } else {
            p.getExpressions().add(cb.equal(root.get("gruppo"), gruppoList.iterator().next()));
          }
        }
        //ORDER BY
        query.orderBy(cb.asc(root.get("numord")));
        return p;
      }
      
    };
  }
  
  public static Specification<Comunicazione> getComunicazioneSpecification(final String codice, final String stazioneAppaltante){
    return new Specification<Comunicazione>() {
      private static final long serialVersionUID = 1L;
      /*
       * FROM v_ws_comunicazioni_da_sa c
         INNER JOIN gare g ON (g.ngara = c.codice)
         INNER JOIN torn t ON (t.codgar = g.codgar1)
         WHERE (t.codgar = #codice# OR t.codgar = #codice2#)
          AND (nomeuser is null)
        <isNotEmpty property="stazioneAppaltante" prepend="AND"> 
         (t.cenint = #stazioneAppaltante# 
          OR EXISTS (SELECT cenint FROM v_ws_aderente_lotto l WHERE l.ngara = g.ngara AND l.cenint = #stazioneAppaltante#) )
        </isNotEmpty>       
        ORDER BY ngara, dataorainvio DESC
       */
      @Override
      public Predicate toPredicate(Root<Comunicazione> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();

//        Join<Comunicazione,Gare> joinToGara = root.join("gara",JoinType.INNER);
//        Join<Gare,Torn> joinToTorn = joinToGara.join("torn",JoinType.INNER);
        root.fetch("gara").fetch("torn");
//        root.fetch("comunicazioni");
        Path<Gare> garaPath = root.get("gara");
        Path<Torn> tornPath = garaPath.get("torn");
        query.multiselect(root,garaPath,tornPath);
        
        p.getExpressions().add(
            cb.or(cb.equal(tornPath.get("codgar"),codice),cb.equal(tornPath.get("codgar"),addDollarCharForTorn_codgar(codice))));
//        p.getExpressions().add(
//            cb.or(cb.equal(root.get("gara").get("torn").get("codgar"),codice),
//                  cb.equal(root.get("gara").get("torn").get("codgar"),addDollarCharForTorn_codgar(codice))));
        p.getExpressions().add(cb.isNull(root.get("nomeuser")));
        if(StringUtils.hasText(stazioneAppaltante)) {
          Predicate p2 = cb.disjunction();
          p2.getExpressions().add(cb.equal(tornPath.get("cenint"), stazioneAppaltante));
          
          Subquery<AderenteLotto> subquery = query.subquery(AderenteLotto.class);
          Root<AderenteLotto> subroot = subquery.from(AderenteLotto.class);
          Predicate sameCodice = cb.equal(subroot.get("ngara"), garaPath.get("ngara"));
          Predicate isCenint = cb.equal(subroot.get("cenint"), stazioneAppaltante);
          p2.getExpressions().add(cb.exists(subquery.select(subroot).where(sameCodice, isCenint)));
          
          p.getExpressions().add(p2);
        }
        
        query.orderBy(cb.asc(garaPath.get("ngara")),
                      cb.desc(root.get("dataorainvio")));
        return p;
      }
      
    };
  }
  
  /*
   * <select id="getDocumentiComunicazioniPubblicheRicevute" parameterClass="java.util.HashMap" resultMap="resultDocumentoLottoBando">
      SELECT d.idcom, d.iddoc, null urldoc, d.descdoc, d.filedoc, d.datpub,
             null gruppo, 
             g.ngara, null codiceInterno, null oggetto, null costoFisso            
        FROM v_ws_comunicazioni_da_sa c       
              INNER JOIN gare g ON (g.ngara = c.codice)     
              INNER JOIN torn t ON (t.codgar = g.codgar1)          
              INNER JOIN v_ws_comunicazioni_documenti d ON (d.idcom=c.idcom)  
       WHERE (t.codgar = #codice# OR t.codgar = #codice2#)    
         AND (nomeuser is null)
       ORDER BY d.idcom, d.iddoc ASC   
    </select>
   */
  public static Specification<ComunicazioneDocumento> getAllegatoComunicazioneSpecification(final String codice, final String stazioneAppaltante){
    return null;
  }
  
  /*
   * <select id="getAttiDocumentiBandoGara" ...>
  SELECT iddoc, urldoc, descdoc, filedoc, datpub 
    FROM v_ws_gare_documenti
   WHERE codice = #codiceGara#
     AND (gruppo = 10 OR gruppo = 15)
   ORDER BY datpub desc 
  </select>s
   */
  public static Specification<BandoDocumento> getBandoAttiDocumentiSpecification(final String codice,final String codiceLotto, final Set<Integer> gruppoList){
    return new Specification<BandoDocumento>() {
      private static final long serialVersionUID = 1L;

      @Override
      public Predicate toPredicate(Root<BandoDocumento> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        p.getExpressions().add(cb.equal(root.get("codice"),codice));
        
        final In<Integer> inForGruppo = cb.in(root.get("gruppo"));
        inForGruppo.value(10);
        inForGruppo.value(15);
        p.getExpressions().add(inForGruppo);
        
        query.orderBy(cb.desc(root.get("dataPubblicazione")));
        return p;
      }
      
    };
  }
  
  public static Specification<Comunicazione> getComunicazioniPerAvvisiSpecification(final String codice,final String stazioneAppaltante){
    /*
     * <sql id="selectComunicazioneRicevutaSelect">
        SELECT c.idcom, idcomdes, codice, commsgogg oggetto, commsgtes testo, dataorainvio, dataoralettura, dataoraprotocollo, numprotocollo, bloccarispondi, comdatins,
               t.cenint codsa, g.ngara, null genere, 
               null titolo, null tipologia, idcfg
        </sql>
        
        <sql id="selectComunicazioneRicevutaFrom">
          FROM v_ws_comunicazioni_da_sa c
               INNER JOIN gare g ON (g.ngara = c.codice)
               INNER JOIN torn t ON (t.codgar = g.codgar1)
        </sql>
        
        <sql id="selectComunicazioneRicevuta">
          <include refid="selectComunicazioneRicevutaSelect"/>
          <include refid="selectComunicazioneRicevutaFrom"/>
        </sql>
     * <select id="getComunicazioniRicevute" parameterClass="java.util.HashMap" resultMap="resultComunicazione">
        <include refid="selectComunicazioneRicevuta"/>
        WHERE 1=1
        <isEmpty property="username" prepend="AND"> nomeuser is null</isEmpty>
        <isNotEmpty property="username" prepend="AND"> nomeuser = #username#</isNotEmpty>
        <isNotEmpty property="codice" prepend="AND"> codice = #codice#</isNotEmpty>
        <isNotEmpty property="dataInvioDa" prepend="AND"><![CDATA[ datainvio >= #dataInvioDa#]]></isNotEmpty>
        <isNotEmpty property="dataInvioA" prepend="AND"><![CDATA[ datainvio < #dataInvioA#]]></isNotEmpty>
        <isNotEmpty property="stazioneAppaltante" prepend="AND"> 
         (t.cenint = #stazioneAppaltante# 
          OR EXISTS (SELECT cenint FROM v_ws_aderente_lotto l WHERE l.ngara = g.ngara AND l.cenint = #stazioneAppaltante#) )
        </isNotEmpty>       
        ORDER BY dataorainvio DESC
      </select>
     */
    return new Specification<Comunicazione>() {

      private static final long serialVersionUID = 1L;

      @Override
      public Predicate toPredicate(Root<Comunicazione> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();
        
        root.fetch("gara").fetch("torn");
        Path<Gare> garaPath = root.get("gara");
        Path<Torn> tornPath = garaPath.get("torn");
        query.multiselect(root,garaPath,tornPath);
        
        p.getExpressions().add(cb.isNull(root.get("nomeuser")));
        if(StringUtils.hasText(codice)) {
          p.getExpressions().add(cb.equal(root.get("codice"), codice));
        }
        
        if(StringUtils.hasText(stazioneAppaltante)) {
          Predicate p2 = cb.disjunction();
          p2.getExpressions().add(cb.equal(tornPath.get("cenint"), stazioneAppaltante));
          
          Subquery<AderenteLotto> subquery = query.subquery(AderenteLotto.class);
          Root<AderenteLotto> subroot = subquery.from(AderenteLotto.class);
          Predicate sameCodice = cb.equal(subroot.get("ngara"), garaPath.get("ngara"));
          Predicate isCenint = cb.equal(subroot.get("cenint"), stazioneAppaltante);
          p2.getExpressions().add(cb.exists(subquery.select(subroot).where(sameCodice, isCenint)));
          
          p.getExpressions().add(p2);
        }
        
        query.orderBy(cb.desc(root.get("dataorainvio")));
        
        return p;
      }
      
    };
  }
}
