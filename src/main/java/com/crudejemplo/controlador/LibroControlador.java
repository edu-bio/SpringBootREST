package com.crudejemplo.controlador;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudejemplo.clases.Libro;
import com.crudejemplo.exception.Excepcion;
import com.crudejemplo.service.LibroService;
@RestController
@RequestMapping("/libros")
public class LibroControlador {
		
		@Autowired
		LibroService libroService;

		@PostMapping
		public ResponseEntity<?> crearLibro (@RequestBody Libro libro){
			Libro a=libroService.crearLibro(libro);
			return new ResponseEntity<>(a,HttpStatus.CREATED);
		}
		
		@GetMapping("/{libroId}")
		public ResponseEntity<?> getLibro(@PathVariable(required=true)int libroId) {
		
			Libro a=libroService.getLibro(libroId);
			return new ResponseEntity<>(a,HttpStatus.OK);
		}
		
		@PutMapping
		public ResponseEntity<?> actualizarLibro(@RequestBody Libro libro){
			if(libro.getId()<=0) {
				throw new Excepcion("Id inválido");
			}
			Libro a=libroService.actualizarLibro(libro);
			
			return new ResponseEntity<>(a,HttpStatus.OK);
		}
		
		@DeleteMapping("/{libroId}")
		public ResponseEntity<?> borrarAutor(@PathVariable(required=true) int libroId){
			try {
				if(libroId<=0) {
					throw new Excepcion ("Id inválido");
				}
				libroService.borrarLibro(libroId);
			}catch (Exception e) {
				throw new Excepcion("Error durante el borrado");
			}
			Map<String,Object> map= new HashMap<>();
			map.put("mensaje", "Id borrado : " + libroId);
			return new ResponseEntity<Map>(map,HttpStatus.OK);
		}

}
