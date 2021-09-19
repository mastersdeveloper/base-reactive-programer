package pe.edu.galaxy.training.java.api.demo.webflux.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.api.demo.webflux.model.Taller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TallerServiceImpl implements TallerService{
	
	private static List<Taller> talleres = new ArrayList<>();

    static {
    	talleres.add(new Taller(1, "Java 11", 26.0));
    	talleres.add(new Taller(2,"Java 16", 32.5));
    	talleres.add(new Taller(3, "Angualar 12", 15.0));
    	talleres.add(new Taller(4, "Spring Web Flux",40.0));
    	talleres.add(new Taller(5, "Java 17", 15.25));
    	talleres.add(new Taller(6, "Angualar 13", 15.0));
    	talleres.add(new Taller(7, "React JS", 15.0));
    	talleres.add(new Taller(8, "Vue.js", 15.0));
    }


	@Override
	public Flux<Taller> getAll() {
		
		return Flux.fromIterable(talleres).delayElements(Duration.ofSeconds(2));
	}

	@Override
	public Mono<Taller> findById(Integer id) {
		
		return Mono.just(talleres.get(id));
	}

}
