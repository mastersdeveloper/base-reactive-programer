package pe.edu.galaxy.training.java.api.reactive.webflux.api.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import pe.edu.galaxy.training.java.api.reactive.webflux.document.Taller;
import pe.edu.galaxy.training.java.api.reactive.webflux.service.TallerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TallerHandler {

	@Autowired
	private TallerService tallerService;

	public Mono<ServerResponse> findAll(ServerRequest request) {

		Flux<Taller> talleres = tallerService.findAll();
		System.out.println("findAll...");
		System.out.println(talleres);
		return ok().contentType(MediaType.APPLICATION_JSON).body(talleres, Taller.class);
	}

	public Mono<ServerResponse> findByLikeNombre(ServerRequest request) {
		System.out.println("findByLikeNombre...");
		Flux<Taller> talleres = tallerService.findByTallerNombreLike(request.queryParam("tallerNombre").get());
		System.out.println(talleres);
		return ok().body(talleres, Taller.class);

	}

	public Mono<ServerResponse> findById(ServerRequest request) {
		return ok().body(tallerService.findById(request.pathVariable("id")), Taller.class);
	}

	public Mono<ServerResponse> findByTallerId(ServerRequest request) {
		return ok().body(tallerService.findByTallerId(Long.valueOf(request.pathVariable("tallerId"))), Taller.class);
	}

	public Mono<ServerResponse> add(ServerRequest request) {
		Mono<Taller> taller = request.bodyToMono(Taller.class);
		return ok().body(fromPublisher(taller.flatMap(tallerService::save), Taller.class));
	}

	public Mono<ServerResponse> update(ServerRequest request) {

		String id = request.pathVariable("id");
		Mono<Taller> tallerMono = request.bodyToMono(Taller.class);

		return tallerService.findById(id).flatMap(taller1 -> tallerMono.flatMap(taller2 -> {

			taller1.setTallerId(taller2.getTallerId());
			taller1.setTallerNombre(taller2.getTallerNombre());

			taller1.setInstructorId(taller2.getInstructorId());
			taller1.setInstructorNombre(taller2.getInstructorNombre());

			taller1.setEstado(taller2.getEstado());

			Mono<Taller> updatedTaller = tallerService.save(taller1);

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

}
