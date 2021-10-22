package pe.edu.galaxy.training.java.api.demo.webflux.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
	
	@Field(value = "_id")
	private Object _id;
	
	@Field(value = "idTaller")
	private Integer idTaller;
	
	@Field
	private String nombre;
	
	@Field
	private Double duracion;
	
	/*
	public Taller() {
		super();
	}
	
	public Taller(Integer id, String nombre, Double duracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	}*/
	
}
