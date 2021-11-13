package pe.edu.galaxy.training.java.api.demo.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.api.demo.webflux.model.Taller;
import pe.edu.galaxy.training.java.api.demo.webflux.respository.TallerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TallerServiceImpl implements TallerService {

	@Autowired
	private TallerRepository tallerRepository;

	@Override
	public Flux<Taller> getAll() {
		//return tallerRepository.findAll();
		return tallerRepository.findByEstado("1");
	}


	@Override
	public Flux<Taller> findByNombreLike(String nombre) {
		return tallerRepository.findByNombreLike(nombre);
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
		return tallerRepository.findById(taller.getId()).doOnSuccess(oTaller -> {
			if (oTaller != null) {
				oTaller.setId(taller.getId());
				oTaller.setNombre(taller.getNombre());
				tallerRepository.save(oTaller).subscribe();
			}
		});
	}

	@Override
	public Mono<Taller> delete(Taller taller) {
		// Borrado logico
		return tallerRepository.findById(taller.getId()).doOnSuccess(oTaller -> {
			if (oTaller != null) {
				log.info(".....");
				log.info(oTaller.toString());
				oTaller.setEstado("0");
				tallerRepository.save(oTaller).subscribe();
			}
		});
		
	}

	/*
	@Override
	public Mono<Void> delete(Taller taller) {
		// Borrado logico
		// return tallerRepository.delete(taller);

		tallerRepository.findById(taller.getId()).doOnSuccess(oTaller -> {
			log.info(".....");
			log.info(oTaller.toString());
			tallerRepository.delete(oTaller);
		});
		
		return Mono.empty();
	}*/

}
