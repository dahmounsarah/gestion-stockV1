package dz.elit.controller.api;

import dz.elit.dto.CategoryDto;
import dz.elit.dto.FournisseurDto;
import dz.elit.model.Fournisseur;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dz.elit.utils.Constants.APP_ROOT;

public interface FournisseurApi {
    @PostMapping(value = APP_ROOT+"/fournisseur/create",consumes =
            MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);// pour la deserailisation des objets json vers ojbect dto

    @GetMapping(value = APP_ROOT+"/fournisseur/findById/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping (value = APP_ROOT+"/fournisseur/findByNom/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByNom(@PathVariable("nom") String code);

    @GetMapping (value = APP_ROOT+"/fournisseur/ALL", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/fournisseur/delete/{id}")
    void delete(@PathVariable("id") Integer id);
}
