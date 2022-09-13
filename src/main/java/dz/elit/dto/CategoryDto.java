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

    @JsonIgnore// pour ne pas map les categorie dans la liste
    private List<ArticleDto> articleDtos;

    // faire le mapping
    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
        } else {
          return CategoryDto.builder().id(category.getId()).code(category.getCode())
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
            return category;
        }
    }


}
