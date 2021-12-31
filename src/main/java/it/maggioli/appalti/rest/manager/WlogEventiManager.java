package it.maggioli.appalti.rest.manager;

import java.util.Date;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.entities.Wlogeventi;
import it.maggioli.appalti.rest.repositories.WlogEventiRepository;

@Component
public class WlogEventiManager {
  private final Logger logger = LoggerFactory.getLogger(getClass());
//  private final String TABLE_NAME="W_LOGEVENTI";
  private final String TABLE_NAME="W_logeventi";
  
  public static final String COD_EVENTO_LOGIN = "LOGIN";
  public static final String COD_EVENTO_SET_PROFILO = "SET_PROFILO";
  public static final String COD_EVENTO_SET_UFFINT = "SET_UFFINT";
  public static final String COD_EVENTO_OPEN_APPLICATION = "OPEN_APPLICATION";
  public static final String COD_EVENTO_LOGOUT = "LOGOUT";
  public static final String COD_EVENTO_INVCOM = "INVCOM";
  public static final String COD_EVENTO_CHANGE_PASSWORD = "CHANGE_PSW";
  public static final String COD_EVENTO_ADD_USER = "ADD_USER";
  public static final String COD_EVENTO_DEL_USER = "DELETE_USER";
  public static final String COD_EVENTO_READ_ART80 = "READ_ART80";
  public static final String COD_EVENTO_LOCK_LOGIN_UTENTE = "LOGIN_LOCK";
  public static final String COD_EVENTO_UNLOCK_LOGIN_UTENTE = "LOGIN_UNLOCK";
  public static final String COD_EVENTO_CHANGE_PROFILO = "CHANGE_USER_PROFILI";
  
  @Autowired
  private WgenChiaviManager wcManager;
  @Autowired
  private WlogEventiRepository wleManager;
  
  @Transactional(propagation = Propagation.MANDATORY)
  public Long saveWlogEventi(Wlogeventi evento) throws Exception {
    Long nextId = 0l;
    if(Objects.nonNull(evento)) {
      nextId = wcManager.getNextId(TABLE_NAME);
      evento.setIdevento(nextId);
      evento.setDataora(new Date());
      if(!wleManager.existsById(nextId)) {
        wleManager.save(evento);
      }
    }
    logger.info("TEST_NG -> {}",nextId);
    return nextId;
  }
}
