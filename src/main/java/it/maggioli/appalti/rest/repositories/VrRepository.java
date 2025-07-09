package it.maggioli.appalti.rest.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.dto.VrDittaDto;
import it.maggioli.appalti.rest.dto.VrIpcDittaValoreDto;
import it.maggioli.appalti.rest.entities.Gare;

@Repository
@Transactional
public interface VrRepository extends JpaRepository<Gare, String> {
	
//	@Query(value ="select new it.maggioli.appalti.rest.dto.VrDittaDto(d.id.ngara5, d.id.dittao, d.nomimo, im.pivimp, d.dabilitaz, d.dattivaz, d.dscad, d.dricrin, d.abilitaz, g.dinizval, COALESCE(tab2.tab2d1,'IT') )" +
	@Query(value ="select new it.maggioli.appalti.rest.dto.VrDittaDto(d.id.ngara5, d.id.dittao, d.nomimo, im.pivimp, d.dabilitaz, d.dattivaz, d.dscad, d.dricrin, d.abilitaz, g.dinizval, tab2.tab2d1)" +
			" from Garealbo g " +
			" join Ditg d on d.id.ngara5 = g.id.ngara and d.id.codgar5 = g.id.codgar " + 
			" left join Ragimp r on d.id.dittao = r.id.codime9 and r.impman = '1'" +		
			" join Impr im on (case when r.id.coddic is null then d.id.dittao else r.id.coddic END) = im.codimp " +
			" left join Tab2 tab2 on tab2.id.tab2tip = im.nazimp and tab2.id.tab2cod = 'G_z23' " +
			" where (g.isarchi is null or g.isarchi = '2') " +
			" and g.id.ngara = :ngara " +
			" and (d.dabilitaz is not null and d.dabilitaz <= CURRENT_DATE) order by 1, 3")
	public List<VrDittaDto> findListaDitte(@Param("ngara") String ngara);
	
	@Query(value ="select im.pivimp, count(g.ngara) as countGare, COALESCE(tab2.tab2d1,'IT') as codnazione" + 
				" from gare g " + 
				" join ditg dg on dg.ngara5 = g.ngara and dg.invgar ='1' " + 
				" left join ragimp r on r.codime9 = dg.dittao and r.impman = '1' " + 
				" join impr im on case when r.coddic is null then dg.dittao else r.coddic END = im.codimp " +
				" left join tab2 on tab2.tab2tip = im.nazimp and tab2.tab2cod = 'G_z23' " +
				" where g.elencoe = :ngara and g.tipgarg <> 32 " + 
				" and dg.acquisizione=3 " + 
				" and g.ditta is not null " + 
				" and g.dattoa is not null and g.dattoa between :datastart and :dataend " +
				" and im.pivimp is not null " +
				" group by im.pivimp, COALESCE(tab2.tab2d1,'IT') ", nativeQuery = true)  
	public List<VrIpcDittaValoreDto> findIpcRoInviti(@Param("ngara") String ngara, @Param("datastart") Date datastart, @Param("dataend") Date dataend);
	
	
	@Query(value ="select count(distinct g.ngara) as countGare,im.pivimp, COALESCE(tab2.tab2d1,'IT') as codnazione " +
				" from gare g " +
				" join gare gaff on gaff.seguen = g.ngara and g.tipgarg = 32 " +
				" join ditg d on g.ngara = d.ngara5 and d.invgar ='1' " +
				" left join ragimp r on d.dittao = r.codime9 and r.impman = '1' " +
				" join impr im on case when r.coddic is null then d.dittao else r.coddic END = im.codimp " +
				" left join tab2 on tab2.tab2tip = im.nazimp and tab2.tab2cod = 'G_z23' " +
				" where gaff.dattoa is not null and gaff.dattoa between :datastart and :dataend " +
				" and im.pivimp is not null " +
				" group by im.pivimp, COALESCE(tab2.tab2d1,'IT') ", nativeQuery = true) 
	public List<VrIpcDittaValoreDto> findIpcRoInvitiRicercaMercato(@Param("datastart") Date datastart, @Param("dataend") Date dataend);
	
