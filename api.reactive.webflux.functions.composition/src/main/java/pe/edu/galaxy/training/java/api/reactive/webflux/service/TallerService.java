package pe.edu.galaxy.training.java.api.reactive.webflux.service;

import pe.edu.galaxy.training.java.api.reactive.webflux.document.Taller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TallerService {
	
	Flux<Taller> findAll();

	Flux<Taller> findByTallerNombreLike(String tallerNombre);
	
	Mono<Taller> findById(String id);

	Mono<Taller> findByTallerId(Long tallerId);
	
	Mono<Taller> save(Taller taller);
}
