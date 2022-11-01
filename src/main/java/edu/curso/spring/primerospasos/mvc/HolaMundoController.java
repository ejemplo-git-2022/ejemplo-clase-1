package edu.curso.spring.primerospasos.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/holamundo")
public class HolaMundoController {

	
	@GetMapping("/saludar")
	public String saludar(Model model) {
		model.addAttribute("textoSaludo", "Ejemplo desde en controller..");
		return "holamundo";
	}
}
