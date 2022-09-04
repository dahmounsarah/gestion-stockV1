package dz.elit.service;

import dz.elit.dto.VenteDto;

import java.util.List;

public interface VentesService {

    VenteDto save(VenteDto venteDto);

    VenteDto findById(Integer id);

    VenteDto findByCodeArticle(String code);

    List<VenteDto> findAll();

    void delete(Integer venteDtoId);
}
