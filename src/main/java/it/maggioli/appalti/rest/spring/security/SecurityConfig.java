package it.maggioli.appalti.rest.spring.security;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import it.maggioli.appalti.rest.filters.FilterAuthentication;
import it.maggioli.appalti.rest.manager.AuthenticationManager;

/**
 * This class will provide the security for all the services exposed by the application
 * @author gabriele.nencini
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
  private Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
  public static final String PATH_AUTH_L190 = "l190";

  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().anyRequest().permitAll();
    logger.info("Security done");
  }

  @Bean
  public FilterRegistrationBean<FilterAuthentication> authenticationFilter() {
    logger.info("Reading all classes in package 'it.maggioli.appalti'");
    Reflections reflections = new Reflections("it.maggioli.appalti", new SubTypesScanner(false), new TypeAnnotationsScanner());

    Set<Class<? extends Object>> allClasses = reflections.getTypesAnnotatedWith(org.springframework.web.bind.annotation.RequestMapping.class);
    Set<String> rootPaths = new HashSet<String>();
    Set<String> pathsForAuth = new HashSet<String>();
    String searchChars = "{}";
    for (Class<?> el : allClasses) {
      RequestMapping ann = el.getAnnotation(org.springframework.web.bind.annotation.RequestMapping.class);
      if (ann.value() != null) {
        for (String val : ann.value()) {
          rootPaths.add(val);
        }
      }
      logger.debug("Class: ", el.getCanonicalName());
      for (Method m : el.getMethods()) {
        ApiOperation ao = m.getAnnotation(ApiOperation.class);
        if (ao != null) {
          if (ao.authorizations() != null && ao.authorizations().length > 0) {
            logger.trace("ao {}", ao);
            boolean needAuth = false;
            for(Authorization auth : ao.authorizations()) {
              if(StringUtils.isNotBlank(auth.value())) {
                needAuth = true;
                break;
              }
            }
            if(needAuth) {
              GetMapping gm = m.getAnnotation(GetMapping.class);
              if (gm != null) {
                for (String path : gm.path()) {
                  if (StringUtils.containsAny(path, searchChars)) {
                    pathsForAuth.add(StringUtils.substringBeforeLast(StringUtils.substringBefore(path, "{"), "/"));
                  }
                }
              }
            }
          }
        }
      }
    }

    logger.info("Registering filter");
    FilterRegistrationBean<FilterAuthentication> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new FilterAuthentication(authenticationManager));
    for (String path : rootPaths) {
      if(!"/error".equalsIgnoreCase(path)) {
        registrationBean.addUrlPatterns("/" + path + "/" + PATH_AUTH_L190 + "/*");
        for (String pathForAuth : pathsForAuth) {
          registrationBean.addUrlPatterns("/" + path + "/" + (pathForAuth.startsWith("/")?pathForAuth.substring(1):pathForAuth) + "/*");
        }
      }
    }
    registrationBean.getUrlPatterns().stream().forEach(logger::info);
    logger.info("Registered filter");
    return registrationBean;
  }
}
