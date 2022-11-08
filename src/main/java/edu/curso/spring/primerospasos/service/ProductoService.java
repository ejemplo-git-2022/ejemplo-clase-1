package edu.curso.spring.primerospasos.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import edu.curso.spring.primerospasos.bo.CategoriaProducto;
import edu.curso.spring.primerospasos.bo.Producto;

public interface ProductoService {

	Long altaDeNuevoProducto(Producto producto);
	void actualizarProducto(Producto producto) throws ProductoException;
	Producto buscarProductoPorId(Long id);
	List<Producto> recuperarProductos();
	void borrarProducto(Long id);
	List<Producto> recuperarProductosPorNombre(String nombre);
	List<CategoriaProducto> recuperarListadoDeCategorias();
	CategoriaProducto buscarCategoriaProductoPorId(Long id);
	
}

