package pe.edu.galaxy.training.java.api.reactive.webflux.document;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The EmployeeRepository is a simple interface which extend JpaRepository to provide all default methods to your
 * entity/document repository.
 *
 * @author Aristedes Novoa
 * @version 1.0
 * @since 25 Sep, 2021
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "taller")
public class Taller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Builder.Default
    private String id = UUID.randomUUID().toString();
	
	@Field(name = "taller-id")
	private Long tallerId;

	@Field(name = "taller-nombre")
	private String tallerNombre;

	@Field(name = "instructor-id")
	private String instructorId;

	@Field(name = "instructor-nombre")
	private String instructorNombre;

	@Field(name = "estado")
	private String estado;

}
