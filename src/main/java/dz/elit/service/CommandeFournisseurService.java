package dz.elit.service;
import dz.elit.dto.CommandeFournisseurDto;
import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

    CommandeFournisseurDto findById(Integer id);

    CommandeFournisseurDto findByCodeArticle(String code);

    List<CommandeFournisseurDto> findAll();

    void delete(Integer commandeFournisseurDtoId);
}
