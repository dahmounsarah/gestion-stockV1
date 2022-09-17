package dz.elit.service.auth;

import dz.elit.model.Utilisateur;
import dz.elit.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Utilisateur utilisateur=utilisateurRepository.findUtilisateurByEmail(email);

        List<SimpleGrantedAuthority> authorityList=new ArrayList<>();
        //utilisateur.getRoles().forEach(roles -> authorityList.add(new SimpleGrantedAuthority(roles.getRoleName())));
        return new User(utilisateur.getEmail(),utilisateur.getPassword()/*,utilisateurDto.getEntrepriseDto().getId()*/, authorityList);

    }
}
