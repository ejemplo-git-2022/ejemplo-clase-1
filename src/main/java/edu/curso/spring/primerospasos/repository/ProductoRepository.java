package edu.curso.spring.primerospasos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.curso.spring.primerospasos.bo.Producto;

import java.util.*;
// Patron DAO
// Generic DAO
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	
	@Query("SELECT p FROM Producto p ORDER BY p.nombre")
	public List<Producto> buscarProductos();

	@Query("SELECT p FROM Producto p WHERE p.precio >= :precio")
	public List<Producto> buscarProductosPorPrecio(@Param("precio") Double precio);

	@Query("SELECT p FROM Producto p WHERE p.nombre LIKE  %?1%")
	public List<Producto> buscarProductosPorNombre(String nombre);

		
}
