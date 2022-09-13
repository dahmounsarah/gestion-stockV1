package dz.elit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dz.elit.model.Address;
import dz.elit.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import java.util.List;

@Data
@Builder
public class EntrepriseDto {


    private Integer id;
    private String nom;
    private String email;
    private String description;
    private String codeFiscal;
    private String photo;
    @Embedded // champ compose
    private Address addressDto;
    private String telephone;
    private String siteWeb;
    @JsonIgnore
    private List<UtilisateurDto> utilisateursDto;


    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        return EntrepriseDto.builder().id(entreprise.getId()).
                nom(entreprise.getNom()).
                email(entreprise.getEmail()).
                description(entreprise.getDescription()).
                // ligneCommandeClientDtos(commandeClient.getLigneCommandeClients())
                        build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
        } else {
            Entreprise entreprise = new Entreprise();
            // car le id est dans la super clasee
            entreprise.setId(entrepriseDto.getId());
            entreprise.setNom(entrepriseDto.getNom());
            entreprise.setDescription(entrepriseDto.getDescription());

            return entreprise;
        }


    }
}
