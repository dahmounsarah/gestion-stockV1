package dz.elit.service.impl;

import dz.elit.dto.UtilisateurDto;
import dz.elit.model.Utilisateur;
import dz.elit.repository.UtilisateurRepository;
import dz.elit.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UtilsateurServiceImpl implements UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        return null;
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return null;
    }

    @Override
    public UtilisateurDto findByCodeArticle(String code) {
        return null;
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer utilisateurDtoId) {

    }
    @Override
    public Utilisateur findUtilisateurByEmail(String email) {
//        return utilisateurRepository.findUtilisateurByEmail(email).
//                orElseThrow(()-> new EntityNotFoundException("Aucune utilisateur par ce mail ", ErrorCodes.UTILISATEUR_NOT_FOUD));
//    }

        return null;
    }


}
