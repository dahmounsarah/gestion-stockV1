package dz.elit.model;//package model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="commande_client")

public class CommandeClient extends AbstractEntity {

    @Column(name="code")
    private String code;

    @Column(name="date_commande")
    private Date dateCommande;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;


    @OneToMany(mappedBy = "commandeClient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LigneCommandeClient> ligneCommandeClients;

    @ManyToOne
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;



}
