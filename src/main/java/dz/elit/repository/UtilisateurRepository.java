package dz.elit.repository;

import dz.elit.model.Roles;
import dz.elit.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    //Utilisateur findByCode(String code);
}
