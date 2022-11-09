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
@Table(name = "category")
public class Category extends AbstractEntity{

	@Column(name="code")
	private String code;

	@Column(name="designation")
	private String designation;
	
	@OneToMany(mappedBy="category")
	private List<Article> articles;

	@ManyToOne
	@JoinColumn(name = "id_entreprise")
	private Entreprise entreprise;


}
