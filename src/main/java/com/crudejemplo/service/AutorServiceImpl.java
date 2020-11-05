package com.crudejemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudejemplo.clases.Autor;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository repo;
	
	@Override
	public Autor crearAutor(Autor autor) {
		Autor a=repo.save(autor);
		return a;
	}

	@Override
	public Autor getAutor(int autorId) {
		Autor a=repo.getOne(autorId);
		return a;
	}

	@Override
	public int actualizarAutor(Autor autor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void borrarAutor(int autorId) {
		// TODO Auto-generated method stub
		
	}

}
