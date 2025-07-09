package it.maggioli.appalti.rest.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.dto.OepvCommissarioDto;
import it.maggioli.appalti.rest.dto.OepvCriterioDettaglioDto;
import it.maggioli.appalti.rest.dto.OepvCriterioListaDto;
import it.maggioli.appalti.rest.dto.OepvCriterioTabellareDto;
import it.maggioli.appalti.rest.dto.OepvDocumentoDto;
import it.maggioli.appalti.rest.dto.OepvDocumentoLottoDownloadDto;
import it.maggioli.appalti.rest.dto.OepvDocumentoPartecipanteDto;
import it.maggioli.appalti.rest.dto.OepvGarPesiDto;
import it.maggioli.appalti.rest.dto.OepvLottoDettaglioDto;
import it.maggioli.appalti.rest.dto.OepvPartecipanteDettaglioDto;
import it.maggioli.appalti.rest.dto.OepvPartecipanteListaDto;
import it.maggioli.appalti.rest.entities.G1cridef;
import it.maggioli.appalti.rest.entities.Gare;
import it.maggioli.appalti.rest.entities.GareOepv;

@Repository
@Transactional
public interface OepvRepository extends JpaRepository<Gare, String> {
	
	@Query(value ="select new it.maggioli.appalti.rest.dto.OepvLottoDettaglioDto(g.codgar, l.ngara, l.codiga, l.codcig, l.notGar, l.impapp, t2.nomtec, g.dteoff, g.oteoff)" +
			" from TornOepv g " +
			" join Uffint sa on sa.codein=g.cenint " +
			" join GareOepv l on l.codgar1 = g.codgar and l.genere is null " + 
			" join GareOepv l2 on l2.codgar1 = g.codgar and (l2.genere = 3 or l2.genere is null) " +
			" join Gfof c on c.ngara2=l2.ngara and c.espgiu='1' " +
			" join Tecni t on t.codtec=c.codfof  " +
			" left join Tecni t2 on t2.codtec = g.codrup " +
			" where sa.cfein = :cfein " +
			"   and l.ngara = :ngara " + 
			"   and t.cftec = :cftec ")
	public OepvLottoDettaglioDto findDettaglioLottoOepv(@Param("cfein") String cfein, @Param("cftec") String cftec, @Param("ngara") String ngara);

	@Query(value = "SELECT new it.maggioli.appalti.rest.dto.OepvDocumentoDto(gp.nome, wd.dignomdoc, wd.identity.iddocdig, dg.descrizione, dg.urldoc) "+
			"FROM Documgara dg " + 
			"JOIN G1cfPubb gp ON dg.tipologia = gp.id " +
			"LEFT JOIN Wdocdig wd ON wd.identity.idprg = dg.idprg AND wd.identity.iddocdig = dg.iddocdg " +
			"WHERE dg.gruppo in (1, 6, 10, 15) " + 
			"  AND codgar = :codiceGara " +
			"  AND (ngara IS NULL OR ngara = :ngara) " +
			"  AND (dg.isarchi IS NULL OR dg.isarchi = '0') " +
			"  AND dg.statodoc = 5 " +
			"ORDER BY gp.numord, dg.numord "
			)
	public List<OepvDocumentoDto> findDocumentiGaraOepv(@Param("codiceGara") String codiceGara, @Param("ngara") String ngara);
	@Query(value = "SELECT new it.maggioli.appalti.rest.dto.OepvDocumentoDto(gp.nome, wd.dignomdoc, wd.identity.iddocdig, dg.descrizione, dg.urldoc) "+
		"FROM Documgara dg " + 
		"JOIN G1cfPubb gp ON dg.tipologia = gp.id " +
		"LEFT JOIN Wdocdig wd ON wd.identity.idprg = dg.idprg AND wd.identity.iddocdig = dg.iddocdg " +
		"WHERE dg.gruppo in (1, 6, 10, 15) " + 
		"  AND codgar = :codiceGara " +
		"  AND (ngara IS NULL OR ngara = :ngara) " +
		"  AND (dg.isarchi IS NULL OR dg.isarchi = '0') " +
		"  AND dg.statodoc = 5 " +
		"ORDER BY gp.numord, dg.numord "
		)
	public Stream<OepvDocumentoDto> findDocumentiGaraOepvAsStream(@Param("codiceGara") String codiceGara, @Param("ngara") String ngara);
	
