package dz.elit.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;
    private String nom;
}
