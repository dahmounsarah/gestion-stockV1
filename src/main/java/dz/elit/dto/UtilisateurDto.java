package dz.elit.dto;

import dz.elit.model.Address;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import java.util.Date;

@Data
@Builder
public class UtilisateurDto {

    private Integer id;

    private String nom;

    private String pwd;

    private Date dateNaissance;

    @Embedded // champ compose
    private Address address;

}
