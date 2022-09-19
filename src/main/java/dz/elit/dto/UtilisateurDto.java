package dz.elit.dto;

import dz.elit.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<RoleDto> rolesDto;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null)
            return null;
        else
            return UtilisateurDto.builder().id(utilisateur.getId())
                    .nom(utilisateur.getNom())
                    .password(utilisateur.getPassword())
                    .email(utilisateur.getEmail())
                    .dateNaissance(utilisateur.getDateNaissance())
                    .addressDto(AddressDto.fromEntity(utilisateur.getAddress()))
                    .entrepriseDto(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                    .rolesDto(utilisateur.getRoles().stream().map(RoleDto::fromEntity).collect(Collectors.toList()))

                    .build();
//    }
        }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
        if (utilisateurDto == null) {
            return null;
        } else {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(utilisateurDto.getId());
            utilisateur.setPassword(utilisateurDto.getPassword());
            utilisateur.setEmail(utilisateurDto.getEmail());
            utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
            utilisateur.setAddress(AddressDto.toEntity(utilisateurDto.getAddressDto()));
            utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntrepriseDto()));
            return utilisateur;
        }
    }


}
