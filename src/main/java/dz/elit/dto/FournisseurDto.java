package dz.elit.dto;

import dz.elit.model.Address;
import dz.elit.model.Client;
import dz.elit.model.CommandeFounisseur;
import dz.elit.model.Fournisseur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String raisonSocail;

    @Embedded // champ compose
    private AddressDto address;

    private String photo;

    private String mail;

    private String numTel;

    private List<CommandeFournisseurDto> commandeFounisseurDtos;

    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        if(fournisseur==null){
            return null;
        }else{
            return FournisseurDto.builder().
                    id(fournisseur.getId())
                    // commandeClients(client.getCommandeClients().stream().map(CommandeClientDto::fromEntity).collect(Collectors.toList()))
                    .build();

        }

    }
    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) {
            return null;
        } else {
            Fournisseur fournisseur = new Fournisseur();
            // car le id est dans la super clasee
            fournisseur.setId(fournisseurDto.getId());
            fournisseur.setNom(fournisseurDto.getNom());
//            article.setCode(articleDto.getCode());
//            article.setCategory(CategoryDto.toEntity(articleDto.getCategoryDto()));

            return fournisseur;
        }
    }


}
