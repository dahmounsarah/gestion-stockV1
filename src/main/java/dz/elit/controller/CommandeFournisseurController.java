package dz.elit.controller;

import dz.elit.controller.api.CommandeFournisseurApi;
import dz.elit.dto.CommandeFournisseurDto;
import dz.elit.service.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    CommandeFournisseurService commandeFournisseurService;

    @Autowired
    public void CommandeClientController(CommandeFournisseurService commandeFournisseurService){
        this.commandeFournisseurService=commandeFournisseurService;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        return commandeFournisseurService.save(commandeFournisseurDto);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        return commandeFournisseurService.findById(id);
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCodeArticle(code);
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();
    }

    @Override
    public void delete(Integer commandeClientDtoId) {
        commandeFournisseurService.delete(commandeClientDtoId);
    }
}
