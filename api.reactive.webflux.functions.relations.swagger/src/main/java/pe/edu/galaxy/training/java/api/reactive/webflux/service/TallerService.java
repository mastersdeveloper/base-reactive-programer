package pe.edu.galaxy.training.java.api.reactive.webflux.service;

import pe.edu.galaxy.training.java.api.reactive.webflux.document.Taller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TallerService {
	
	Flux<Taller> findAll();

	Flux<Taller> findByNombreLike(String nombre);
	
	Mono<Taller> findById(String id);

	Mono<Taller> findByCodigo(Long codigo);
	
	Mono<Taller> save(Taller taller);
}
