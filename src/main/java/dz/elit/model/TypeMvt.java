package dz.elit.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "typeMvt")
public class TypeMvt extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;
}
