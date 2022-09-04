package dz.elit.service;

import dz.elit.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save(FournisseurDto fournisseurDto);

    FournisseurDto findById(Integer id);

    FournisseurDto findByCodeArticle(String code);

    List<FournisseurDto> findAll();

    void delete(Integer fournisseurDtoId);
}
