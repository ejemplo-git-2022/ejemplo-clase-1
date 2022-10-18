package edu.curso.spring.primerospasos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.curso.spring.primerospasos.bo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
