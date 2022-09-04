package dz.elit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dz.elit.model.Article;
import dz.elit.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Data
@Builder
public class CommandeClientDto {

    private Integer id;

    private String code;

    private Date dateCommande;

    private ClientDto clientDto;

    private List<LigneCommandeClientDto> ligneCommandeClientDtos;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        return CommandeClientDto.builder().id(commandeClient.getId()).
                code(commandeClient.getCode()).
                dateCommande(commandeClient.getDateCommande()).
                clientDto(ClientDto.fromEntity(commandeClient.getClient())).
               // ligneCommandeClientDtos(commandeClient.getLigneCommandeClients())
                build();
    }

    public static CommandeClient  toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
        } else {
            CommandeClient commandeClient = new CommandeClient();
            // car le id est dans la super clasee
            commandeClient.setId(commandeClientDto.getId());
            commandeClient.setCode(commandeClientDto.getCode());
            commandeClient.setDateCommande(commandeClientDto.getDateCommande());
            commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClientDto()));
            return commandeClient;
        }


    }

}
