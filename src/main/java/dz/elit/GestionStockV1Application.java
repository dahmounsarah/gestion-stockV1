package dz.elit;

import dz.elit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class GestionStockV1Application extends SpringBootServletInitializer {
	@Autowired
	private CategoryService categoryService;
	private  void incrementAndGetCount() {
		categoryService.findById(1);
		System.out.println("je suis la ");
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionStockV1Application.class, args);
		System.out.println("Hello World!2");


		//System.out.println("test"+ GestionStockV1Application.incrementAndGetCount());
		//System.out.println("Hello World!");
	}










}
