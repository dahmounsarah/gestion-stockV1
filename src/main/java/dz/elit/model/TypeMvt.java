package dz.elit.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}
