package edu.curso.spring.primerospasos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.spring.primerospasos.bo.Proveedor;
import edu.curso.spring.primerospasos.repository.ProveedorRepository;

@Service
@Transactional
public class ProveedorServiceImpl implements ProveedorService   {

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public void altaDeNuevoProveedor(Proveedor proveedor) {
		proveedorRepository.altaNuevoProveedor(proveedor);
	}
	
	@Override
	public List<Proveedor> buscarProveedores() {
		return proveedorRepository.buscarProveedores();
	}
	
}
