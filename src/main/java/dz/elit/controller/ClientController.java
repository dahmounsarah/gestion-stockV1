package dz.elit.controller;

import dz.elit.controller.api.ClientApi;
import dz.elit.dto.ClientDto;
import dz.elit.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    ClientService clientService;



    @Autowired
    public void ClientController(ClientService clientService){
        this.clientService=clientService;

    }


//    @Override
//    public ClientDto save(ClientDto clientDto) {
//       // this.clientDto = clientDto;
//        return clientRepository.save(clientDto);
//    }
    // le type de reponse peut etre ResponseEntity

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }


//    @Override
//    public ClientDto findById(Integer id) {
//        return clientService.findById(id);
//    }

    @Override
    public ClientDto findByNom(String nom) {
        return clientService.findByNom(nom);
    }


    @Override
    public List<ClientDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer commandeClientDtoId) {

    }
}
