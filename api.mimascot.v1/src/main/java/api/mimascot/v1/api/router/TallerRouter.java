package api.mimascot.v1.api.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import api.mimascot.v1.api.handler.TallerHandler;

@Configuration
public class TallerRouter {

	@Bean
	public RouterFunction<ServerResponse> route(TallerHandler tallerHandler) {
		return RouterFunctions
				.route(GET("/v1/talleres").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::findAll)
				.andRoute(GET("/v1/talleres/by-nombre").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::findByLikeNombre)
				.andRoute(GET("/v1/talleres/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::findById)
				.andRoute(GET("/v1/talleres/taller-id/{tallerId}")
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), tallerHandler::findByTallerId)
				.andRoute(POST("/v1/talleres").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::add)
				.andRoute(PUT("/v1/talleres/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::update)
				.andRoute(DELETE("/v1/talleres/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
						tallerHandler::delete);
	}
}
