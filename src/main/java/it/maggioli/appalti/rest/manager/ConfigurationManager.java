package it.maggioli.appalti.rest.manager;

import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.maggioli.appalti.rest.configuration.response.ConfigurationResponse;

/**
 * Questa classe terrà in considerazione il fatto di prendere le configurazioni e renderle fruibili
 * 
 * @author gabriele.nencini
 *
 */
@Service
public class ConfigurationManager {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  
  public static final String GARE_DOCINVITOPUBBLICA_VIS = "PA.GARE.DOCINVITOPUBBLICA.VIS";
  public static final String GARE_ATTIDOCART29_VIS = "PA.GARE.ATTIDOCART29.VIS";
  public static final String GARE_ADERENTI_VIS = "PA.GARE.ADERENTI.VIS";
  
  private ConcurrentHashMap<String,ConfigurationResponse> properties;
  private ConcurrentHashMap<String,ConfigurationResponse> defaultProperties;
  
  @PostConstruct
  public void postConstruct() {
    logger.info("Configuration Manager deployed.");
    /*
     *  GARE ATTIDOCART29
        GARE ADERENTI
        GARE DOCINVITOPUBBLICA
     */
    properties = new ConcurrentHashMap<String, ConfigurationResponse>();
    defaultProperties = new ConcurrentHashMap<String, ConfigurationResponse>();
    ConfigurationResponse resp = new ConfigurationResponse();
    resp.setCodapp("PA");
    resp.setChiave("GARE.ATTIDOCART29.VIS");
    resp.setValore("true");
    defaultProperties.put("PA.GARE.ATTIDOCART29.VIS", resp);
    resp = new ConfigurationResponse();
    resp.setCodapp("PA");
    resp.setChiave("GARE.ADERENTI.VIS");
    resp.setValore("false");
    defaultProperties.put("PA.GARE.ADERENTI.VIS", resp);
    resp = new ConfigurationResponse();
    resp.setCodapp("PA");
    resp.setChiave("GARE.DOCINVITOPUBBLICA.VIS");
    resp.setValore("false");
    defaultProperties.put("PA.GARE.DOCINVITOPUBBLICA.VIS", resp);
  }
  
  public void addProperty(ConfigurationResponse resp) {
    this.properties.put(this.buildKeyOfMapFromValue(resp), resp);
  }
  
  private String buildKeyOfMapFromValue(ConfigurationResponse resp) {
    return resp.getCodapp()+"."+resp.getChiave();
  }
  
  public ConfigurationResponse getProperty(String key) {
    return properties.getOrDefault(key, defaultProperties.get(key));
  }
}
