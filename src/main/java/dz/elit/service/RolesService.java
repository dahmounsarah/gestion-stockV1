package dz.elit.service;

import dz.elit.dto.RoleDto;

import java.util.List;

public interface RolesService {

    RoleDto save(RoleDto rolesDto);

    RoleDto findById(Integer id);

    RoleDto findByCodeArticle(String code);

    List<RoleDto> findAll();

    void delete(Integer rolesDtoId);
}
