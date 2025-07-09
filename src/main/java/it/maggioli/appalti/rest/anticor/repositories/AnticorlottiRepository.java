package it.maggioli.appalti.rest.anticor.repositories;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.anticor.entities.Anticorlotti;

@Repository
@Transactional
public interface AnticorlottiRepository  extends JpaRepository<Anticorlotti, Long>, JpaSpecificationExecutor<Anticorlotti>{
  public Optional<Anticorlotti> findByIdAndAnticorId(Long id, Long idantor);
  public List<Anticorlotti> findByAnticorIdOrderById(Long idanticor);
  public List<Anticorlotti> findByAnticorId(Long idanticor);
  @Query("SELECT al.cig from Anticorlotti al WHERE al.anticor.id = :idanticor AND al.cig is not null")
  public List<String> findCigByAnticorId(@Param("idanticor") Long idanticor); 
  @Query("SELECT al.idlotto from Anticorlotti al WHERE al.anticor.id = :idanticor")
  public List<String> findIdlottoByAnticorId(@Param("idanticor") Long idanticor); 
  public List<Anticorlotti> findByAnticorIdIn(Collection<Long> idantorlist);
  public List<Anticorlotti> findByCigInAndAnticorId(Collection<String> cig,Long anticorId);
  public Optional<Anticorlotti> findByCigIgnoreCaseAndPubblicaAndAnticorAnnorifAndAnticorCodeinAndAnticorEsportato(String cig,String pubblica,Integer annorif,String codein,String esportato);
  public Optional<Anticorlotti> findByCigIgnoreCaseAndAnticorId(String cig,Long anticorId);
  public Optional<Anticorlotti> findByCigIgnoreCaseAndAnticorIdAndCodfisresp(String cig,Long anticorId,String codfisresp);
  
  public List<Anticorlotti> findByAnticorIdAndPubblicaOrderByCig(Long anticorId,String pubblica);
  //"select count(lotti.id) from anticorlotti lotti, anticor a where pubblica = ? and upper(cig)=? and a.id=lotti.idanticor and a.annorif=?" +
  //" and a.codein=?"
  @Query("SELECT count(al.id) FROM Anticorlotti al WHERE al.pubblica= :pubblica AND UPPER(al.cig) = :cig AND al.anticor.annorif = :annorif AND al.anticor.codein = :codein AND al.id != :id")
  public long countLottidaCigPerAVPCValidation(@Param("pubblica") String pubblica, @Param("cig") String cig, @Param("annorif") Integer annorif, @Param("codein") String codiceStazioneAppaltante,@Param("id") Long id);
 /*
  *  select count(anticor.id) from anticor, anticorlotti  " +
  "where anticor.id=anticorlotti.idanticor and annorif=? and esportato='1' and pubblica='1' and cig =? " +
  " and codein=? 
  */
  @Query("SELECT al.cig FROM Anticorlotti al WHERE al.anticor.pubblicato= '1' AND al.anticor.esportato = '1' AND al.anticor.annorif = :annorif AND al.anticor.codein = :codein GROUP BY al.cig ")
  public List<String> selectLottiVerificaAnnoprec(@Param("annorif") Integer annorif, @Param("codein") String codiceStazioneAppaltante);
  
