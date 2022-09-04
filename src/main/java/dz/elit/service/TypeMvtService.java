package dz.elit.service;

import dz.elit.dto.RolesDto;
import dz.elit.dto.TypeMvtDto;
import java.util.List;

public interface TypeMvtService {
    TypeMvtDto save(RolesDto rolesDto);

    RolesDto findById(Integer id);

    RolesDto findByCodeArticle(String code);

    List<RolesDto> findAll();

    void delete(Integer rolesDtoId);
}
