package dz.elit.dto;

import dz.elit.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class UtilisateurDto {
    private Integer id;
    private String nom;
    private String password;
    private String email;
    private Date dateNaissance;
    private AddressDto addressDto;
    private EntrepriseDto entrepriseDto;
    private List<RolesDto> rolesDto;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null)
            return null;
        else
            return UtilisateurDto.builder().id(utilisateur.getId()).build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null) {
            return null;
        } else {
            Utilisateur utilisateur= new Utilisateur();
            // car le id est dans la super clasee
            utilisateur.setId(utilisateurDto.getId());
            return utilisateur;
        }
    }


}