	@Query(value ="select new it.maggioli.appalti.rest.dto.OepvDocumentoLottoDownloadDto(d.identity.idprg, d.identity.iddocdig, d.dignomdoc, d.digogg) " +
			" from Wdocdig d " +
			" where d.identity.iddocdig = :iddocdig and idprg = 'PG' ")	
	public OepvDocumentoLottoDownloadDto findDocumentoLottoDownloadOepv(@Param("iddocdig") Long iddocdig);

	@Query(value ="select new it.maggioli.appalti.rest.dto.OepvPartecipanteListaDto(d.id.dittao, i.nomest, d.numordpl, ti.tab1desc)" +
			" from Ditg d " +
			" join Impr i on i.codimp = d.id.dittao " +
			" left join Tab1 ti on ti.id.tab1cod = 'Ag008' and ti.id.tab1tip = i.tipimp " +
			" where d.id.ngara5 = :ngara and (d.ammgar = '1' or d.ammgar is null) and d.invoff ='1' " + 
			" order by d.numordpl, d.nomimo ")
	public List<OepvPartecipanteListaDto> findPartecipantiOepv(@Param("ngara") String ngara);

	@Query(value ="select new it.maggioli.appalti.rest.dto.OepvPartecipanteDettaglioDto(" +
			" d.id.dittao, i.nomest, d.numordpl, d.id.codgar5, d.id.ngara5, g.codiga, g.codcig)" +
			" from Ditg d " +
			" join Impr i on i.codimp = d.id.dittao " +
			" join GareOepv g on g.codgar1 = d.id.codgar5 and g.ngara = d.id.ngara5 " +
			" where d.id.codgar5 = :codiceGara and d.id.ngara5 = :ngara and d.id.dittao = :codiceImpresa ")
	public OepvPartecipanteDettaglioDto findDettaglioPartecipanteOepv(@Param("codiceGara") String codiceGara, @Param("ngara") String ngara, @Param("codiceImpresa") String codiceImpresa);
	
	@Query(value = "select new it.maggioli.appalti.rest.dto.OepvDocumentoPartecipanteDto(d.iddocdg, d.idprg, d.descrizione, d.dignomdoc) " +
			"FROM VGareDocditta d " +
			"WHERE d.codgar = :codiceGara "+
			"AND d.ngara = :ngara "+
			"AND d.busta = '2' " + 
			"AND d.codimp = :codiceImpresa " + 
			"AND d.idprg is not null and d.iddocdg is not null "	
			)	
	public List<OepvDocumentoPartecipanteDto> findDocumentiPartecipanteOepv(@Param("codiceGara") String codiceGara, @Param("ngara") String ngara, @Param("codiceImpresa") String codiceImpresa);
	
	@Query(value ="select new it.maggioli.appalti.rest.dto.OepvDocumentoLottoDownloadDto(d.identity.idprg, d.identity.iddocdig, d.dignomdoc, d.digogg) " +
			" from Wdocdig d " +
			" where d.identity.iddocdig = :iddocdig and idprg = :idprg ")	
	public OepvDocumentoLottoDownloadDto findDocumentoPartecipanteDownloadOepv(@Param("iddocdig") Long iddocdig, @Param("idprg") String idprg);
		
	@Query(value ="select new it.maggioli.appalti.rest.dto.OepvCriterioListaDto(" +
			" g.id.ngara, g.id.necvan, g.necvan1, g.norpar, g.norpar1, g.despar, g.maxpun, g1.modpunti, g1.modmanu)" +
			" from Goev g " +
			" inner join GareOepv gare on g.id.ngara = gare.ngara " + 
			" left join G1cridef g1 on g1.ngara = g.id.ngara and g1.necvan = g.id.necvan " +
			" where g.id.ngara= :ngara " +
			"   and gare.fasgar >= 5 " + 
			"   and g.maxpun > 0 " +
			"   and (g.id.necvan in (select distinct g2.necvan1 " +
			"   					from Goev g2 " +
			"   					join G1cridef g1 on g1.ngara = g2.id.ngara and g1.necvan = g2.id.necvan and g2.tippar = 1 and g1.modpunti in (1, 3) " +
			" 						where g2.id.ngara= :ngara) " +
			"     or g.id.necvan in (select distinct g2.id.necvan " +
			" 						from Goev g2 " +
			" 						join G1cridef g1 on g1.ngara = g2.id.ngara and g1.necvan = g2.id.necvan and g2.tippar = 1 and g1.modpunti in (1, 3) " +
			" 						where g2.id.ngara= :ngara) " +
			"  ) " +			
			" order by 4, 3, 5, 2 ")
	public List<OepvCriterioListaDto> findCriteriGaraOepv(@Param("ngara") String ngara);
	
