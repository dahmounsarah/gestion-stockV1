package dz.elit.config;

import dz.elit.utils.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.PathContainer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// spring vas excuter cette classe au démarage de l'application
@Configuration
@EnableSwagger2
//@EnableWebMvc
public class SwaggerConfiguration {

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(
                        new ApiInfoBuilder()
                        .description("gestion de gestion documantation ")
                        .title("gestion du stock Rest API")
                        .build()
                )
                .groupName("Rest API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("dz.elit"))
                .paths(PathSelectors.ant("/gestion_stock/V1" + "/**"))
                .build();
    }

}
