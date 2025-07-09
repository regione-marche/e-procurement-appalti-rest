package it.maggioli.appalti.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.G1crivalcom;

/**
 * Repository per l'entità Wdocdig
 * 
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface G1crivalcomRepository extends JpaRepository<G1crivalcom, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM g1crivalcom WHERE idcrival IN (SELECT id FROM g1crival WHERE ngara = :ngara)")
	public void deleteByNgara(@Param(value = "ngara") String ngara);

	@Query(value = "SELECT c FROM G1crivalcom c WHERE c.idcrival IN (SELECT id FROM G1crival WHERE ngara = :ngara)")
	public List<G1crivalcom> findByNgara(@Param(value = "ngara") String ngara);

}
