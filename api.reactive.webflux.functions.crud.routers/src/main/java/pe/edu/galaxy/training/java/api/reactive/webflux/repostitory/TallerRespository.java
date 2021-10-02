package pe.edu.galaxy.training.java.api.reactive.webflux.repostitory;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.api.reactive.webflux.document.Taller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TallerRespository extends ReactiveMongoRepository<Taller, String>{
	
	Flux<Taller> findByEstado(String estado);
	
	Flux<Taller> findByTallerNombreLike(String tallerNombre);
	
	Mono<Taller> findByTallerId(Long tallerId);

}
