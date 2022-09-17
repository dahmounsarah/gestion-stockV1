package dz.elit.service;

import dz.elit.dto.UtilisateurDto;
import dz.elit.model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save(UtilisateurDto utilisateurDto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto findByCodeArticle(String code);

    List<UtilisateurDto> findAll();

    void delete(Integer utilisateurDtoId);
   Utilisateur findUtilisateurByEmail(String email );
}
