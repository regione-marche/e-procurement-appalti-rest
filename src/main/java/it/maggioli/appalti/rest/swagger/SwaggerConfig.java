package it.maggioli.appalti.rest.swagger;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import it.maggioli.appalti.rest.spring.security.SecurityConfig;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Response;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiV1() {
        String version = "v1.0";
        return buildDocket(version);
    }
    @Bean
    public Docket apiV10_1() {
        String version = "1.0.1";
        return buildDocket(version);
    }
    @Bean
    public Docket apiV11() {
        String version = "v1.1";
        return buildDocket(version);
    }
    @Bean
    public Docket apiV12() {
        String version = "v1.2";
        return buildDocket(version);
    }
    
    @Bean
    public Docket apiV13() {
        String version = "v1.3";
        return buildDocket(version);
    }
    
    @Bean
    public Docket apiV14() {
        String version = "v1.4";
        return buildDocket(version);
    }



//  private SecurityContext securityContext(String version) {
//    return SecurityContext.builder()
//        .securityReferences(Arrays.asList(basicAuthReference()))
//        .forPaths(PathSelectors.ant("/"+version+"/"+SecurityConfig.PATH_AUTH_L190+"/**")).build();
//  }

    private SecurityContext securityContext(String version) {
        return SecurityContext.builder()
                .securityReferences(List.of(basicAuthReference()))
                .operationSelector((opContext) -> opContext.requestMappingPattern().matches(".+/" + version + "/" + SecurityConfig.PATH_AUTH_L190 + "/.+"))
//                .forPaths(PathSelectors.ant("/" + version + "/" + SecurityConfig.PATH_AUTH_L190 + "/**"))
                .build();
    }

    private SecurityScheme basicAuthScheme() {
        return new ApiKey("Bearer", "Authorization", "header");
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference("Authorization", new AuthorizationScope[0]);
    }

    /**
     * @param version
     * @return
     */
    private Docket buildDocket(String version) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/**/" + version + "/**"))
                .build()
                .apiInfo(getApiInfo(version))
                .enableUrlTemplating(false)
                .forCodeGeneration(true)//TODO document
                .globalResponses(
                        HttpMethod.GET
                        , List.of(
                                createResponse(HttpStatus.BAD_REQUEST)
                                , createResponse(HttpStatus.UNAUTHORIZED)
                                , createResponse(HttpStatus.FORBIDDEN)
                                , createResponse(HttpStatus.NOT_FOUND)
                                , createResponse(HttpStatus.INTERNAL_SERVER_ERROR)
                        )
                ).globalResponses(
                        HttpMethod.POST
                        , List.of(
                                createResponse(HttpStatus.BAD_REQUEST)
                                , createResponse(HttpStatus.UNAUTHORIZED)
                                , createResponse(HttpStatus.FORBIDDEN)
                                , createResponse(HttpStatus.NOT_FOUND)
                        )
                ).securityContexts(Collections.singletonList(securityContext(version)))
                .securitySchemes(List.of(basicAuthScheme()));
    }

    private Response createResponse(HttpStatus status) {
        return new ResponseBuilder()
                .code("" + status.value())
                .description(status.getReasonPhrase())
                .build();
    }

    private ApiInfo getApiInfo(String versione) {
        return new ApiInfo("Appalti Rest",
                "Applicativo Spring Boot RESTful per esporre i dati di Bandi, Esiti, Avvisi",
                versione, null,
                null, null, null, Collections.emptyList());
    }


}
