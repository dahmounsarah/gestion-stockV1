package dz.elit.dto;

import dz.elit.model.Article;
import dz.elit.model.LigneVente;
import dz.elit.model.Vente;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Builder
public class VenteDto {

    private Integer id;

    private String code;

    private Date dateVente;

    private String commantaire;

    private List<LigneVenteDto> ligneVenteDtos;
    public static VenteDto fromEntity(Vente vente) {
        if (vente == null)
            return null;
        else
            return VenteDto.builder().id(vente.getId()).
                    code(vente.getCode()).
                    dateVente(vente.getDateVente()).
                    commantaire(vente.getCommantaire()).build();
    }

    public static Vente toEntity(VenteDto venteDto) {
        if (venteDto == null) {
            return null;
        } else {
            Vente vente = new Vente();
            // car le id est dans la super clasee
            vente.setId(venteDto.getId());
            vente.setCode(venteDto.getCode());
            vente.setDateVente(venteDto.getDateVente());
            vente.setCommantaire(venteDto.getCommantaire());

            return vente;
        }
    }


}
