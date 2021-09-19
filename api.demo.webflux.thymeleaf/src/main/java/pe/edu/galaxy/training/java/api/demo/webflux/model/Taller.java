package pe.edu.galaxy.training.java.api.demo.webflux.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor*/

public class Taller implements Serializable{

	private static final long serialVersionUID = 563505313997577174L;
	private Integer id;
	private String nombre;
	private Double duracion;
	
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
	}

	@Override
	public String toString() {
		return "Taller [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}
	
	
	
}
