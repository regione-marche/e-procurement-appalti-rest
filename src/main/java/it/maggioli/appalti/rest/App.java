package it.maggioli.appalti.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableScheduling
@RefreshScope
@EnableMBeanExport(defaultDomain="appalti-rest") //this will prevent to try to instantiate same datasource if already present
@EnableWebMvc
public class App extends SpringBootServletInitializer {
    public static void main( String[] args ) {
      SpringApplication.run(App.class,args);
    }
}
