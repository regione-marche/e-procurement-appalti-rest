package it.maggioli.appalti.rest.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.repositories.WgenChiaviRepository;

@Component
public class WgenChiaviManager {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final long DEFAULT_INCREMENT = 1;
  @Autowired
  private WgenChiaviRepository wgcRepository;
  
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Long getNextId(String tabella) {
    logger.debug("Required new id for {}",tabella);
    wgcRepository.incrementChiavePerTabella(DEFAULT_INCREMENT, tabella);
    return wgcRepository.findByTabellaIgnoreCase(tabella).get().getChiave();
  }
}
