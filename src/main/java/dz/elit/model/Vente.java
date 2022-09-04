package dz.elit.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ventes")
public class Vente extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "date_vente")
    private Date dateVente;

    @Column(name = "commantaire")
    private String commantaire;

    @OneToMany
    private List<LigneVente> ligneVentes;


}
