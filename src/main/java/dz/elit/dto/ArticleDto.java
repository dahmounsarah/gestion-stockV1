package dz.elit.dto;


import dz.elit.model.Article;
import lombok.Builder;
import lombok.Data;


@Data
@Builder

public class ArticleDto {

    private Integer id;
    private String code;
    private String designation;
    private String prixUnitaire;
    private String tauxTva;
    private String photo;
    private CategoryDto categoryDto;


    public static ArticleDto fromEntity(Article article) {
        if (article == null)
            return null;
        else
            return ArticleDto.builder().id(article.getId()).
                    code(article.getCode()).
                    designation(article.getDesignation()).
                    categoryDto(CategoryDto.fromEntity(article.getCategory())).build();
    }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        } else {
            Article article = new Article();
            // car le id est dans la super clasee
            article.setId(articleDto.getId());
            article.setDesignation(articleDto.getDesignation());
            article.setCode(articleDto.getCode());
            article.setCategory(CategoryDto.toEntity(articleDto.getCategoryDto()));

            return article;
        }
    }


}
