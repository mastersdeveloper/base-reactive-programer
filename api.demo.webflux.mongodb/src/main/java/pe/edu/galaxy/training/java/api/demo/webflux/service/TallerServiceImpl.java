package pe.edu.galaxy.training.java.api.demo.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.api.demo.webflux.model.Taller;
import pe.edu.galaxy.training.java.api.demo.webflux.respository.TallerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TallerServiceImpl implements TallerService {

	@Autowired
	private TallerRepository tallerRepository;

	@Override
	public Flux<Taller> getAll() {
		return tallerRepository.findAll();
	}

	@Override
	public Mono<Taller> findById(String id) {
		return tallerRepository.findById(id);
	}

	@Override
	public Mono<Taller> findByIdTaller(Integer idTaller) {
		return tallerRepository.findByIdTaller(idTaller);
	}

	@Override
	public Mono<Taller> save(Taller taller) {
		return tallerRepository.save(taller);
	}

	@Override
	public Mono<Taller> update(Taller taller) {
		// Idempotente
		return null;
	}

	@Override
	public Mono<Void> delete(Taller taller) {
		// Borrado logico
		return null;//tallerRepository.delete(taller);
	}

}
