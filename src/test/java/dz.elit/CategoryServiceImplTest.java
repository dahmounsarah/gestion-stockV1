package dz.elit;


import dz.elit.dto.CategoryDto;
import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import dz.elit.service.CategoryService;
import lombok.NoArgsConstructor;
import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import lombok.NoArgsConstructor;


import java.util.NoSuchElementException;

@SpringBootTest
@RunWith(SpringRunner.class)
@NoArgsConstructor
 public class CategoryServiceImplTest {
// on utilise les mok sans inject les spring context dans la methode de test
    @Autowired
    private CategoryService categoryService;
    //tous les methode test sont void
    @Test
    public void shouldSaveCategoryWithSucces(){
        CategoryDto exceptedCategorie =CategoryDto.builder()
                .code("Code Categ sarah")
                .designation(" desg cat ")
              //  .idEntreprise(1)
                .build();
        CategoryDto savecCategorie =categoryService.save(exceptedCategorie);
        assertNotNull(savecCategorie);
      //  Assertions.assertNotNull(exceptedCategorie.getId());
        assertEquals(exceptedCategorie.getCode(),savecCategorie.getCode());
        assertEquals(exceptedCategorie.getDesignation(),savecCategorie.getDesignation());
      //  Assertions.assertEquals(exceptedCategorie.getEntrepriseDto(),savecCategorie.getEntrepriseDto());

    }
    @Test
    public void shouldUpdateCategoryWithSucces(){
        CategoryDto exceptedCategorie =CategoryDto.builder()
                .code("Code Categ 1")
                .designation(" desg cat ")
                //  .idEntreprise(1)
                .build();
        CategoryDto savedCategorie =categoryService.save(exceptedCategorie);
        CategoryDto categoryDtoToUpdate=savedCategorie;
        categoryDtoToUpdate.setCode("code update");
        savedCategorie =categoryService.save(categoryDtoToUpdate);
        assertNotNull(categoryDtoToUpdate);
        //  Assertions.assertNotNull(exceptedCategorie.getId());
        assertEquals(categoryDtoToUpdate.getCode(),savedCategorie.getCode());
        assertEquals(categoryDtoToUpdate.getDesignation(),savedCategorie.getDesignation());
        //  Assertions.assertEquals(exceptedCategorie.getEntrepriseDto(),savecCategorie.getEntrepriseDto());

    }


    @Test
    public void shouldThrouwInvalidEntityException(){
        CategoryDto exceptedCategorie =CategoryDto.builder().build();
        InvalidEntityException invalidEntityException= assertThrows(InvalidEntityException.class,()->categoryService.save(exceptedCategorie));
        assertEquals(ErrorCodes.CATOGORY_NOT_VALID,invalidEntityException.getErrorCodes());
        assertEquals(1,invalidEntityException.getErrors().size());
        assertEquals("Veuillez saisir le code categorie",invalidEntityException.getErrors().get(0));
    }
    @Test
    public void shouldThrouwEntityNotFoundException (){
        EntityNotFoundException entityNotFoundExceptions= assertThrows(EntityNotFoundException.class,()->categoryService.findById(0));
        assertEquals(ErrorCodes.CATOGORY_NOT_FOUD,entityNotFoundExceptions.getErrorCodes());
        assertEquals("Aucune catégorie trouve avec le id",entityNotFoundExceptions.getMessage());

    }
    @Test(expected= EntityNotFoundException.class)
    public void shouldThrouwEntityNotFoundException2 (){
        categoryService.findById(0);
    }
    @Test(expected= EntityNotFoundException.class)
    public void shouldThrouwEntityNotFoundException3 (){
        categoryService.findById(100);
    }

}
