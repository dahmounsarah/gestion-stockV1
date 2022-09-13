package dz.elit.controller;

import dz.elit.controller.api.EntrepriseApi;
import dz.elit.dto.EntrepriseDto;
import dz.elit.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {

    @Autowired
    private EntrepriseService entrepriseService;

    @Autowired// contructeur injection
    public void EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;

    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return entrepriseService.save(entrepriseDto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDto findByNom(String code) {
        return entrepriseService.findByNom(code);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }


//
//
//    @Override
//    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
//        return entrepriseService.save(entrepriseDto);
//    }
//
//    @Override
//    public EntrepriseDto findById(Integer id) {
//        return entrepriseService.findById(id);
//    }
//
//    @Override
//    public EntrepriseDto findByNom(String code) {
//        return entrepriseService.findByNom(code);
//    }
//
//    @Override
//    public List<EntrepriseDto> findAll() {
//        return entrepriseService.findAll();
//    }
//
//    @Override
//    public void delete(Integer id) {
//        entrepriseService.delete(id);
//    }
}
