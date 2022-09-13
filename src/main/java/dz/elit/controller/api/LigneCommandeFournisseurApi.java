package dz.elit.controller.api;

import dz.elit.dto.CommandeFournisseurDto;

import java.util.List;


public interface LigneCommandeFournisseurApi {

    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

    CommandeFournisseurDto findById(Integer id);

    CommandeFournisseurDto findByCode(String code);

    List<CommandeFournisseurDto> findAll();

    void delete(Integer commandeFournisseurDtoId);
}
