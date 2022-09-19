package dz.elit.repository;

import dz.elit.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role,Integer> {
    //Roles findByCode(String code);
}
