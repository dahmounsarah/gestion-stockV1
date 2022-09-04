package dz.elit.repository;

import dz.elit.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
    //Fournisseur findByNom(String nom);
}
