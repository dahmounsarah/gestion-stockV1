package dz.elit.model;

import lombok.*;

import javax.persistence.*;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")

public class  Article extends AbstractEntity{

	@Column(name="code")
	private String code;


	@Column(name="designation")
	private String designation;

	@Column(name="prix_unitaire")
	private String prixUnitaire;

	@Column(name="taux_tva")
	private String tauxTva;

	@Column(name="photo")
	private String photo;
	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "id_entreprise")
	private Entreprise entreprise;



}
