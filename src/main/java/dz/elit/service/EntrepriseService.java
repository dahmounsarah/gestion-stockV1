package dz.elit.service;
import dz.elit.dto.EntrepriseDto;
import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto entrepriseDto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findByCodeArticle(String code);

    List<EntrepriseDto> findAll();

    void delete(Integer entrepriseDtoId);
}
