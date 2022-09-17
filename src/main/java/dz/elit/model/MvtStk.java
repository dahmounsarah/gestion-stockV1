package dz.elit.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mvt_stk")
public class MvtStk extends AbstractEntity{

    @Column(name = "type_stk")
    private String typeSTK;


    @ManyToOne
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;
}
