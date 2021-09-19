package pe.edu.galaxy.training.java.api.demo.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.galaxy.training.java.api.demo.webflux.model.Taller;
import pe.edu.galaxy.training.java.api.demo.webflux.service.TallerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/talleres")
public class TallerController {

	/**
	 * La programacion reactiva trabaja con el Mono y el Flux
	 * 
	 * Mono: Es una cadena de objeto
	 * 
	 * Flux: Es una cadena de objetos
	 * 
	 */

	@Autowired
	TallerService tallerService;

	@GetMapping()
	public Flux<Taller> getAll() {
		return tallerService.getAll();
	}

	@GetMapping("/{id}")
	public Mono<Taller> findById(@PathVariable Integer id) {
		return tallerService.findById(id);
	}
}