  @Query("SELECT count(al.id) FROM Anticorlotti al WHERE al.anticor.id= :anticorid and al.anticor.completato= '1' and al.anticor.esportato='1' and al.pubblica='1'")
  public long countLottiDaAnticorId(@Param("anticorid") Long anticorid);
  
  
  //@Query("SELECT * from Anticorlotti al WHERE al.anticor.id = :idanticor AND al.cig = :cig")
  public Anticorlotti findByAnticorIdAndCig(Long idanticor,String cig); 
  /*
   * Per evitare problemi con tabelle non esistenti a DB
   */
  /**
   * Questa native query sostituisce il codice seguente presente nella classe {@code Adempimenti190Manager} di Appalti
   * <pre>
   * String ngara=(String)this.sqlManager.getObject("select idlotto from anticorlotti where id=?", new Object[]{recordAdempimento.getIdLotto()});
     Vector<?> datiTorn = this.sqlManager.getVector("select codgar, clavor, numera, accqua, altrisog, modcont from torn,gare where ngara=? and codgar=codgar1", new Object[]{ngara});
     if(datiTorn!=null && datiTorn.size()>0){
        String codgar=SqlManager.getValueFromVectorParam(datiTorn, 0).stringValue();
        String clavor=SqlManager.getValueFromVectorParam(datiTorn, 1).stringValue();
        Long numera=SqlManager.getValueFromVectorParam(datiTorn, 2).longValue();
        String accqua=SqlManager.getValueFromVectorParam(datiTorn, 3).stringValue();
        Long altrisog=SqlManager.getValueFromVectorParam(datiTorn, 4).longValue();
        Long modcont=SqlManager.getValueFromVectorParam(datiTorn, 5).longValue();
        Long genere=(Long)this.sqlManager.getObject("select genere from gare where ngara=?", new Object[]{codgar});
        boolean aggiornare= true;
        if(clavor!=null && !"".equals(clavor) && numera!=null && !("1".equals(accqua) || new Long(2).equals(altrisog) || new Long(3).equals(altrisog)))
          aggiornare=false;
        if(new Long(3).equals(genere) && new Long(2).equals(modcont))
          aggiornare=false;
        if(aggiornare){ //questo è il valore finale
   * </pre>
   * @param ngara la gara da verificare
   * @return stringa {@code 'true'} se è modificabile, stringa {@code 'false'} altrimenti
   */
  @Query(nativeQuery = true, value = "SELECT COALESCE(CASE WHEN ( NOT ( ( coalesce(g.clavor, '') != '' AND (g.numera IS NOT NULL) "
      + "AND ( t.accqua != '1' AND coalesce(t.altrisog, - 1) != 2 AND coalesce(t.altrisog, - 1) != 3 ) ) "
      + "OR ( g2.genere = 3 AND coalesce(t.modcont, - 1) = 2 ) ) ) THEN 'true' ELSE 'false' END,'false') as aggiorna "
      + "FROM torn t "
      + "JOIN gare g ON  t.codgar = g.codgar1 "
      + "LEFT JOIN gare g2 ON g2.ngara = t.codgar "
      + "WHERE g.ngara = :ngara")
  public String isGarecontToBeModifiedOnLoadExcel(@Param("ngara") String ngara);
  
  
  /**
   * Con questa query aggiorno solo i campi che devo effettivamente aggiornare altrimenti lascio invariato.
   * Queta query funziona solo con le tabelle effettivamente mappate tramite hibernate.
   * @param isAggiornaDataInizio se devo aggiornare il campo dverbc
   * @param dverbc il valore da aggiornare
   * @param isAggiornaDataUltimazione se devo aggiornare il campo dcertu
   * @param dcertu il valore da aggiornare
   * @param isAggiornaImpSommeLiquidate se devo aggiornare il campo impliq
   * @param impliq il valore da aggiornare
   * @param ngara la chiave da aggiornare
   */
  @Deprecated
  @Query(nativeQuery = true,value = "UPDATE GARECONT g set "
      + "g.dverbc= CASE WHEN :isAggiornaDataInizio=true        THEN CAST(:dverbc AS TIMESTAMP) ELSE g.dverbc END, "
      + "g.dcertu= CASE WHEN :isAggiornaDataUltimazione=true   THEN CAST(:dcertu AS TIMESTAMP) ELSE g.dcertu END, "
      + "g.impliq= CASE WHEN :isAggiornaImpSommeLiquidate=true THEN CAST(:impliq AS NUMBER) ELSE g.impliq END "
      + "where g.ngara = :ngara or g.ngaral= :ngara")
  @Modifying
  public void updateOnlyNecessaryParametersGarecont(
      @Param("isAggiornaDataInizio") Boolean isAggiornaDataInizio,
      @Param("dverbc") java.sql.Date dverbc,
      @Param("isAggiornaDataUltimazione") Boolean isAggiornaDataUltimazione,
      @Param("dcertu") java.sql.Date dcertu,
      @Param("isAggiornaImpSommeLiquidate") Boolean isAggiornaImpSommeLiquidate,
      @Param("impliq") Double impliq,
      @Param("ngara") String ngara);
  
