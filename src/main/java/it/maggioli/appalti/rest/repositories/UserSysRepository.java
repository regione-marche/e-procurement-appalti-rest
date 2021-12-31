package it.maggioli.appalti.rest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
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
  public Optional<UserSys> findBySysloginIgnoreCaseAndSyspwd(String syslogin,String syspwd);
}
