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
@SuppressWarnings("java:S3749")
public class ConfigurationManager {
  private static final Logger logger = LoggerFactory.getLogger(ConfigurationManager.class);
  
  public static final String GARE_DOCINVITOPUBBLICA_VIS = "PA.GARE.DOCINVITOPUBBLICA.VIS";
  public static final String GARE_ATTIDOCART29_VIS = "PA.GARE.ATTIDOCART29.VIS";
  public static final String GARE_ADERENTI_VIS = "PA.GARE.ADERENTI.VIS";
  
  private ConcurrentHashMap<String,ConfigurationResponse> properties;
  private ConcurrentHashMap<String,ConfigurationResponse> defaultProperties;
  
  @PostConstruct
  public void postConstruct() {
    /*
     *  GARE ATTIDOCART29
        GARE ADERENTI
        GARE DOCINVITOPUBBLICA
     */
    properties = new ConcurrentHashMap<>();
    defaultProperties = new ConcurrentHashMap<>();
    ConfigurationResponse resp = new ConfigurationResponse();
    resp.setCodapp("PA");
    resp.setChiave("GARE.ATTIDOCART29.VIS");
    resp.setValore("true");
    defaultProperties.put(GARE_ATTIDOCART29_VIS, resp);
    resp = new ConfigurationResponse();
    resp.setCodapp("PA");
    resp.setChiave("GARE.ADERENTI.VIS");
    resp.setValore("false");
    defaultProperties.put(GARE_ADERENTI_VIS, resp);
    resp = new ConfigurationResponse();
    resp.setCodapp("PA");
    resp.setChiave("GARE.DOCINVITOPUBBLICA.VIS");
    resp.setValore("false");
    defaultProperties.put(GARE_DOCINVITOPUBBLICA_VIS, resp);
    logger.info("Configuration Manager deployed.");
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
