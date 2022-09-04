package dz.elit.controller.api;

import dz.elit.dto.ArticleDto;
import dz.elit.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dz.elit.utils.Constants.APP_ROOT;

public interface CategoryApi {
    @PostMapping(value = APP_ROOT+"/category/create",consumes =
            MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);// pour la deserailisation des objets json vers ojbect dto

    @GetMapping(value = APP_ROOT+"/category/findById/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping (value = APP_ROOT+"/category/findByCode/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(@PathVariable("codeArticle") String code);

    @GetMapping (value = APP_ROOT+"/category/ALL", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/category/delete/{id}")
    void delete(@PathVariable("id") Integer id);
}
