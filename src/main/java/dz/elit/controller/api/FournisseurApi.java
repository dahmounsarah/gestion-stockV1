package dz.elit.controller.api;

import dz.elit.dto.FournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dz.elit.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/fournisseur")
public interface FournisseurApi {
    @PostMapping(value = APP_ROOT+"/fournisseur/create",consumes =
            MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);// pour la deserailisation des objets json vers ojbect dto

    @GetMapping(value = APP_ROOT+"/fournisseur/findById/{idFour}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idFour") Integer id);

    @GetMapping (value = APP_ROOT+"/fournisseur/findByNom/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findByNom(@PathVariable("nom") String code);

    @GetMapping (value = APP_ROOT+"/fournisseur/ALL", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/fournisseur/delete/{id}")
    void delete(@PathVariable("id") Integer id);
}
