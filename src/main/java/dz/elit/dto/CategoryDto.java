package dz.elit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dz.elit.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class CategoryDto {

    private Integer id;
    private String code;
    private String designation;
    private EntrepriseDto entrepriseDto;

    @JsonIgnore// pour ne pas map les categorie dans la liste
    private List<ArticleDto> articleDtos;

    // faire le mapping
    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
        } else {
          return CategoryDto.builder().id(category.getId())
                  .code(category.getCode())
                  .designation(category.getDesignation())
                  // null pointer exception
                   .entrepriseDto(EntrepriseDto.fromEntity(category.getEntreprise()))
                  .build();

        }
    }

    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        } else {
            Category category = new Category();
            // car le id est dans la super clasee
            category.setId(categoryDto.getId());
            category.setCode(categoryDto.getCode());
            category.setDesignation(categoryDto.getDesignation());
            // nul pointer exception
            category.setEntreprise(EntrepriseDto.toEntity(categoryDto.getEntrepriseDto()));
            return category;
        }
    }


}
