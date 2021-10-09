package pe.edu.galaxy.training.java.api.reactive.webflux.document;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tema {

	@Field(name = "codigo")
	private Long codigo;

	@Field(name = "nombre")
	private String nombre;
	
	@Field(name = "descripcion")
	private String descripcion;
}
