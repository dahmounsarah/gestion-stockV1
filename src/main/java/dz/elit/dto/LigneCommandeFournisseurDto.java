package dz.elit.dto;

import dz.elit.model.LigneCommandeClient;
import dz.elit.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;

    private ArticleDto articleDto;

    private CommandeFournisseurDto commandeFounisseurDto;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null)
            return null;
        else
            return LigneCommandeFournisseurDto.builder().id(ligneCommandeFournisseur.getId()).
                    articleDto(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle())).
                    commandeFounisseurDto(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFounisseurs())).
                    build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        if (ligneCommandeFournisseurDto == null) {
            return null;
        } else {
            LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
            // car le id est dans la super clasee
            ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
            ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticleDto()));
            ligneCommandeFournisseur.setCommandeFounisseurs(CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandeFounisseurDto()) );

            return ligneCommandeFournisseur;
        }
    }
}
