package edu.curso.spring.primerospasos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.spring.primerospasos.service.ProductoService;

@RestController
public class ProductosRestController {

	@Autowired
	private ProductoService productoService;
	
}
