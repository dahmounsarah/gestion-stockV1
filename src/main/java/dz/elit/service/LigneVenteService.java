package dz.elit.service;
import dz.elit.dto.LigneVenteDto;
import java.util.List;
public interface LigneVenteService {

    LigneVenteDto save(LigneVenteDto ligneVenteDto);

    LigneVenteDto findById(Integer id);

    LigneVenteDto findByCodeArticle(String code);

    List<LigneVenteDto> findAll();

    void delete(Integer ligneVenteDtoId);
}
