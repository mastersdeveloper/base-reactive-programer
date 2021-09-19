package pe.edu.galaxy.training.java.api.demo.webflux.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor*/

@Document(value = "Taller")
public class Taller {
	
	//@Field(value = "_id")
//	private Object _id;
	
	@Field(value = "idTaller")
	private Integer idTaller;
	
	@Field
	private String nombre;
	
	@Field
	private Double duracion;
	
	
	public Taller() {
		super();
	}
	
	public Taller(Integer idTaller, String nombre, Double duracion) {
		super();
		this.idTaller = idTaller;
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public Integer getIdTaller() {
		return idTaller;
	}
	public void setIdTaller(Integer idTaller) {
		this.idTaller = idTaller;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getDuracion() {
		return duracion;
	}
	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}
	
}
