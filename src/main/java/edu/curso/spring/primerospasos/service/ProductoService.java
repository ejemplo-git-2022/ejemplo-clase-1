package edu.curso.spring.primerospasos.service;

import java.util.List;

import edu.curso.spring.primerospasos.bo.Producto;

public interface ProductoService {

	Long altaDeNuevoProducto(Producto producto);
	void actualizarProducto(Producto producto);
	Producto buscarProductoPorId(Long id);
	List<Producto> recuperarProductos();
	void borrarProducto(Long id);
	
}

