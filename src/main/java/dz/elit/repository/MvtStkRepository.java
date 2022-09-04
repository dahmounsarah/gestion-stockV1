package dz.elit.repository;

import dz.elit.model.LigneVente;
import dz.elit.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStkRepository extends JpaRepository<MvtStk,Integer> {
   // MvtStk findByCode(String code);
}
