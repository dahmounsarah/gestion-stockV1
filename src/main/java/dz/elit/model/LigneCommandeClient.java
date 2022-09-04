package dz.elit.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ligne_commande_client")
public class LigneCommandeClient extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name="id_article_client")
    private Article article;

    @ManyToOne
    @JoinColumn(name="id_commande_client")
    private CommandeClient commandeClient;
}
