package dz.elit.repository;
import dz.elit.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentesRepository extends JpaRepository<Vente,Integer> {
    Optional<Vente> findVenteByCode(String code);
}
