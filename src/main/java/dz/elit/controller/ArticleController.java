package dz.elit.controller;


import dz.elit.controller.api.ArticleApi;
import dz.elit.dto.ArticleDto;
import dz.elit.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    @Autowired// field injection


//    @Qualifier("articleServiceImpl")
    private ArticleService articleService;

  //  @Autowired// set injection
   // public ArticleService setArticleService() {
  //      return articleService;
 //   }

    @Autowired// contructeur injection
    public void ArticleController(ArticleService articleService){
        this.articleService=articleService;

    }


    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);

    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String code) {
        return articleService.findByCodeArticle(code);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer articleDtoID) {
        articleService.delete(articleDtoID);
    }

    @GetMapping({ "/hello" })
    public String firstPage() {
        return "Hello World2";
    }

//    @Autowired
//    @Qualifier("articleServiceImpl2")
//    // ferme la modification ouvert a l'extention
//   private ArticleService articleService2;
}
