package pe.edu.galaxy.training.java.api.demo.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.galaxy.training.java.api.demo.webflux.model.Taller;
import pe.edu.galaxy.training.java.api.demo.webflux.service.TallerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/talleres")
public class TallerController {

	@Autowired
	private TallerService tallerService;
	
	@GetMapping
	public Flux<Taller> getAll() {
		return tallerService.getAll();
	}
	
	@GetMapping("/by-nombre")
	public Flux<Taller> findByNombreLike(@RequestParam(name = "nombre",defaultValue = "") String nombre) {
		return tallerService.findByNombreLike(nombre);
	}
	
	@GetMapping("/{id}")
	public Mono<Taller> findById(@PathVariable String id) {
		return tallerService.findById(id);
	}
	
	@GetMapping("/id-taller/{id}")
	public Mono<Taller> findById(@PathVariable Integer id) {
		return tallerService.findByIdTaller(id);
	}
	
	@PostMapping
	public Mono<Taller> add(@RequestBody Taller taller) {
		return tallerService.save(taller);
	}
	
	@PutMapping("/{id}")
	public Mono<Taller> update(@PathVariable String id, @RequestBody Taller taller) {
		taller.setId(id);
		return tallerService.save(taller);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Taller> delete(@PathVariable String id) {
		return tallerService.delete(Taller.builder().id(id).build());
	}
	
}
