package dz.elit.controller.api;

import dz.elit.dto.ClientDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dz.elit.controller.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/clients")
public interface ClientApi {
    @PostMapping(value = APP_ROOT+"/clients/create")
    ClientDto save(@RequestBody ClientDto clientDto);
    @GetMapping(APP_ROOT+"/clients/fincById/{id}")
    ClientDto findById(@PathVariable("id") Integer id);

    @GetMapping(APP_ROOT+"/clients/fincById/findByNom")
    ClientDto findByNom(@PathVariable("nom")  String nom);
    @GetMapping(APP_ROOT+"/clients/fincById/all")
    List<ClientDto> findAll();


    @DeleteMapping(value = APP_ROOT+"/clients/delete/{id}")
    void delete(@PathVariable("id") Integer clientDtoId);



}
