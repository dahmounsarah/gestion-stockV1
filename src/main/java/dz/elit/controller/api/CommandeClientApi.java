package dz.elit.controller.api;


import dz.elit.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static dz.elit.controller.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/commandesclient")
public interface CommandeClientApi {
    @PostMapping(value = APP_ROOT+"/commandesclient/create",consumes =
            MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto commandeClientDto);

    @GetMapping(APP_ROOT+"/commandesclient/fincById/{id}")
     ResponseEntity<CommandeClientDto> findById(@PathVariable("id") Integer id);

    @GetMapping(APP_ROOT+"/commandesclient/fincById/{code}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("code") String code);

//    @GetMapping(value = APP_ROOT+"/commandesclient/all", produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(value = APP_ROOT+"/commandesclient/delete/{id}")
    ResponseEntity delete(@PathVariable("id") Integer commandeClientDtoId);


}
