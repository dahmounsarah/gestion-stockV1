package dz.elit.repository;

import dz.elit.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category,Integer> {
    Category findByCode(String code);

}
