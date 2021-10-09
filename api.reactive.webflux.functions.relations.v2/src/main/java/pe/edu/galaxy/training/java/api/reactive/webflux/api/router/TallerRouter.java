package pe.edu.galaxy.training.java.api.reactive.webflux.api.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static pe.edu.galaxy.training.java.api.reactive.webflux.api.constants.Constants.*;

import pe.edu.galaxy.training.java.api.reactive.webflux.api.handler.TallerHandler;

@Configuration
public class TallerRouter {

	@Bean
	public RouterFunction<ServerResponse> route(TallerHandler tallerHandler) {
		return RouterFunctions
				.route(GET(API_ROUTE_TALLERES).and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::findAll)
				.andRoute(GET(API_ROUTE_TALLERES+"/by-nombre").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::findByLikeNombre)
				.andRoute(GET(API_ROUTE_TALLERES+"/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::findById)
				.andRoute(GET(API_ROUTE_TALLERES+"/codigo/{codigo}")
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), tallerHandler::findByCodigo)
				.andRoute(POST(API_ROUTE_TALLERES).and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::add)
				.andRoute(PUT(API_ROUTE_TALLERES+"/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::update)
				.andRoute(DELETE(API_ROUTE_TALLERES+"/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::delete);
	}
}
