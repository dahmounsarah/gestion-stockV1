package dz.elit.dto;

import dz.elit.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer ligne;
    private ArticleDto articleDto;
    private CommandeClientDto commandeClientDto;
    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null)
            return null;
        else
            return LigneCommandeClientDto.builder().ligne(ligneCommandeClient.getId()).
                    articleDto(ArticleDto.fromEntity(ligneCommandeClient.getArticle())).
                    commandeClientDto(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient())).
                    build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
        if (ligneCommandeClientDto == null) {
            return null;
        } else {
            LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
            // car le id est dans la super clasee
            ligneCommandeClient.setId(ligneCommandeClientDto.getLigne());
            ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticleDto()));
            ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClientDto()) );

            return ligneCommandeClient;
        }
    }
}
