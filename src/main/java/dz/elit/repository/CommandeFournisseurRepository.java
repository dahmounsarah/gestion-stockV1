package dz.elit.repository;
import dz.elit.model.CommandeClient;
import dz.elit.model.CommandeFounisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFounisseur,Integer> {

    Optional<CommandeFounisseur> findCommandeFournisseurByCode(String code);;
}
