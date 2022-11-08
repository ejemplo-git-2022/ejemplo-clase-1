package edu.curso.spring.primerospasos.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import javax.validation.Valid;

import edu.curso.spring.primerospasos.bo.Producto;
import edu.curso.spring.primerospasos.mvc.form.ProductoForm;
import edu.curso.spring.primerospasos.service.ProductoException;
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
	
	@GetMapping("/{id}/editar")
	public String editar(Model model, @PathVariable("id") Long id) {
		Producto producto = productoService.buscarProductoPorId(id);
		ProductoForm productoForm = new ProductoForm();
		productoForm.setId(id);
		productoForm.setNombre(producto.getNombre());
		productoForm.setPrecio(producto.getPrecio());
		
		model.addAttribute("productoForm", productoForm);
		return "/productos/form";
	}
	
	@GetMapping("/{id}/borrar")
	public String borrar(Model model, @PathVariable("id") Long id) {
		productoService.borrarProducto(id);
		return "redirect:/productos";
	}
	
	@PostMapping("/guardar")
	public String guardarProducto(@Valid @ModelAttribute(name = "productoForm") ProductoForm productoForm, BindingResult bindingResult, Model model) throws ProductoException {
		
		if(bindingResult.hasErrors()) {	
			model.addAttribute("productoForm", productoForm);
			return "/productos/form";
		}
		
		Producto producto = null;
		Long idActual = productoForm.getId();
		Boolean esNuevo = idActual == null || idActual == 0;
		
		if(esNuevo)
			producto = new Producto();
		else 
			producto = productoService.buscarProductoPorId(idActual);
		
		
		producto.setNombre(productoForm.getNombre());
		producto.setPrecio(productoForm.getPrecio());
		
		if(esNuevo)
			productoService.altaDeNuevoProducto(producto);
		else
			productoService.actualizarProducto(producto);

		
		return "redirect:/productos";
	}
	
	
}
