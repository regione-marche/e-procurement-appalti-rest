package it.maggioli.appalti.rest.repositories.views.ws;

import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.maggioli.appalti.rest.entities.views.ws.LfsAggiudicazioni;
import it.maggioli.appalti.rest.entities.views.ws.identities.LfsAggiudicazioniIdentity;

@Repository
@Transactional
public interface LfsAggiudicazioniRepository extends PagingAndSortingRepository<LfsAggiudicazioni, LfsAggiudicazioniIdentity> {
  public Page<LfsAggiudicazioni> findAllByUffintIn(Pageable pageable, List<String> codein);
  public Stream<LfsAggiudicazioni> findAllByIdentityCodicegaraAndUffintIn(String codgar,List<String> codein);
  public Stream<LfsAggiudicazioni> findAllByCigAndUffintIn(String cig,List<String> codein);
  public Stream<LfsAggiudicazioni> findAllByCigInAndUffintIn(List<String> cig,List<String> codein);
}
