package pe.edu.galaxy.training.java.api.reactive.webflux.api.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fasterxml.jackson.databind.json.JsonMapper;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import pe.edu.galaxy.training.java.api.reactive.webflux.document.Instructor;
import pe.edu.galaxy.training.java.api.reactive.webflux.document.Taller;
import pe.edu.galaxy.training.java.api.reactive.webflux.service.TallerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TallerHandler {

	@Autowired
	private TallerService tallerService;
	
	@Autowired
	private JsonMapper jsonMapper;

	public Mono<ServerResponse> findAll(ServerRequest request) {

		Flux<Taller> talleres = tallerService.findAll();
		System.out.println("findAll...");
		System.out.println(talleres);
		return ok().contentType(MediaType.APPLICATION_JSON).body(talleres, Taller.class);
	}

	public Mono<ServerResponse> findByLikeNombre(ServerRequest request) {
		System.out.println("findByLikeNombre...");
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
		Mono<Taller> tallerMono = request.bodyToMono(Taller.class);

		return tallerService.findById(id).flatMap(taller1 -> tallerMono.flatMap(taller2 -> {
			
			taller1.setId(id);

			taller1.setId(taller2.getId());
			taller1.setNombre(taller2.getNombre());
			
			Instructor instructor= 	Instructor.builder()
									.codigo(taller2.getInstructor().getCodigo())
									.nombres(taller2.getInstructor().getNombres())
									.apellidos(taller2.getInstructor().getApellidos())
									.correo(taller2.getInstructor().getCorreo())
									.telefono(taller2.getInstructor().getTelefono())
									.build();
			
			taller1.setInstructor(instructor);
			
			
			taller1.setEstado(taller2.getEstado());
		
			
			Mono<Taller> updatedTaller = tallerService.save(taller2);

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
