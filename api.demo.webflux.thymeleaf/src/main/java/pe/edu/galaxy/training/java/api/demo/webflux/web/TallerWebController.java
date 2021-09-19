package pe.edu.galaxy.training.java.api.demo.webflux.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import pe.edu.galaxy.training.java.api.demo.webflux.service.TallerService;

@Controller
public class TallerWebController {

	@Autowired
	private TallerService tallerService;

	@RequestMapping("/")
	public String index(final Model model) {

		// Reactivo
		// carga 1 y muestra 1, stream data y data driven mode.
		
		IReactiveDataDriverContextVariable irddcv = new ReactiveDataDriverContextVariable(tallerService.getAll(),1);

		model.addAttribute("talleres", irddcv);

		// clasico
		//model.addAttribute("talleres", tallerService.getAll());

		return "index";

	}

}
