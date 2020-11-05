package com.crudejemplo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudejemplo.clases.Autor;
import com.crudejemplo.exception.Excepcion;

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
		Optional<Autor> a= repo.findById(autorId);
		
		if(!a.isPresent()) {
			throw new Excepcion("Recurso no encontrado");
		}
		return a.get();
	}

	@Override
	public Autor actualizarAutor(Autor autor) {
		try {
			Autor a=repo.findById(autor.getId()).get();
			
			if(null==a) {
				throw new Excepcion("Recurso no encontrado");
			}
			return repo.save(autor);
			
			}catch(Exception e){
				throw new Excepcion("Error al actualizar");
			}
		
	}

	@Override
	public void borrarAutor(int autorId) {
		try {
			Autor a=repo.findById(autorId).get();
			
			if(null==a) {
				throw new Excepcion("Recurso no encontrado");
			}
			repo.delete(a);
			
			}catch(Exception e){
				throw new Excepcion("Error al borrar");
			}
		
	}

}
