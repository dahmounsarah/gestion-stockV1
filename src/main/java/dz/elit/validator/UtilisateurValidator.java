package dz.elit.validator;

import dz.elit.dto.ArticleDto;
import dz.elit.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();
        if (utilisateurDto == null) {
            errors.add("Veuillez saisir le nom ");
            errors.add("Veuillez saisir le mot de passe ");
            errors.add("Veuillez saisir l'adresse' ");

        } else {
         if(StringUtils.hasLength(utilisateurDto.getNom()))
            errors.add("Veuillez saisir le nom ");

            if (StringUtils.hasLength(utilisateurDto.getPwd()))
                errors.add("Veuillez saisir le mot de passe ");
            if( utilisateurDto.getDateNaissance()==null)
                errors.add("Veuillez saisir date de naissanaces ");

            if (utilisateurDto.getAddress() == null) {
                errors.add("Veuillez saisir l'adresse' ");
            }else {
                if (StringUtils.hasLength(utilisateurDto.getAddress().getAddressed1()))
                    errors.add("Veuillez saisir l'adresse 1' ");
            }



        }
        return errors;
    }
}
