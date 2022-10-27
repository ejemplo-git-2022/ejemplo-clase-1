package edu.curso.spring.primerospasos.repository;

import java.util.List;

import edu.curso.spring.primerospasos.bo.CategoriaProducto;

public interface CategoriaProductoRepository {

	Long altaCategoriaProducto(CategoriaProducto categoriaProducto);

	CategoriaProducto buscarCategoriaProductoPorId(Long id);

	List<CategoriaProducto> buscarCategoriasProducto();

}