package dz.elit.service;

import dz.elit.dto.RoleDto;
import dz.elit.dto.TypeMvtDto;
import java.util.List;

public interface TypeMvtService {
    TypeMvtDto save(RoleDto rolesDto);

    RoleDto findById(Integer id);

    RoleDto findByCodeArticle(String code);

    List<RoleDto> findAll();

    void delete(Integer rolesDtoId);
}
