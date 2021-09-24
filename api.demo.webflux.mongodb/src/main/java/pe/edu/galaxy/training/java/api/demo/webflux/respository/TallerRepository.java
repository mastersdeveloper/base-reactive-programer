package pe.edu.galaxy.training.java.api.demo.webflux.respository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.api.demo.webflux.model.Taller;
import reactor.core.publisher.Mono;

@Repository
public interface TallerRepository extends ReactiveMongoRepository<Taller, String> {

	Mono<Taller> findByIdTaller(Integer idTaller);

	Mono<Taller> save(Taller taller);

	//Mono<Taller> update(Taller taller);

	//Mono<Void> delete(Integer idTaller);
}
