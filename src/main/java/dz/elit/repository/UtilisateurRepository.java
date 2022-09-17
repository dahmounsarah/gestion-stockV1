package dz.elit.repository;

import dz.elit.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
   // @Query("select u  from Utilisateur u where u.email=:email" )
    //(@Param("email")
    Utilisateur findUtilisateurByEmail(String email );
}
