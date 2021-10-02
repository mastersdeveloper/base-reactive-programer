package api.mimascot.v1.repostitory;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import api.mimascot.v1.document.Taller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TallerRespository extends ReactiveMongoRepository<Taller, String>{
	
	Flux<Taller> findByEstado(String estado);
	
	Flux<Taller> findByTallerNombreLike(String tallerNombre);
	
	Mono<Taller> findByTallerId(Long tallerId);

}
