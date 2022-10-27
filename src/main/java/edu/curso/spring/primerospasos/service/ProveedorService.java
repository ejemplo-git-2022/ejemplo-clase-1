package edu.curso.spring.primerospasos.service;

import java.util.List;

import edu.curso.spring.primerospasos.bo.Proveedor;

public interface ProveedorService {

	void altaDeNuevoProveedor(Proveedor proveedor);

	List<Proveedor> buscarProveedores();

}