package dz.elit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// spring vas excuter cette classe au démarage de l'application
@Configuration
@EnableSwagger2
//@EnableWebMvc
public class SwaggerConfiguration {
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
                .select()
                .apis(RequestHandlerSelectors.basePackage("dz.elit"))
                .paths(PathSelectors.ant("/gestion_stock/V1" + "/**"))
                .build();
    }

}
