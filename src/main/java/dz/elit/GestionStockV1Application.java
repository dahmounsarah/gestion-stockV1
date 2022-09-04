package dz.elit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class GestionStockV1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GestionStockV1Application.class, args);
		System.out.println("Hello World!2");
		//System.out.println("Hello World!");
	}








}
