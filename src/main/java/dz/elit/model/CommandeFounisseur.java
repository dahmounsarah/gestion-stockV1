package dz.elit.model;

import dz.elit.dto.AddressDto;
import dz.elit.dto.UtilisateurDto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commande_founisseur")


public class CommandeFounisseur extends AbstractEntity {

    @Column(name = "code")
    private String code;


    @Column(name = "date_commande_fournisseur")
    private Date dateCommandeFournisseur;


    @ManyToOne
    @JoinColumn(name = "id_fournisseur ")
    private Fournisseur fournieeur;

    @OneToMany(mappedBy = "commandeFounisseurs")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @Data
    @Builder
    public static class EntrepriseDto {

        private Integer id;
        private String nom;
        private String email;
        private String description;
        private String codeFiscal;
        private String photo;
        @Embedded // champ compose
        private AddressDto addressDto;
        private String telephone;
        private String siteWeb;
        private List<UtilisateurDto> utilisateurDtos;

        private EntrepriseDto fromEntity(Entreprise entreprise) {
            if (entreprise == null)
                return null;
            else
                return EntrepriseDto.builder().
                        id(entreprise.getId()).
                        nom(entreprise.getNom()).
                        email(entreprise.getEmail()).
                        description(entreprise.getDescription()).
                        codeFiscal(entreprise.getCodeFiscal()).
                        photo(entreprise.getPhoto()).
                        addressDto(AddressDto.fromEntity(entreprise.getAddress())).
                        telephone(entreprise.getTelephone()).
                        siteWeb(entreprise.getSiteWeb()).
                        build();

        }


        private Entreprise toEntity( EntrepriseDto entrepriseDto) {
            if (entrepriseDto == null)
                return null;
            else{
                Entreprise entreprise=new Entreprise();
                entreprise.setId(entrepriseDto.getId());
            return entreprise;
            }

        }



    }
}
