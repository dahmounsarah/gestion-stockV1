package dz.elit.service;

import dz.elit.dto.CategoryDto;
import dz.elit.model.Category;

import java.util.List;

public interface CategoryService {

    Category save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findByCodeArticle(String code);

    List<CategoryDto> findAll();

    void delete(Integer categoryDtoId);
}
