package dz.elit.repository;

import dz.elit.model.LigneCommandeClient;
import dz.elit.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur,Integer> {
//    LigneCommandeFournisseur findByArtile(String article);
}
