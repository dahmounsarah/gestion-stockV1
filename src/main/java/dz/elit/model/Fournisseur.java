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
@Table(name = "fournisseur")
public class Fournisseur extends AbstractEntity{

    @Column(name="nom")
    private String nom;

    @Column(name="prenon")
    private String prenom;

    @Column(name="raison_socail")
    private String raisonSocail;

    @Embedded // champ compose
    private Address address;

    @Column(name="photo")
    private String photo;

    @Column(name="mail")
    private String mail;

    @Column(name="num_tel")
    private String numTel;

    @OneToMany(mappedBy = "fournieeur")
    private List<CommandeFounisseur> commandeFounisseurs;

}
