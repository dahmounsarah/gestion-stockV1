package dz.elit.model.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class ExtendedUser extends User {// c'est un utilisateur
    @Getter
    @Setter
    private String idEntreprise;


    public ExtendedUser(String username, String password,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public ExtendedUser(String username, String password,String idEntreprise,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
       this.idEntreprise=idEntreprise;
    }
}
