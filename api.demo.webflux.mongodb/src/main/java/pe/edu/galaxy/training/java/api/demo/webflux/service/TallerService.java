package pe.edu.galaxy.training.java.api.demo.webflux.service;

import pe.edu.galaxy.training.java.api.demo.webflux.model.Taller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TallerService {

	// List<Taller> getAll(); // Clasica - JCF

	Flux<Taller> getAll(); // Reactivo

	// Taller finById(Integer id); // Clasica -
	// Optional<Taller> finById(Integer id); // Clasica - Otimizado

	Mono<Taller> findById(String id); // Reactivo

	Mono<Taller> findByIdTaller(Integer idTaller);

	Mono<Taller> save(Taller taller);

	Mono<Taller> update(Integer idTaller, Taller taller);

	Mono delete(Integer idTaller);
}
