package edu.curso.spring.primerospasos.dto;

import edu.curso.spring.primerospasos.bo.Producto;

public class ProductoDTO {
	
	private Long id;
	private String nombre;
	private Double precio;
	
	public ProductoDTO() {
		
	}

	public ProductoDTO(Producto producto) {
		this.id = producto.getId();
		this.nombre = producto.getNombre();
		this.precio = producto.getPrecio();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
