package dz.elit.controller.api;

import dz.elit.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static dz.elit.utils.Constants.APP_ROOT;
@Api(APP_ROOT+"/articles")
public interface ArticleApi {
    @PostMapping(value = APP_ROOT+"/articles/create",consumes =
            MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistre un article (ajouter ou modifier",notes="cette methode permet d'nenrgistre ou modifier un article ",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'object article ajout ou modifier"),
            @ApiResponse(code=400,message = "L'objet article no valide")
    })
    ArticleDto save(@RequestBody ArticleDto articleDto);// pour la deserailisation des objets json vers ojbect dto

    @GetMapping (value = APP_ROOT+"/articles/findById/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un artcile par id ",notes="cette methode permet de cherche un artcle par son ID")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'object article est trouve dans la bd"),
            @ApiResponse(code=404,message = "aucune n'article n'est troouvé dans la BD")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping (value = APP_ROOT+"/articles/findByCode/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un artcile par code",notes="cette methode permet de cherche un artcle par son ID")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'object article est trouve dans la bd"),
            @ApiResponse(code=404,message = "aucune n'article n'est troouvé dans la BD")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String code);

    @GetMapping (value = APP_ROOT+"/articles/ALL", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List des artiles ",notes="cette methode permet de cherche un article par son ID")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "La liste des artiles "),

    })
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/articles/delete/{id}")
    @ApiOperation(value = "supprime un artile  ",notes="cette methode permet de supp un article par son ID")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "supprime l'article"),

    })
    void delete(@PathVariable("id") Integer id);



}