  /**
   * Aggiorna la data inizio nella tabella GARECONT
   * @param dverbc
   * @param ngara
   */
  @Query(nativeQuery = true,value = "UPDATE GARECONT SET dverbc= :dverbc WHERE ngara = :ngara OR ngaral= :ngara")
  @Modifying
  public void updatGarecontDverbc(@Param("dverbc") Date dverbc, @Param("ngara") String ngara);
  /**
   * Aggiorna la data ultima azione nella tabella GARECONT
   * @param dverbc
   * @param ngara
   */
  @Query(nativeQuery = true,value = "UPDATE GARECONT SET dcertu= :dcertu WHERE ngara = :ngara OR ngaral= :ngara")
  @Modifying
  public void updatGarecontDcertu(@Param("dcertu") Date dverbc, @Param("ngara") String ngara);
  /**
   * Aggiorna l'importo somme liquidate nella tabella GARECONT
   * @param impliq
   * @param ngara
   */
  @Query(nativeQuery = true,value = "UPDATE GARECONT SET impliq= :impliq WHERE ngara = :ngara OR ngaral= :ngara")
  @Modifying
  public void updatGarecontImpliq(@Param("impliq") Double impliq, @Param("ngara") String ngara);
  
  @Query(nativeQuery = true,value = "SELECT count(*) FROM TORN having count(*)>1")
  public void checkEsistenzaTorn() throws Exception;

  @Query(value = "FROM Anticorlotti acl INNER JOIN FETCH acl.anticor ac WHERE ac.annorif = (:annorif - 1) AND ac.codein = :codein AND acl.pubblica='1' AND acl.cig NOT IN (SELECT acl2.cig FROM Anticorlotti acl2 INNER JOIN acl2.anticor ac2 WHERE ac2.annorif = (:annorif) AND ac2.codein = :codein AND acl2.cig is not null)",
		 countQuery = "SELECT count(acl) FROM Anticorlotti acl INNER JOIN acl.anticor ac WHERE ac.annorif = (:annorif - 1) AND ac.codein = :codein AND acl.pubblica='1' AND acl.cig NOT IN (SELECT acl2.cig FROM Anticorlotti acl2 INNER JOIN acl2.anticor ac2 WHERE ac2.annorif = (:annorif) AND ac2.codein = :codein AND acl2.cig is not null)")
  public Page<Anticorlotti> findForImportdaAnnoprecWithPage(@Param("annorif") Integer annorif, @Param("codein") String codein,Pageable pageable);
  
  @Query(value = "select acl.id FROM Anticorlotti acl INNER JOIN  acl.anticor ac WHERE ac.annorif = (:annorif - 1) AND ac.codein = :codein AND acl.pubblica='1' AND acl.cig NOT IN (SELECT acl2.cig FROM Anticorlotti acl2 INNER JOIN acl2.anticor ac2 WHERE ac2.annorif = (:annorif) AND ac2.codein = :codein AND acl2.cig is not null)",
			 countQuery = "SELECT count(acl) FROM Anticorlotti acl INNER JOIN acl.anticor ac WHERE ac.annorif = (:annorif - 1) AND ac.codein = :codein AND acl.pubblica='1' AND acl.cig NOT IN (SELECT acl2.cig FROM Anticorlotti acl2 INNER JOIN acl2.anticor ac2 WHERE ac2.annorif = (:annorif) AND ac2.codein = :codein AND acl2.cig is not null)")
	  public Page<Long> findIdForImportdaAnnoprecWithPage(@Param("annorif") Integer annorif, @Param("codein") String codein,Pageable pageable);
  
