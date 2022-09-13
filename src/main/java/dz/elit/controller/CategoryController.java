package dz.elit.controller;

import dz.elit.controller.api.CategoryApi;
import dz.elit.dto.CategoryDto;
import dz.elit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoryController implements CategoryApi {


//    @Qualifier("articleServiceImpl")
    private CategoryService categoryService;


    @Autowired// contructeur injection
    public void CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;

    }

    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCodeCategory(String code) {
        return categoryService.findByCodeCategory(code);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
