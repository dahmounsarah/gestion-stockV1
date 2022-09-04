package dz.elit.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commande_founisseur")


public class CommandeFounisseur extends AbstractEntity {

    @Column(name = "code")
    private String code;


    @Column(name = "date_commande_fournisseur")
    private Date dateCommandeFournisseur;


    @ManyToOne
    @JoinColumn(name = "id_fournisseur ")
    private Fournisseur fournieeur;

    @OneToMany(mappedBy = "commandeFounisseurs")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
