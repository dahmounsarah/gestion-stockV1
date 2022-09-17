package dz.elit.service.impl;

import dz.elit.dto.CategoryDto;
import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import dz.elit.repository.CategoryRepository;
import dz.elit.service.CategoryService;
import dz.elit.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("categoryServiceImpl")
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired// une injection par contructeur
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if (!errors.isEmpty()) {
            log.error("Categorie not valide {}" + categoryDto);
            throw new InvalidEntityException("Invalide article", ErrorCodes.ARTICLE_INVALID, errors);
        } else {
            return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
        }


    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Id catégorie null");
            return null;
        } else {
            Optional<CategoryDto> categoryDto= Optional.ofNullable(CategoryDto.fromEntity(categoryRepository.findById(id).get()));
            return Optional.of(categoryDto).orElseThrow(()->new EntityNotFoundException
                    ("Aucune catégorie trouve avec le id"+id,ErrorCodes.CATOGORY_NOT_FOUD)).get();

        }

    }


    @Override
    public CategoryDto findByCodeCategory(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Error code est vide");
            return null;}
        else{
            CategoryDto categoryDto=CategoryDto.fromEntity(categoryRepository.findByCode(code));
            return Optional.of(categoryDto).orElseThrow(()->new EntityNotFoundException  ("Aucune catégorie trouve avec le code"+code,ErrorCodes.CATOGORY_NOT_FOUD));
        }

    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer categoryDtoId) {
        if (categoryDtoId== null) {
            log.error("Error id est null");
            return ;
        } else {
            categoryRepository.deleteById(categoryDtoId);

        }

    }
}
