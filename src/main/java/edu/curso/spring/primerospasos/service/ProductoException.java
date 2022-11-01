package edu.curso.spring.primerospasos.service;

public class ProductoException extends Exception {

	public ProductoException() {
		super();
	}

	public ProductoException(String msg) {
		super(msg);
	}
	
	public ProductoException(String msg, Throwable errorOriginal) {
		super(msg, errorOriginal);		
	}
	
}
