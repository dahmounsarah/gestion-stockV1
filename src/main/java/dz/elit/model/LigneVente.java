package dz.elit.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ligne_vente")
public class LigneVente extends AbstractEntity {



    @ManyToOne
    @JoinColumn(name = "id_articles")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "id_vente")
    private Vente ventes;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @ManyToOne
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;

}
