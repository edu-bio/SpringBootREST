package com.crudejemplo.service;

import com.crudejemplo.clases.Libro;

public interface LibroService {

public Libro crearLibro(Libro libro);
	
	public Libro getLibro(int libroId);
	
	public Libro actualizarLibro(Libro libro);
	
	public void borrarLibro(int libroId);
}