  @Query(value = "select acl.idlotto  FROM Anticorlotti acl INNER JOIN  acl.anticor ac WHERE ac.annorif = (:annorif - 1) AND ac.codein = :codein AND acl.pubblica='1' AND acl.cig NOT IN (SELECT acl2.cig FROM Anticorlotti acl2 INNER JOIN acl2.anticor ac2 WHERE ac2.annorif = (:annorif) AND ac2.codein = :codein AND acl2.cig is not null) and acl.idlotto is not null",
			 countQuery = "SELECT count(acl) FROM Anticorlotti acl INNER JOIN acl.anticor ac WHERE ac.annorif = (:annorif - 1) AND ac.codein = :codein AND acl.pubblica='1' AND acl.cig NOT IN (SELECT acl2.cig FROM Anticorlotti acl2 INNER JOIN acl2.anticor ac2 WHERE ac2.annorif = (:annorif) AND ac2.codein = :codein AND acl2.cig is not null) and acl.idlotto is not null")
	  public Page<String> findIdlottoForImportdaAnnoprecWithPage(@Param("annorif") Integer annorif, @Param("codein") String codein,Pageable pageable);
  
  @Query("FROM Anticorlotti acl INNER JOIN FETCH acl.anticor ac WHERE ac.annorif = (:annorif - 1) AND ac.codein = :codein AND acl.pubblica='1' AND acl.cig NOT IN (SELECT acl2.cig FROM Anticorlotti acl2 INNER JOIN acl2.anticor ac2 WHERE ac2.annorif = (:annorif) AND ac2.codein = :codein AND acl2.cig is not null)")
  public List<Anticorlotti> findForImportdaAnnoprec(@Param("annorif") Integer annorif, @Param("codein") String codein);
    
  @Query("SELECT count(acl.id) FROM Anticorlotti acl WHERE acl.anticor.id = :idanticor AND UPPER(acl.cig)= :cig AND acl.anticor.codein = :codein")
  public Long countLottiDuplicati(@Param("idanticor") Long idanticor,@Param("cig") String cig, @Param("codein") String codein);
  @Query("SELECT count(acl.id) FROM Anticorlotti acl WHERE acl.anticor.id = :idanticor AND UPPER(acl.cig)= :cig")
  public Long countLottiDuplicati(@Param("idanticor") Long idanticor,@Param("cig") String cig);
  public Optional<Anticorlotti> findByCigAndAnticorIdAndTestologIsNotNull(String cig, Long idanticor);
  
  @Query(nativeQuery = true,value = "SELECT * FROM Anticorlotti acl, Anticor ac, anticor ac2 where acl.idanticor = ac.id and acl.cig = :cig and ac.annorif = :annorif and acl.codfiscprop = :codfiscprop and acl.pubblica = '1' and ac.codein = ac2.codein and ac2.id = :idanticor")
  public Anticorlotti findLotto(@Param("codfiscprop") String codfiscprop,@Param("cig") String cig,@Param("annorif") int annorif,@Param("idanticor") Long idanticor);
  
  @Query(nativeQuery = true,value = "select count(*) from v_dati_lotti where cig = :cig and codiceprop = :codein")
  public Long findLottoInView(@Param("cig") String cig,@Param("codein") String codein);
    
  @Query(nativeQuery = true,value = "SELECT * FROM Anticorlotti acl where acl.idanticor = :idAnticor and acl.idlotto = :idlotto limit 1")
  public Anticorlotti findByIdlottoAndIdAnticor(@Param("idlotto") String idlotto,@Param("idAnticor") Long idAnticor);
  
  @Query(nativeQuery = true,value = "SELECT cig FROM Anticorlotti acl where acl.idanticor = :idAnticor and acl.lottoinbo = '2'")
  public List<String> findCigNonCollegati(@Param("idAnticor") Long idAnticor);
  
  @Query(nativeQuery = true,value = "SELECT cig" + 
  		" FROM anticorlotti" + 
  		" WHERE idlotto IN (" + 
  		"    SELECT idlotto" + 
  		"    FROM anticorlotti" + 
  		"    where idanticor = :idanticor and pubblica = '1'" + 
  		"    GROUP BY idlotto" + 
  		"    HAVING COUNT(*) > 1" + 
  		" ) and idanticor = :idanticor")
  public List<String> ricercaCigIdlottoDuplicato(@Param("idanticor") Long idanticor);
}
