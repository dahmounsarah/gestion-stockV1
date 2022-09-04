package dz.elit.repository;

import dz.elit.model.Category;
import dz.elit.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByNom(String code);
}
