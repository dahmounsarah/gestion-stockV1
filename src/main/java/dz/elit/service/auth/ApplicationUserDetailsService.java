package dz.elit.service.auth;

import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.model.Utilisateur;
import dz.elit.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur=utilisateurRepository.findUtilisateurByEmail(email).orElseThrow(()->
                new EntityNotFoundException("aucune utilisateur trouve ",ErrorCodes.UTILISATEUR_NOT_FOUD));
        return new User(utilisateur.getEmail(),utilisateur.getPwd(), Collections.emptyList());
       //  null;
    }
}
