package pe.edu.galaxy.training.java.api.demo.webflux.model;

/*Usar lombok para usar codigo limpio
 * 
 * @Data
@Builder
@AllArgsConstructor
@NoArgsConstructor*/

public class Taller {

	private Integer id;

	private String nombre;

	public Taller(Integer id, String nombre, Double duracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public Taller() {
		super();
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

	private Double duracion;

}
