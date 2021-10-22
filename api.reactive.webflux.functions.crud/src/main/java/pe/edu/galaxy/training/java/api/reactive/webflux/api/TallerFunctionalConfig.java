package pe.edu.galaxy.training.java.api.reactive.webflux.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.api.reactive.webflux.document.Taller;
import pe.edu.galaxy.training.java.api.reactive.webflux.service.TallerService;
import pe.edu.galaxy.training.java.api.reactive.webflux.service.TallerServiceImpl;
import reactor.core.publisher.Mono;

//

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Slf4j
@Configuration
public class TallerFunctionalConfig {

	@Bean
	TallerService tallerService() {
		return new TallerServiceImpl();
	}

	@Bean
	RouterFunction<ServerResponse> findAllRoute() {
		return route(GET("/talleres"), req -> {
			return ok().body(tallerService().findAll(), Taller.class);
		});
	}

	@Bean
	RouterFunction<ServerResponse> findByLikeNombreRoute() {
		return route(GET("/talleres/by-nombre"), req -> {
			return ok().body(tallerService().findByTallerNombreLike(req.queryParam("tallerNombre").get()),
					Taller.class);
		});
	}

	@Bean
	RouterFunction<ServerResponse> findByIdRoute() {
		return route(GET("/talleres/{id}"), req -> {
			return ok().body(tallerService().findById(req.pathVariable("id")), Taller.class);
		});
	}

	@Bean
	RouterFunction<ServerResponse> findByTallerIdRoute() {
		return route(GET("/talleres/taller-id/{tallerId}"), req -> {
			return ok().body(tallerService().findByTallerId(Long.valueOf(req.pathVariable("tallerId"))), Taller.class);
		});
	}
	
	@Bean
	RouterFunction<ServerResponse> addRoute() {
		return route(POST("/talleres"), req -> {
			Mono<Taller> taller = req.bodyToMono(Taller.class);
			return ok().body(fromPublisher(taller.flatMap(tallerService()::save), Taller.class));
		});
	}
	
	@Bean
	RouterFunction<ServerResponse> updateRoute() {
		return route(PUT("/talleres/{id}"), req -> {
			
			String id= req.pathVariable("id");
			
			Mono<Taller> tallerMono = req.bodyToMono(Taller.class);
			
			 return tallerService().findById(id)
					 
		                .flatMap(taller1 -> tallerMono.flatMap(taller2 -> {
		                	
		                	taller1.setTallerId(taller2.getTallerId());
		                	taller1.setTallerNombre(taller2.getTallerNombre());
		                	
		                	taller1.setInstructorId(taller2.getInstructorId());
		                	taller1.setInstructorNombre(taller2.getInstructorNombre());
		                	
		                	taller1.setEstado(taller2.getEstado());
		                	
		                    Mono<Taller> updatedTaller = tallerService().save(taller1);
		                    
		                    return ok().body(updatedTaller, Taller.class);
		                }));			
		});
	}

	@Bean
	RouterFunction<ServerResponse> deleteRoute() {
		return route(DELETE("/talleres/{id}"), req -> {
			
			String id= req.pathVariable("id");			
			 return tallerService().findById(id)
		                .flatMap(taller -> {
		                	taller.setEstado("0");
		                	Mono<Taller> updatedTaller = tallerService().save(taller);
		                    return ok().body(updatedTaller, Taller.class);
		                });			
		});
	}
	
}
