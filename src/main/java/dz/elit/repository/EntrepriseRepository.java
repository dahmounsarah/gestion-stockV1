package dz.elit.repository;

import dz.elit.model.CommandeFounisseur;
import dz.elit.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
    //Entreprise findByCode(String code);
}
