package dz.elit.controller;

import dz.elit.controller.api.CommandeClientApi;
import dz.elit.dto.CommandeClientDto;
import dz.elit.service.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommandeClientController implements CommandeClientApi {

    CommandeClientService commandeClientService;

    @Autowired
    public void CommandeClientController(CommandeClientService commandeClientService){
        this.commandeClientService=commandeClientService;

    }

    @Override
    public ResponseEntity<CommandeClientDto> save(CommandeClientDto commandeClientDto) {
        // les codes 200 pour le seccus

        return ResponseEntity.ok(commandeClientService.save(commandeClientDto));
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commandeClientService.save(commandeClientDto));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findById(Integer id) {
        return ResponseEntity.ok(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));
    }

//    @Override
//    public ResponseEntity<List<CommandeClientDto>> findAll() {
//        return ResponseEntity.ok(commandeClientService.findAll());
//    }

    @Override
    public ResponseEntity delete(Integer commandeClientDtoId) {
        // lever une exception dans le cas de la suppresion d'une commande utilise
        commandeClientService.delete(commandeClientDtoId);
        return ResponseEntity.ok().build();
    }
}
