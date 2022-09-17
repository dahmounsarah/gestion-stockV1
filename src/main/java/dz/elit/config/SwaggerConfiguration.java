package dz.elit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

// spring vas excuter cette classe au démarage de l'application
@Configuration
@EnableSwagger2
//@EnableWebMvc
public class SwaggerConfiguration {
    private static final String AUTHORIZATION_HEADER="Authorization";

     @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(
                        new ApiInfoBuilder()
                                .description("Gestion de gestion documantation ")
                                .title("Gestion du stock Rest API")
                                .build()
                )
                .groupName("Sarah Rest API V1")
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("dz.elit"))
                .paths(PathSelectors.ant("/gestion_stock/V1" + "/**"))
                .build();
    }
private ApiKey apiKey (){
         return new ApiKey("JWT",AUTHORIZATION_HEADER,"header");

}
private SecurityContext securityContext(){
         return SecurityContext.builder().securityReferences(defaultAuth()).build();
}
private List<SecurityReference> defaultAuth(){
    AuthorizationScope authorizationScope=new AuthorizationScope("Global","accessEverything");
    AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
    authorizationScopes[0]=authorizationScope;
    return Collections.singletonList(new SecurityReference("JWT",authorizationScopes));

}

}
