package edu.curso.spring.primerospasos.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import edu.curso.spring.primerospasos.bo.Producto;
import edu.curso.spring.primerospasos.mvc.form.ProductoForm;
import edu.curso.spring.primerospasos.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public String listar(Model model) {
		List<Producto> productos = productoService.recuperarProductos();
		model.addAttribute("productos", productos);
		return "/productos/index";
	}
	
	@GetMapping("/{id}")
	public String ver(Model model, @PathVariable("id") Long id) {
		Producto producto = productoService.buscarProductoPorId(id);
		model.addAttribute("producto", producto);
		return "/productos/ver";
	}
	
	@GetMapping("/nuevo")
	public String nuevoProducto(Model model) {
		ProductoForm productoForm = new ProductoForm();
		model.addAttribute("productoForm", productoForm);
		return "/productos/form";
	}
	
	@PostMapping("/guardar")
	public String guardarProducto(@ModelAttribute(name = "productoForm") ProductoForm productoForm, Model model) {
		Producto producto = new Producto();
		producto.setNombre(productoForm.getNombre());
		producto.setPrecio(productoForm.getPrecio());
		
		productoService.altaDeNuevoProducto(producto);
		
		return "redirect:/productos/index";
	}
	
	
}
