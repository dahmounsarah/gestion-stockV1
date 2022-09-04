package dz.elit.controller.api;

import dz.elit.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dz.elit.utils.Constants.APP_ROOT;

public interface UtilisateurApi {
    @PostMapping(value = APP_ROOT+"/articles/create",consumes =
            MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto articleDto);// pour la deserailisation des objets json vers ojbect dto

    @GetMapping (value = APP_ROOT+"/articles/findById/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping (value = APP_ROOT+"/articles/findByCode/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String code);

    @GetMapping (value = APP_ROOT+"/articles/ALL", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/articles/delete/{id}")
    void delete(@PathVariable("id") Integer id);



}
