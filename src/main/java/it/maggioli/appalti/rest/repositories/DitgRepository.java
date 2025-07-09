package it.maggioli.appalti.rest.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.maggioli.appalti.rest.entities.Ditg;
import it.maggioli.appalti.rest.entities.identities.DitgPK;

@Repository
public interface DitgRepository extends JpaRepository<Ditg, DitgPK> {
	
	@Query("SELECT d.id FROM Ditg d "
			+ "INNER JOIN Garealbo ga "
			+ "ON d.id.codgar5 = ga.id.codgar and d.id.ngara5 = ga.id.ngara "
			+ "WHERE d.abilitaz=1 AND d.id.dittao in ( :codici ) "
			+ "AND ( (dtermval is null) OR (dtermval <= :now AND dinizval >= :now ) "
			+ ")")
	public List<DitgPK> findForRegistry(@Param("codici") List<String> codici,@Param("now") Date now);

}
