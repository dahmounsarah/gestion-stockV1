package dz.elit.repository;

import dz.elit.model.MvtStk;
import dz.elit.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
    //Roles findByCode(String code);
}
