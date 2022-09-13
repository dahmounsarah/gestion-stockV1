package dz.elit.controller.api;

import dz.elit.dto.ArticleDto;
import dz.elit.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dz.elit.utils.Constants.APP_ROOT;

 @Api(APP_ROOT+"/entreprises")
public interface EntrepriseApi {
    @PostMapping(value = APP_ROOT+"/entreprises/create",consumes =
            MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    //Ajouter la documentation pour API
    @ApiOperation(value = "enregistre une entreprise (ajouter ou modifier",notes="cette methode permet d'nenrgistre ou modifier une entreprise ",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'object entreprise ajout ou modifier"),
            @ApiResponse(code=400,message = "L'objet entreprise no valide")
    })
    EntrepriseDto save(@RequestBody EntrepriseDto entrepriseDto);// pour la deserailisation des objets json vers ojbect dto

    @GetMapping(value = APP_ROOT+"/entreprises/findById/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping (value = APP_ROOT+"/entreprises/findByCode/{codeEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByNom(@PathVariable("codeCategorie") String code);

    @GetMapping (value = APP_ROOT+"/entreprises/ALL", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/entreprises/delete/{id}")
    void delete(@PathVariable("id") Integer id);
}
