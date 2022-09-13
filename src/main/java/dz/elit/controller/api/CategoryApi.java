package dz.elit.controller.api;

import dz.elit.dto.ArticleDto;
import dz.elit.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dz.elit.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/category")
public interface CategoryApi {
    @PostMapping(value = APP_ROOT+"/category/create",consumes =
            MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    //Ajouter la documentation pour API
    @ApiOperation(value = "enregistre un category (ajouter ou modifier",notes="cette methode permet d'nenrgistre ou modifier un categorie ",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'object catgorie ajout ou modifier"),
            @ApiResponse(code=400,message = "L'objet category no valide")
    })
    CategoryDto save(@RequestBody CategoryDto categoryDto);// pour la deserailisation des objets json vers ojbect dto

    @GetMapping(value = APP_ROOT+"/category/findById/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping (value = APP_ROOT+"/category/findByCode/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(@PathVariable("codeCategorie") String code);

    @GetMapping (value = APP_ROOT+"/category/ALL", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/category/delete/{id}")
    void delete(@PathVariable("id") Integer id);
}
