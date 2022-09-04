package dz.elit.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable


public class Address {
	

	@Column(name = "address1")
	private String addressed1;
	
	@Column(name = "address2")
	private String addressed2;

	@Column(name = "ville")
	private String ville;

	@Column(name = "code_postal")
	private String codePostal;

	@Column(name = "pays")
	private String pays;
	
	
	
	

}
