package it.maggioli.appalti.rest.configuration.scheduler;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import it.maggioli.appalti.rest.configuration.response.ConfigurationResponse;
import it.maggioli.appalti.rest.manager.ConfigurationManager;

@Component
@RefreshScope
public class ConfigurationScheduler {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  
  @Value("${url.configuration.ms}")
  private String url;
  
  @Autowired
  private ConfigurationManager cfManager;
  
  @Scheduled(cron = "0 */5 * * * *")
  public void schedule() {
    try {
      logger.debug("Try to fetch data from {}",url);
      RestTemplate restTemplate = new RestTemplate();
//      restTemplate.exchange(RequestEntity.post(new URI(this.url+"/PA")).build(), Re);
      ResponseEntity<ConfigurationResponse[]> resp = restTemplate.getForEntity(new URI(this.url+"/PA"), ConfigurationResponse[].class);
      if(resp.getBody()!=null) {
        ConfigurationResponse[] arr = resp.getBody();
        for(ConfigurationResponse elem : arr) {
          cfManager.addProperty(elem);
        }
      } else {
        logger.warn("No data available");
      }
    } catch (Exception e) {
      logger.error("Error during retrieving configurations",e);
    }
  }
}
