package dz.elit.dto;

import dz.elit.model.CommandeFounisseur;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;
    private String code;
    private Date dateCommandeFournisseur;
    private FournisseurDto fournieeurDto;
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDtos;

    public static CommandeFournisseurDto fromEntity(CommandeFounisseur commandeFounisseur) {
        return CommandeFournisseurDto.builder().id(commandeFounisseur.getId()).
                code(commandeFounisseur.getCode()).
                dateCommandeFournisseur(commandeFounisseur.getDateCommandeFournisseur()).
                fournieeurDto(FournisseurDto.fromEntity(commandeFounisseur.getFournieeur())).
                // ligneCommandeClientDtos(commandeClient.getLigneCommandeClients())
                        build();
    }

    public static CommandeFounisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if (commandeFournisseurDto == null) {
            return null;
        } else {
            CommandeFounisseur commandeFounisseur = new CommandeFounisseur();
            // car le id est dans la super clasee
            commandeFounisseur.setId(commandeFournisseurDto.getId());
            commandeFounisseur.setCode(commandeFournisseurDto.getCode());
            commandeFounisseur.setDateCommandeFournisseur(commandeFournisseurDto.getDateCommandeFournisseur());
            commandeFounisseur.setFournieeur(FournisseurDto.toEntity(commandeFournisseurDto.getFournieeurDto()));
            return commandeFounisseur;
        }
    }


}
