package pe.edu.galaxy.training.java.api.demo.webflux.service;

import pe.edu.galaxy.training.java.api.demo.webflux.model.Taller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TallerService {

	//List<Taller> getAll(); // Clasica - JCF
	
	Flux<Taller> getAll();   // Reactivo
	
	// Taller finById(Integer id);				// Clasica - 
	// Optional<Taller> finById(Integer id); 	// Clasica - Otimizado
	
	
	Flux<Taller> findByNombreLike(String nombre); 
	
	Mono<Taller> findById(String id); // Reactivo
	
	Mono<Taller>  findByIdTaller(Integer idTaller);
	
	
	Mono<Taller>  save(Taller taller);
	
	Mono<Taller>  update(Taller taller);
	
	Mono<Taller>  delete(Taller taller);
	
}
