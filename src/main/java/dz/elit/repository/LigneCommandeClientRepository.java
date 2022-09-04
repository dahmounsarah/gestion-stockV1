package dz.elit.repository;

import dz.elit.model.Fournisseur;
import dz.elit.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {
   // LigneCommandeClient findByCode(String code);
}
