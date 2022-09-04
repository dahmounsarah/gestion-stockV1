package dz.elit.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ligne_commande_fournisseur")
public class LigneCommandeFournisseur extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="id_article_commande_fournisseur")
    private Article article;

    @ManyToOne
    @JoinColumn(name="id_article_commande_founisseurs")
    private CommandeFounisseur commandeFounisseurs;
}
