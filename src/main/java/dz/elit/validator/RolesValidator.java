package dz.elit.validator;

import dz.elit.dto.RolesDto;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {
    public static List<String> validate(RolesDto rolesDto){
        List<String> errors= new ArrayList<>();
//        System.out.println(articleDto.getDesignation());
//        System.out.println(StringUtils.hasLength(articleDto.getDesignation()));
//        if(articleDto==null || !StringUtils.hasLength(articleDto.getDesignation()))
//            errors.add("Veuillez saisir la désignation ");
        return errors;
    }
}
