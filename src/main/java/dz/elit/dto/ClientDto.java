package dz.elit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dz.elit.model.Client;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;


    private String prenom;


    private String raisonSocail;

    @Embedded // champ compose
    private AddressDto address;


    private String photo;


    private String mail;


    private String numTel;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client){
        if(client==null){
            return null;
        }else{
            return ClientDto.builder().
                    id(client.getId())
                   // commandeClients(client.getCommandeClients().stream().map(CommandeClientDto::fromEntity).collect(Collectors.toList()))
                           .build();

        }

    }
    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        } else {
            Client client = new Client();
            // car le id est dans la super clasee
            client.setId(clientDto.getId());
            client.setNom(clientDto.getNom());
//            article.setCode(articleDto.getCode());
//            article.setCategory(CategoryDto.toEntity(articleDto.getCategoryDto()));

            return client;
        }
    }


}
