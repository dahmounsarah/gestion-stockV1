package dz.elit.service;

import dz.elit.dto.RolesDto;

import java.util.List;

public interface RolesService {

    RolesDto save(RolesDto rolesDto);

    RolesDto findById(Integer id);

    RolesDto findByCodeArticle(String code);

    List<RolesDto> findAll();

    void delete(Integer rolesDtoId);
}
