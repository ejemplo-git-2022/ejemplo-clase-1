package edu.curso.spring.primerospasos.repository;

import java.util.*;
import edu.curso.spring.primerospasos.bo.*;

public interface ProveedorRepository {
	
	public void altaNuevoProveedor(Proveedor proveedor);
	public void actualizarProveedor(Proveedor proveedor);
	public void borrarProveedor(Long id);
	public Proveedor buscarProveedorPorId(Long id);
	public List<Proveedor> buscarProveedores();

}
