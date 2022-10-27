package edu.curso.spring.primerospasos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.curso.spring.primerospasos.bo.CategoriaProducto;

@Repository
public class CategoriaProductoRepositoryJPA implements CategoriaProductoRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Long altaCategoriaProducto(CategoriaProducto categoriaProducto) {
		entityManager.persist(categoriaProducto);
		return categoriaProducto.getId();
	}
	
	@Override
	public CategoriaProducto buscarCategoriaProductoPorId(Long id) {
		return entityManager.find(CategoriaProducto.class, id);
	}
	
	@Override
	public List<CategoriaProducto> buscarCategoriasProducto() {
		TypedQuery<CategoriaProducto> query = entityManager.createQuery("select c from CategoriaProducto c", CategoriaProducto.class);
		return query.getResultList();
	}
	
	
}
