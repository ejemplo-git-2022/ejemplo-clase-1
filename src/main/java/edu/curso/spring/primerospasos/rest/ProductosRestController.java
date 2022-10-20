package edu.curso.spring.primerospasos.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.spring.primerospasos.bo.Producto;
import edu.curso.spring.primerospasos.dto.ProductoDTO;
import edu.curso.spring.primerospasos.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductosRestController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/{id}") //ejemplo ruta /api/productos/23213
	public ProductoDTO buscarProductoPorId(@PathVariable(name = "id") Long id) {
		Producto producto = productoService.buscarProductoPorId(id);
		return new ProductoDTO(producto);
	}
	
	@GetMapping
	public List<ProductoDTO> buscarProductos() {
		List<Producto> productos = productoService.recuperarProductos();
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
		for(Producto p : productos) {
			productosDTO.add(new ProductoDTO(p));
		}
		return productosDTO;
	}
	
	
}
