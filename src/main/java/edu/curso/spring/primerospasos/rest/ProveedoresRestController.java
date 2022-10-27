package edu.curso.spring.primerospasos.rest;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.spring.primerospasos.bo.Producto;
import edu.curso.spring.primerospasos.bo.Proveedor;
import edu.curso.spring.primerospasos.dto.ProductoDTO;
import edu.curso.spring.primerospasos.dto.ProveedorDTO;
import edu.curso.spring.primerospasos.service.ProductoService;
import edu.curso.spring.primerospasos.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresRestController {

	@Autowired
	private ProveedorService proveedorService;
	
	
	@GetMapping
	public List<ProveedorDTO> buscarProductos() {
		List<Proveedor> proveedores = proveedorService.buscarProveedores();
		List<ProveedorDTO> proveedoresDTO = new ArrayList<ProveedorDTO>();
		for(Proveedor p : proveedores) {
			proveedoresDTO.add(new ProveedorDTO(p));
		}
		return proveedoresDTO;
	}
	
	@PostMapping
	public ProveedorDTO altaDeNuevoProducto(@RequestBody ProveedorDTO proveedorDTO) {
		Proveedor proveedor = new Proveedor();
		proveedor.setNombre(proveedorDTO.getNombre());
		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedorService.altaDeNuevoProveedor(proveedor);
		return proveedorDTO;
	}
	
	
}
