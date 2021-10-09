package pe.edu.galaxy.training.java.api.reactive.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.api.reactive.webflux.document.Taller;
import pe.edu.galaxy.training.java.api.reactive.webflux.repostitory.TallerRespository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TallerServiceImpl implements TallerService {

	@Autowired
	private TallerRespository tallerRespository;

	@Override
	public Flux<Taller> findAll() {
		return tallerRespository.findByEstado("1");
	}

	@Override
	public Flux<Taller> findByNombreLike(String nombre) {
		return tallerRespository.findByNombreLike(nombre);
	}

	@Override
	public Mono<Taller> findByCodigo(Long codigo) {
		return tallerRespository.findByCodigo(codigo);
	}

	@Override
	public Mono<Taller> findById(String id) {
		return tallerRespository.findById(id);
	}

	@Override
	public Mono<Taller> save(Taller taller) {
		log.info(taller.toString());
		return tallerRespository.save(taller);
	}

}
