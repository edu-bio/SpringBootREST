package com.crudejemplo.service;

import java.util.List;

import com.crudejemplo.clases.Autor;

public interface AutorService {

	public Autor crearAutor(Autor autor);
	
	public Autor getAutor(int autorId);
	
	public Autor actualizarAutor(Autor autor);
	
	public void borrarAutor(int autorId);
	
	public List<Autor>  listado();
	
}
