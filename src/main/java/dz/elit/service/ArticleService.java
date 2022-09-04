package dz.elit.service;

import dz.elit.dto.ArticleDto;

import java.util.List;
// Jpa inteface(specification et hibernete c l'implementation

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String code);

    List<ArticleDto> findAll();

    void delete(Integer articleDtoId);


}
