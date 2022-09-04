package dz.elit.validator;

import dz.elit.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public  static  List<String> validate(CategoryDto categoryDto){
        List<String> errors= new ArrayList<>();
        if(categoryDto==null || StringUtils.hasLength(categoryDto.getCode()))
            errors.add("Veuillez saisir le code categorie");
        return errors;

    }
}
