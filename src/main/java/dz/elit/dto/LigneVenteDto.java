package dz.elit.dto;
import dz.elit.model.Article;
import dz.elit.model.Client;
import dz.elit.model.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;

    private VenteDto venteDto;

    private ArticleDto articleDto;

    private BigDecimal quantite;

    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        } else {
            return LigneVenteDto.builder().
                    id(ligneVente.getId()).
                    venteDto(VenteDto.fromEntity(ligneVente.getVentes())).
                    articleDto(ArticleDto.fromEntity(ligneVente.getArticle())).
                    quantite(ligneVente.getQuantite())
                    .build();

        }

    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if (ligneVenteDto == null) {
            return null;
        } else {
            LigneVente ligneVente = new LigneVente();
            // car le id est dans la super clasee
            ligneVente.setVentes(VenteDto.toEntity(ligneVenteDto.getVenteDto()));
            ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticleDto()));
            ligneVente.setQuantite(ligneVenteDto.getQuantite());

            return ligneVente;
        }

    }
}
