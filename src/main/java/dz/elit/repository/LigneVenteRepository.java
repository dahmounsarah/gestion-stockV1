package dz.elit.repository;
import dz.elit.model.LigneCommandeFournisseur;
import dz.elit.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {
  //  LigneVente findByCode(String code);
}
