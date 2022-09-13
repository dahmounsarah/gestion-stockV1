package dz.elit.repository;

import dz.elit.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//@RepositoryRestResource
// pour les projets poc pour convaicare le client
// travail les multi module dans le meme projet avec les micro-services ou avec des projet spary
public interface ArticleRepository extends JpaRepository<Article,Integer> {


//    Ajout de méthodes dans une interface de repository
//            L’interface JpaRepository<T, ID> déclare beaucoup de
//            méthodes mais elles suffisent rarement pour implémenter
//            les fonctionnalités attendues d’une application. Spring
//    Data utilise une convention de nom pour générer automatiquement
//    le code sous-jacent et exécuter la requête. La requête est déduite de
//    la signature de la méthode (on parle de query methods).
//    La convention est la suivante : Spring Data JPA supprime du début de
//    la méthode les prefixes find, read, query, count and get et recherche
//    la présence du mot By pour marquer le début des critères de filtre.
//    Chaque critère doit correspondre à un paramètre de la méthode dans le même ordre.
//    // la couche DAO
 //   Article find

    List<Article> findByCode(String code);


//    @Query("select a from Article a where a.code =: code and a.designation =: designation")
//    List<Article> findByCustomQuery(String code,String designation);
////
//
//    @Query("select  a from Article a where a.code =: code and a.designation =: designation")
//    List<Article> findByCustomQuery2(@Param("code") String c, @Param("designation") String d);
//
//   @Query("select a from Article  a where code =: code ")
//    List<Article> findByCustomQuery(String code);
////
//   @Query(value = "select * from article where code =: code ",nativeQuery = true)
//   List<Article> findByCustomQueryNative(String code);
//
//    //List<Article> findByCodeIngorecaseByDesigantion(String code,String designation);
//    // plus de détails avec la document officiel spring DATA
//



    //Article finArticle
}
