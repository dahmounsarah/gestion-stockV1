package dz.elit.service.auth;

import dz.elit.dto.UtilisateurDto;
import dz.elit.model.auth.ExtendedUser;
import dz.elit.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    UtilisateurService utilisateurService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       UtilisateurDto utilisateurDto=utilisateurService.findUtilisateurByEmail(email);

        List<SimpleGrantedAuthority> authorityList=new ArrayList<>();
//        System.out.println(" utilisateurDto.getRolesDto()"+ utilisateurDto.getRolesDto().size());
//        utilisateurDto.getRolesDto().forEach(roles -> authorityList.add(new SimpleGrantedAuthority(roles.getRoleName())));
//
        return new ExtendedUser(utilisateurDto.getEmail(),utilisateurDto.getPassword(),
                /*,utilisateurDto.getEntrepriseDto().getId(),*/ authorityList);

    }
}
