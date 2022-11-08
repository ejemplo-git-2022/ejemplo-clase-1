package edu.curso.spring.primerospasos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.spring.primerospasos.bo.CategoriaProducto;
import edu.curso.spring.primerospasos.service.ProductoService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaProductosRestController {

	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping
	public List<CategoriaProducto> recuperarCategorias() {
		return productoService.recuperarListadoDeCategorias();
	}
	
	@GetMapping("/{id}")
	public CategoriaProducto buscarCategoriaPorId(@PathVariable Long id) {
		CategoriaProducto categoriaProducto = productoService.buscarCategoriaProductoPorId(id);
		return categoriaProducto;
	}
	
}
