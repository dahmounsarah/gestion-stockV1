package dz.elit.controller.api;

import dz.elit.dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dz.elit.controller.utils.Constants.APP_ROOT;


@Api(APP_ROOT+"/commandesfournisseur")
public interface CommandeFournisseurApi {
    @PostMapping(value = APP_ROOT+"/commandesfournisseur/create",consumes =
            MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto commandeFournisseurDto);

    @GetMapping(APP_ROOT+"/commandesfournisseur/fincById/{id}")
    CommandeFournisseurDto findById(@PathVariable("id") Integer id);

    @GetMapping(APP_ROOT+"/commandesfournisseur/fincByCode/{code}")
    CommandeFournisseurDto findByCode(@PathVariable("code") String code);

    @GetMapping(value = APP_ROOT+"/commandesfournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeFournisseurDto> findAll();

    @DeleteMapping(value = APP_ROOT+"/commandesfournisseur/delete/{id}")
    void delete(@PathVariable("id") Integer commandeClientDtoId);





}