	@Query(value ="select count(g.ngara) as countGare,im.pivimp, COALESCE(tab2.tab2d1,'IT') as codnazione " +
				" from gare g " +
				" join ditg dg on dg.ngara5 = g.ngara and dg.INVOFF ='1' " +
				" left join ragimp r on r.codime9 = dg.dittao and r.impman = '1' " +
				" join impr im on case when r.coddic is null then dg.dittao else r.coddic END = im.codimp " +
				" left join tab2 on tab2.tab2tip = im.nazimp and tab2.tab2cod = 'G_z23' " +
				" where g.elencoe = :ngara and g.tipgarg <> 32 " +
				" and g.dattoa is not null and g.ditta is not null " +
				" and g.dattoa between :datastart and :dataend " +
				" and im.pivimp is not null " +
				" group by im.pivimp, COALESCE(tab2.tab2d1,'IT') ", nativeQuery = true) 
	public List<VrIpcDittaValoreDto> findIpcRoOfferte(@Param("ngara") String ngara, @Param("datastart") Date datastart, @Param("dataend") Date dataend);
	
	@Query(value ="select count(distinct g.ngara) as countGare,im.pivimp, COALESCE(tab2.tab2d1,'IT') as codnazione "+
			" from gare g " +
			" join gare gaff on gaff.seguen = g.ngara and g.tipgarg = 32 " +
			" join ditg d on g.ngara = d.ngara5 and d.invgar ='1' " +
			" left join ragimp r on d.dittao = r.codime9 and r.impman = '1' " +
			" join impr im on case when r.coddic is null then d.dittao else r.coddic END = im.codimp " +
			" left join tab2 on tab2.tab2tip = im.nazimp and tab2.tab2cod = 'G_z23' " +
			" where gaff.dattoa is not null and gaff.dattoa between :datastart and :dataend " +
			" and d.invoff='1' " +
			" and im.pivimp is not null " +
			" group by im.pivimp, COALESCE(tab2.tab2d1,'IT') ", nativeQuery = true) 
	public List<VrIpcDittaValoreDto> findIpcRoOfferteRicercaMercato(@Param("datastart") Date datastart, @Param("dataend") Date dataend);
	
	
	@Query(value ="select count(d.codgar5)  as countGare,im.pivimp, COALESCE(tab2.tab2d1,'IT') as codnazione " + 
			" from ditg d " + 
			" join gare g on g.codgar1 = d.codgar5 and g.genere = 3 and g.tipgarg <> 32 and d.invoff = '1' " + 
			" join gare g2 on g2.codgar1 = g.codgar1 and (g2.genere <> 3 or g2.genere is null) and d.ngara5 = g2.ngara " + 
			" left join ragimp r on d.dittao = r.codime9 and r.impman = '1' " + 
			" join impr im on case when r.coddic is null then d.dittao else r.coddic END = im.codimp " +
			" left join tab2 on tab2.tab2tip = im.nazimp and tab2.tab2cod = 'G_z23' " +
			" where g.elencoe = :ngara and g2.ditta is not null and g2.dattoa between :datastart and :dataend " +
			" and im.pivimp is not null " +
			" group by im.pivimp, COALESCE(tab2.tab2d1,'IT') ", nativeQuery = true) 
	public List<VrIpcDittaValoreDto> findIpcGaPartecipazioniMultiLotto(@Param("ngara") String ngara, @Param("datastart") Date datastart, @Param("dataend") Date dataend);
		
