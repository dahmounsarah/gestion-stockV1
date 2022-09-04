package dz.elit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dz.elit.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


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
            //System.out.println(category.getId());
//            CategoryDto categoryDto = new CategoryDto();
//            categoryDto.setId(category.getId());
//            categoryDto.setCode(category.getCode());
//            categoryDto.setArticleDtos(category.getArticles().stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
            return CategoryDto.builder().id(category.getId()).code(category.getCode())
                    .articleDtos(category.getArticles().stream().map(ArticleDto::fromEntity).collect(Collectors.toList())).build();
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
