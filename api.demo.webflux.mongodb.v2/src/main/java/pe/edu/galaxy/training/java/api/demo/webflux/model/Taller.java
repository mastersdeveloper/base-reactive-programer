package pe.edu.galaxy.training.java.api.demo.webflux.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Document(value = "Taller")
public class Taller {
	
	@Id
	private String id;
	
	@Field(value = "idTaller")
	private Integer idTaller;
	
	@Field
	private String nombre;
	
	@Field
	private Double duracion;
	
	@Field
	private String estado;
	
}
