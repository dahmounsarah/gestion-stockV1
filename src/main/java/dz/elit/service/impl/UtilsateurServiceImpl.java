package dz.elit.service.impl;

import dz.elit.dto.UtilisateurDto;
import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.repository.UtilisateurRepository;
import dz.elit.service.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("utilsateurServiceImpl")
@Slf4j// un logger lombok
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
    public UtilisateurDto findUtilisateurByEmail(String email) {
        return utilisateurRepository.findUtilisateurByEmail(email).map(UtilisateurDto::fromEntity)
                .orElseThrow(() ->new EntityNotFoundException("Aucune utilisateur avec l'email  "+email+"dans la base de données ", ErrorCodes.UTILISATEUR_NOT_FOUD));

    }


}
