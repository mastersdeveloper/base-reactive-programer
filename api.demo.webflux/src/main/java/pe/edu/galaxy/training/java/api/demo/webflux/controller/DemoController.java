package pe.edu.galaxy.training.java.api.demo.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	/**
	 * La programacion reactiva trabaja con el Mono y el Flux
	 * 
	 * Mono: Es una cadena de objeto
	 * 
	 * Flux: Es una cadena de objetos
	 * 
	 * */

	@GetMapping
	public String demo() {
		return "Spring WebFlux";
	}
}
