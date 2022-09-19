package dz.elit.repository;

import dz.elit.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
   // @Query("select u  from Utilisateur u where u.email=:email" )
    //(@Param("email")
    Optional<Utilisateur> findUtilisateurByEmail(String email );
}
