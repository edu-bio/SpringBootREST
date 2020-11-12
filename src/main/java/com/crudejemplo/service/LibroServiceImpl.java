package com.crudejemplo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudejemplo.clases.Libro;
import com.crudejemplo.exception.Excepcion;

	@Service
	public class LibroServiceImpl implements LibroService {

		@Autowired
		private LibroRepository repo;
		
		@Override
		public Libro crearLibro(Libro libro) {
			Libro a=repo.save(libro);
			return a;
		}

		@Override
		public Libro getLibro(int libroId) {
			Optional<Libro> a= repo.findById(libroId);
			
			if(!a.isPresent()) {
				throw new Excepcion("Recurso no encontrado");
			}
			return a.get();
		}

		@Override
		public Libro actualizarLibro(Libro libro) {
			try {
				Libro a=repo.findById(libro.getId()).get();
				
				if(null==a) {
					throw new Excepcion("Recurso no encontrado");
				}
				return repo.save(libro);
				
				}catch(Exception e){
					throw new Excepcion("Error al actualizar");
				}
			
		}

		@Override
		public void borrarLibro(int libroId) {
			try {
				Libro a=repo.findById(libroId).get();
				
				if(null==a) {
					throw new Excepcion("Recurso no encontrado");
				}
				repo.delete(a);
				
				}catch(Exception e){
					throw new Excepcion("Error al borrar");
				}
			
		}

		@Override
		public List<Libro> listado() {
			
			return repo.findAll();
		}

}
