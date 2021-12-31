package it.maggioli.appalti.rest.swagger;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.maggioli.appalti.rest.spring.security.SecurityConfig;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket apiV1() {
    String version = "v1.0";
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName(version).select().apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.ant("/"+version+"/**"))
        .build().apiInfo(getApiInfoV1())
        .enableUrlTemplating(false)
        .forCodeGeneration(true)//TODO document
        .securityContexts(Arrays.asList(securityContext(version)))
        .securitySchemes(Arrays.asList(basicAuthScheme()))
        ;
  }
  
  private SecurityContext securityContext(String version) {
    return SecurityContext.builder()
        .securityReferences(Arrays.asList(basicAuthReference()))
        .forPaths(PathSelectors.ant("/"+version+"/"+SecurityConfig.PATH_AUTH_L190+"/**")).build();
  }

  private SecurityScheme basicAuthScheme() {
    return new ApiKey("Bearer", "Authorization", "header");
  }
  
  private SecurityReference basicAuthReference() {
    return new SecurityReference("Authorization", new AuthorizationScope[0]);
  }
  
//  @Bean
//  public Docket apiV11() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .groupName("v1.1").select().apis(RequestHandlerSelectors.any())
//        .paths(PathSelectors.ant("/v1.1/**"))
//        .build().apiInfo(getApiInfoV2());
//  }
//  @Bean
//  public Docket apiV2() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .groupName("v2.0").select().apis(RequestHandlerSelectors.any())
//        .paths(PathSelectors.ant("/v2.0/**"))
//        .build().apiInfo(getApiInfoV2());
//  }

  private ApiInfo getApiInfoV1() {
    return new ApiInfo("Appalti Rest", 
        "Applicativo Spring Boot RESTful per esporre i dati di Bandi, Esiti, Avvisi", 
        "1.0", null,
        new Contact("Maggioli", "https://www.maggioli.it/", "info@maggioli.it"), null,null, Collections.emptyList());
  }
  
  private ApiInfo getApiInfoV2() {
    return new ApiInfo("Appalti Rest", 
        "Applicativo Spring Boot RESTful per esporre i dati di Bandi, Esiti, Avvisi", 
        "2.0", null,
        new Contact("Maggioli", "https://www.maggioli.it/", "info@maggioli.it"), null,null, Collections.emptyList());
  }

}
