package it.maggioli.appalti.rest.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.UserSys;

/**
 * Repository per l'entità UserSys
 * @author gabriele.nencini
 *
 */
@Repository
@Transactional
public interface UserSysRepository extends JpaRepository<UserSys, Long> {
	@Modifying
	@Query("update UserSys u set u.sysultacc= :sysultacc where u.syscon = :syscon")
	public void updateLastAccessDate(@Param(value = "sysultacc") Date sysultacc,@Param(value = "syscon") Long syscon);
	public Optional<UserSys> findBySysloginIgnoreCaseAndSyspwd(String syslogin,String syspwd);
}
