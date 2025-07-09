package it.maggioli.appalti.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.G1crival;

/**
 * Repository per l'entità G1crival
 * 
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface G1crivalRepository extends JpaRepository<G1crival, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM g1crival WHERE ngara = :ngara")
	public void deleteByNgara(@Param(value = "ngara") String ngara);

	@Query(value = "SELECT c FROM G1crival c WHERE ngara = :ngara")
	public List<G1crival> findByNgara(@Param(value = "ngara") String ngara);

}
