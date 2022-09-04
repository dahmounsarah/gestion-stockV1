package dz.elit.service.impl;

import dz.elit.dto.ArticleDto;
import dz.elit.exception.EntityNotFoundException;
import dz.elit.exception.ErrorCodes;
import dz.elit.exception.InvalidEntityException;
import dz.elit.model.Article;
import dz.elit.repository.ArticleRepository;
import dz.elit.service.ArticleService;
import dz.elit.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("articleServiceImpl")
@Slf4j// un logger lombok
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    @Autowired// une injection par contructeur
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()) {
            log.error("Article not valide {}" + articleDto);
            throw new InvalidEntityException("Invalide article", ErrorCodes.ARTICLE_INVALID, errors);
        } else {
            return ArticleDto.fromEntity(
                    articleRepository.save(ArticleDto.toEntity
                            (articleDto))
            );
        }

    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Error id est null");
            return null;
        } else {
            // pour get
            Optional<Article> article = articleRepository.findById(id);
            //ArticleDto articleDto=ArticleDto.fromEntity(article.get());
            return Optional.of(ArticleDto.fromEntity(article.get())).
                    orElseThrow(() -> new EntityNotFoundException("Aucun article n'est trouve ave" +
                            "le Id" + id, ErrorCodes.ARTICLE_NOT_FOUND));
        }

    }

    @Override
    public ArticleDto findByCodeArticle(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Error code est vide");
            return null;
        } else {
            // pour get
            Optional<Article> article = articleRepository.findByCode(code);
            //ArticleDto articleDto=ArticleDto.fromEntity(article.get());
            return Optional.of(ArticleDto.fromEntity(article.get())).
                    orElseThrow(() -> new EntityNotFoundException("Aucun article n'est trouve ave" +
                            "le code" + code, ErrorCodes.ARTICLE_NOT_FOUND));

        }
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream().
                map(ArticleDto::fromEntity).// faire le mapping en les obj avec la methode fromEntity
                        collect(Collectors.toList());
    }



    @Override
    public void delete(Integer articleDtoId) {
        if (articleDtoId== null) {
            log.error("Error id est null");
            return ;
        } else {
            articleRepository.deleteById(articleDtoId);

        }
    }
}