	@Query(value ="select count(d.codgar5) as countGare,im.pivimp, COALESCE(tab2.tab2d1,'IT') as codnazione " + 
			" from ditg d " + 
			" join gare g on g.codgar1 = d.codgar5 and (g.genere is null or g.genere <> 3) and g.tipgarg <> 32 and d.invoff = '1' " + 
			" left join ragimp r on d.dittao = r.codime9 and r.impman = '1' " + 
			" join impr im on case when r.coddic is null then d.dittao else r.coddic END = im.codimp " +
			" left join tab2 on tab2.tab2tip = im.nazimp and tab2.tab2cod = 'G_z23' " +
			" where g.elencoe = :ngara and g.ditta is not null and g.dattoa between :datastart and :dataend " +
			" and im.pivimp is not null " +
			" group by im.pivimp, COALESCE(tab2.tab2d1,'IT') ", nativeQuery = true) 
	public List<VrIpcDittaValoreDto> findIpcGaPartecipazioniSingoloLotto(@Param("ngara") String ngara, @Param("datastart") Date datastart, @Param("dataend") Date dataend);
	

	@Query(value ="select count(dp.ngara)/count(distinct gaff.ngara) as countGare,im.pivimp, COALESCE(tab2.tab2d1,'IT') as codnazione " + 
			" from gare g " + 
			" join gare gaff on gaff.seguen = g.ngara and g.tipgarg = 32 " + 
			" join ditg d on g.ngara = d.ngara5 and d.invgar ='1' and d.invoff = '1' " + 
			" join dpre dp on g.ngara = dp.ngara and d.dittao = dp.dittao " + 
			" left join ragimp r on dp.dittao = r.codime9 and r.impman = '1' " + 
			" join impr im on case when r.coddic is null then dp.dittao else r.coddic END = im.codimp " +
			" left join tab2 on tab2.tab2tip = im.nazimp and tab2.tab2cod = 'G_z23' " +
			" where 1=1 " + 
			" and gaff.dattoa is not null " + 
			" and gaff.dattoa between :datastart and :dataend " +
			" and im.pivimp is not null " +
			" group by im.pivimp, COALESCE(tab2.tab2d1,'IT') ", nativeQuery = true) 
	public List<VrIpcDittaValoreDto> findIpcGaPartecipazioniRicercaMercato(@Param("datastart") Date datastart, @Param("dataend") Date dataend);

	@Query(value ="select count(g.ngara) as countGare,im.pivimp, COALESCE(tab2.tab2d1,'IT') as codnazione " + 
			" from gare g " + 
			" left join ragimp r on g.ditta = r.codime9 and r.impman = '1' " + 
			" join impr im on case when r.coddic is null then g.ditta else r.coddic END = im.codimp " +
			" left join tab2 on tab2.tab2tip = im.nazimp and tab2.tab2cod = 'G_z23' " +
			" where g.elencoe = :ngara and g.tipgarg <> 32 and (g.genere is null or g.genere <> 3) " + 
			" and g.seguen is null " + 
			" and g.ditta is not null " + 
			" and g.dattoa is not null " + 
			" and g.dattoa between :datastart and :dataend " +
			" and im.pivimp is not null " +
			" group by im.pivimp, COALESCE(tab2.tab2d1,'IT') ", nativeQuery = true) 
	public List<VrIpcDittaValoreDto> findIpcGaAggiudicazioni(@Param("ngara") String ngara, @Param("datastart") Date datastart, @Param("dataend") Date dataend);
	
	
	@Query(value ="select count(gaff.ngara) as countGare,im.pivimp, COALESCE(tab2.tab2d1,'IT') as codnazione " + 
			" from gare g " + 
			" join gare gaff on gaff.seguen = g.ngara and g.tipgarg = 32 " + 
			" left join ragimp r on gaff.ditta = r.codime9 and r.impman = '1' " + 
			" join impr im on case when r.coddic is null then gaff.ditta else r.coddic END = im.codimp " +
			" left join tab2 on tab2.tab2tip = im.nazimp and tab2.tab2cod = 'G_z23' " +
			" where 1=1 " + 
			" and gaff.dattoa is not null " + 
			" and gaff.dattoa between :datastart and :dataend " +
			" and im.pivimp is not null " +
			" group by im.pivimp, COALESCE(tab2.tab2d1,'IT') ", nativeQuery = true) 
	public List<VrIpcDittaValoreDto> findIpcGaAggiudicazioniRicercaMercato(@Param("datastart") Date datastart, @Param("dataend") Date dataend);
	
	
	
	
}
