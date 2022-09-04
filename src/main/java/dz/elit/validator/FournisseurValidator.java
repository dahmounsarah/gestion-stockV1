package dz.elit.validator;

import dz.elit.dto.CommandeFournisseurDto;
import dz.elit.dto.FournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String> errors= new ArrayList<>();
//        System.out.println(articleDto.getDesignation());
//        System.out.println(StringUtils.hasLength(articleDto.getDesignation()));
//        if(articleDto==null || !StringUtils.hasLength(articleDto.getDesignation()))
//            errors.add("Veuillez saisir la désignation ");
        return errors;
    }
}
