package api.mimascot.v1.service;

import api.mimascot.v1.document.Taller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TallerService {
	
	Flux<Taller> findAll();

	Flux<Taller> findByTallerNombreLike(String tallerNombre);
	
	Mono<Taller> findById(String id);

	Mono<Taller> findByTallerId(Long tallerId);
	
	Mono<Taller> save(Taller taller);
}
