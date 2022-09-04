package dz.elit.validator;

import dz.elit.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


 public final class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto){
        List<String> errors= new ArrayList<>();
        System.out.println(articleDto.getDesignation());
        System.out.println(StringUtils.hasLength(articleDto.getDesignation()));
        if(articleDto==null || !StringUtils.hasLength(articleDto.getDesignation()))
            errors.add("Veuillez saisir la désignation ");
        return errors;
    }

}
