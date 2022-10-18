package edu.curso.spring.primerospasos.bo;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class CategoriaProducto {

	@Id
	@GeneratedValue
	private Long id;

	public CategoriaProducto() {
	}

	public CategoriaProducto(String nombre) {
		super();
		this.nombre = nombre;
	}

	private String nombre;

	@Override
	public String toString() {
		return "CategoriaProducto [id=" + id + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaProducto other = (CategoriaProducto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
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
}