	@Query(value ="select new it.maggioli.appalti.rest.dto.OepvCriterioDettaglioDto(" +
			" g.id.ngara, g.id.necvan, g.necvan1, g.norpar, g.norpar1, g.despar, g.maxpun, g1.modpunti, g1.modmanu, gp.despar)" +
			" from Goev g " +
			" left join Goev gp on g.id.ngara = gp.id.ngara and g.necvan1 = gp.id.necvan" +
			" left join G1cridef g1 on g1.ngara = g.id.ngara and g1.necvan = g.id.necvan " +
			" where g.id.ngara= :ngara " +
			"   and g.id.necvan = :necvan ")
	public OepvCriterioDettaglioDto findDettaglioCriteroGaraOepv(@Param("ngara") String ngara, @Param("necvan") Long necvan);

	@Query(value = "SELECT new it.maggioli.appalti.rest.dto.OepvGarPesiDto(g.id.numpesi, g.id.codicegara, g.descrizione, g.ordine, g.valore, g.descexcel) "+
			"FROM Garpesi g "+
			"WHERE g.id.codicegara = :codiceGara "+
			"ORDER BY g.ordine, g.id.numpesi"
			)
	public List<OepvGarPesiDto> findCoefficientiOepv(@Param("codiceGara") String codiceGara);
	
	@Query(value = "SELECT new it.maggioli.appalti.rest.dto.OepvCriterioTabellareDto(t.id.tab2cod, t.id.tab2tip, t.tab2d1, t.tab2d2) "+
			"FROM Tab2 t "+
			" WHERE t.id.tab2cod = 'A1z07' " +
			"   AND (t.tab2arc is null or t.tab2arc = '2') " +
			" ORDER BY t.tab2nord, t.id.tab2tip ")
	public List<OepvCriterioTabellareDto> findCriterioTabellareOepv();
	
	@Query(value = "SELECT g "+
			"FROM G1cridef g "+
			" WHERE g.ngara = :ngara and g.necvan = :necvan")
	public G1cridef findCriterioDefByCriterioOepv(@Param("ngara") String ngara, @Param("necvan") BigDecimal necvan);

	@Query(value = "SELECT new it.maggioli.appalti.rest.dto.OepvCommissarioDto(g.id, g.codfof, g.nomfof, g.incfof, t.tab1desc, n.cftec) " +
					" FROM Gfof g "+
					" JOIN Tab1 t ON t.id.tab1cod = 'A1001' AND t.id.tab1tip = g.incfof " +
					" JOIN Tecni n on g.codfof = n.codtec " + 
					" WHERE g.ngara2  = :ngara2 " +
					" ORDER BY g.incfof, g.nomfof ")
	public List<OepvCommissarioDto> findCommissariGaraOepv(@Param("ngara2") String ngara2);
	
	@Query(value = "SELECT g " +
			" FROM GareOepv g "+
			" WHERE g.ngara  = :ngara")
	public GareOepv findGaraById(@Param("ngara") String ngara);

	@Modifying
	@Query(value = "UPDATE gare1 SET statocg = 2 WHERE ngara = :ngara ", nativeQuery = true)
	public Integer updateGare1SetStatoConfermato(@Param("ngara") String ngara);

	@Query(value = "select count(gf.espgiu) - count(gf.commicg) as diff " + 
					" from gfof gf " +
					" inner join gare g on gf.ngara2 = g.ngara and (g.genere is null or g.genere = 3) " +
					" where g.codgar1 = :codgar1  ", nativeQuery = true)
	public Long findDiffCountCommissariGara(@Param("codgar1") String codgar1);
	
}
