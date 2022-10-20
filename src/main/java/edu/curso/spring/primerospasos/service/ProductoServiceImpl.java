package edu.curso.spring.primerospasos.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.spring.primerospasos.PrimerosPasosApplication;
import edu.curso.spring.primerospasos.bo.Producto;
import edu.curso.spring.primerospasos.repository.ProductoRepository;

// Patron Fachada
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductoServiceImpl implements ProductoService {
	
	private static Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Long altaDeNuevoProducto(Producto producto) {
		log.info("Alta de nuevo producto " + producto);
		productoRepository.save(producto);
		return producto.getId();
	}

	@Override
	public void actualizarProducto(Producto producto) {
		log.info("Actualizar producto " + producto);
		productoRepository.save(producto);
	}

	@Override
	public Producto buscarProductoPorId(Long id) {
		log.info("Buscando producto con el id " + id);
		Optional<Producto> productoOptional = productoRepository.findById(id);
		if(productoOptional.isPresent())
			return productoOptional.get();
		else
			return null;
	}

	@Override
	public List<Producto> recuperarProductos() {
		return productoRepository.findAll();
	}

	@Override
	public void borrarProducto(Long id) {
		log.info("Borrar producto " + id);
		productoRepository.deleteById(id);
	}
	
}
