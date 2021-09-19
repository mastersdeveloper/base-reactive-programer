package pe.edu.galaxy.training.java.api.demo.webflux.service;

import pe.edu.galaxy.training.java.api.demo.webflux.model.Taller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TallerService {

	Flux<Taller> getAll();
	
	Mono<Taller> findById(Integer id);
}
