package dz.elit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)// ca ne fonctionne pas
public class AbstractEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer  id;
	// pourquoi datecreation et modiifcation null
	@CreatedDate
	//instant pour java 11

	@Column(name="created_date",updatable = false)
	private  Date createdDate;
	
	@LastModifiedDate
	// attribut pas obligatoire pour l'invocation de ID

	@Column(name="last_modified_date")
	private Date lastModifiedDate;
	
	
	
}
