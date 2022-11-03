package dz.elit;

import dz.elit.dto.CategoryDto;
import dz.elit.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class GestionStockV1ApplicationTests {
	@Autowired
	private CategoryService categoryService;
	@Test
	void contextLoads() {
		CategoryDto exceptedCategorie =CategoryDto.builder()
				.code("Code Categ sarah2")
				.designation(" desg cat ")
				//  .idEntreprise(1)
				.build();
		CategoryDto savecCategorie =categoryService.save(exceptedCategorie);
		Assertions.assertNotNull(savecCategorie);
		//  Assertions.assertNotNull(exceptedCategorie.getId());
		Assertions.assertEquals(exceptedCategorie.getCode(),savecCategorie.getCode());
		Assertions.assertEquals(exceptedCategorie.getDesignation(),savecCategorie.getDesignation());
		//  Assertions.assertEquals(exceptedCategorie.getEntrepriseDto(),savecCategorie.getEntrepriseDto());

	}

}
