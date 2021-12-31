package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.maggioli.appalti.rest.entities.views.ws.AderenteLotto;

public interface AderenteLottoRepository extends JpaRepository<AderenteLotto,String>{
  
  @Query("SELECT al FROM AderenteLotto al WHERE (al.codice = :codice AND al.codice = al.ngara) OR (al.ngara = :codice AND al.codice <> al.ngara)")
  public List<AderenteLotto> getSoggettiAderenti(@Param("codice") String codice);
}
