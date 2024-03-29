package edu.curso.spring.primerospasos.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.spring.primerospasos.PrimerosPasosApplication;
import edu.curso.spring.primerospasos.bo.CategoriaProducto;
import edu.curso.spring.primerospasos.bo.Producto;
import edu.curso.spring.primerospasos.repository.CategoriaProductoRepository;
import edu.curso.spring.primerospasos.repository.ProductoRepository;
import edu.curso.spring.primerospasos.util.EmailManager;

// Patron Fachada
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductoServiceImpl implements ProductoService {
	
	private static Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaProductoRepository categoriaProductoRepository;
	
	@Autowired
	private EmailManager emailManager;
	
	public ProductoServiceImpl() {
		log.info("Creando una nueva instancia de ProductoServiceImpl......");
	}
	
	@Override
	public Long altaDeNuevoProducto(Producto producto) {
		log.info("Alta de nuevo producto " + producto);
		productoRepository.save(producto);
		emailManager.enviarEmail("pepe@pepe.com", "Dando de alta un nuevo producto con el id: " + producto.getId());
		return producto.getId();
	}
	
	@Override
	public void actualizarProducto(Producto producto) throws ProductoException {
		log.info("Actualizar producto " + producto);
		
		if(producto.getPrecio() <= 1000)
			throw new ProductoException("El producto " + producto.getNombre() + " no puede ser menor o igual a 1000");
		
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

	@Override
	public List<Producto> recuperarProductosPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return productoRepository.buscarProductosPorNombre(nombre);
	}
	
	@Cacheable("categorias")
	public List<CategoriaProducto> recuperarListadoDeCategorias() {
		return categoriaProductoRepository.buscarCategoriasProducto();
	}
	
	@Cacheable("categoriaPorId")
	public CategoriaProducto buscarCategoriaProductoPorId(Long id) {
		return categoriaProductoRepository.buscarCategoriaProductoPorId(id);

	}
	
	@Scheduled(fixedRate = 5000)
	public void ejemploScheduled1() {
		log.info("@Scheduled 5000....... " + Thread.currentThread().getName());
	}

	@Scheduled(cron = "0/10 * * * * ?")
	public void ejemploScheduled2() {
		log.info("@Scheduled cron 0/10 * * * * ? ....... " + Thread.currentThread().getName());
	}

}
