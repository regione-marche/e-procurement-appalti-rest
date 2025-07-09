package it.maggioli.appalti.rest.repositories;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import it.maggioli.appalti.rest.entities.Wpuser;

@Repository
@Transactional
public interface WpuserRepository extends PagingAndSortingRepository<Wpuser, String> {
  public List<Wpuser> findAllByUsernomeIn(Set<String> ids);
  public Set<Wpuser> findByUsernomeIn(Set<String> ids);
}
