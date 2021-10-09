package pe.edu.galaxy.training.java.api.reactive.webflux.api.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fasterxml.jackson.databind.json.JsonMapper;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import pe.edu.galaxy.training.java.api.reactive.webflux.document.Taller;
import pe.edu.galaxy.training.java.api.reactive.webflux.service.TallerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TallerHandler {

	@Autowired
	private TallerService tallerService;
	
	@Autowired
	private JsonMapper jsonMapper;

	public Mono<ServerResponse> findAll(ServerRequest request) {

		Flux<Taller> talleres = tallerService.findAll();
		return ok().contentType(MediaType.APPLICATION_JSON).body(talleres, Taller.class);
	}

	public Mono<ServerResponse> findByLikeNombre(ServerRequest request) {
		Flux<Taller> talleres = tallerService.findByNombreLike(request.queryParam("nombre").get());
		System.out.println(talleres);
		return ok().body(talleres, Taller.class);

	}

	public Mono<ServerResponse> findById(ServerRequest request) {
		return ok().body(tallerService.findById(request.pathVariable("id")), Taller.class);
	}

	public Mono<ServerResponse> findByCodigo(ServerRequest request) {
		return ok().body(tallerService.findByCodigo(Long.valueOf(request.pathVariable("codigo"))), Taller.class);
	}

	public Mono<ServerResponse> add(ServerRequest request) {
		Mono<Taller> taller = request.bodyToMono(Taller.class);
		return ok().body(fromPublisher(taller.flatMap(tallerService::save), Taller.class));
	}

	public Mono<ServerResponse> update(ServerRequest request) {

		String id = request.pathVariable("id");
//		log.info("Handler id "+id);
		Mono<Taller> tallerMono = request.bodyToMono(Taller.class);

		return tallerService.findById(id).flatMap(taller1 -> tallerMono.flatMap(taller2 -> {
			taller2.setId(id);
//			log.info("Handler "+taller1.toString());
			Mono<Taller> updatedTaller = tallerService.save(this.getTaller(taller2));

			return ok().body(updatedTaller, Taller.class);
		}));
	}

	public Mono<ServerResponse> delete(ServerRequest request) {

		String id = request.pathVariable("id");
		return tallerService.findById(id).flatMap(taller -> {
			taller.setEstado("0");
			Mono<Taller> updatedTaller = tallerService.save(taller);
			return ok().body(updatedTaller, Taller.class);
		});
	}


	// Mapper
	
	private Taller getTaller(Taller taller) {
		return jsonMapper.convertValue(taller, Taller.class);
	}
}
