package pe.edu.galaxy.training.java.api.reactive.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.api.reactive.webflux.document.Taller;
import pe.edu.galaxy.training.java.api.reactive.webflux.repostitory.TallerRespository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TallerServiceImpl implements TallerService {

	@Autowired
	private TallerRespository tallerRespository;

	@Override
	public Flux<Taller> findAll() {
		return tallerRespository.findByEstado("1");
	}

	@Override
	public Flux<Taller> findByTallerNombreLike(String tallerNombre) {
		return tallerRespository.findByTallerNombreLike(tallerNombre);
	}

	@Override
	public Mono<Taller> findByTallerId(Long tallerId) {
		return tallerRespository.findByTallerId(tallerId);
	}

	@Override
	public Mono<Taller> findById(String id) {
		return tallerRespository.findById(id);
	}

	@Override
	public Mono<Taller> save(Taller taller) {
		return tallerRespository.save(taller);
	}

}
