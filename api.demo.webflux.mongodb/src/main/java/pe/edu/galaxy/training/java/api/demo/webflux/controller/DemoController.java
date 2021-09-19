package pe.edu.galaxy.training.java.api.demo.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/demo")
public class DemoController {

	//Mono<>
	@GetMapping
	public String demo() {
		return "Spring WebFlux";
	}
	
}
