package it.maggioli.appalti.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.G1crivalcomCg;

/**
 * Repository per l'entità Wdocdig
 * 
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface G1crivalcomCgRepository extends JpaRepository<G1crivalcomCg, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM g1crivalcom_cg WHERE idcrival IN (SELECT id FROM g1crival_cg WHERE ngara = :ngara)")
	public void deleteByNgara(@Param(value = "ngara") String ngara);

	@Query(value = "SELECT c FROM G1crivalcomCg c WHERE c.idcrival IN (SELECT id FROM G1crivalCg WHERE ngara = :ngara)")
	public List<G1crivalcomCg> findByNgara(@Param(value = "ngara") String ngara);

}
