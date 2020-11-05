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

import com.crudejemplo.clases.Autor;
import com.crudejemplo.exception.Excepcion;
import com.crudejemplo.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorControlador {
	
	@Autowired
	AutorService autorService;

	@PostMapping
	public ResponseEntity<?> crearAutor (@RequestBody Autor autor){
		Autor a=autorService.crearAutor(autor);
		return new ResponseEntity<>(a,HttpStatus.CREATED);
	}
	
	@GetMapping("/{autorId}")
	public ResponseEntity<?> getAutor(@PathVariable(required=true)int autorId) {
	
		Autor a=autorService.getAutor(autorId);
		return new ResponseEntity<>(a,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> actualizarAutor(@RequestBody Autor autor){
		if(autor.getId()<=0) {
			throw new Excepcion("Id inválido");
		}
		Autor a=autorService.actualizarAutor(autor);
		
		return new ResponseEntity<>(a,HttpStatus.OK);
	}
	
	@DeleteMapping("/{autorId}")
	public ResponseEntity<?> borrarAutor(@PathVariable(required=true) int autorId){
		try {
			if(autorId<=0) {
				throw new Excepcion ("Id inválido");
			}
			autorService.borrarAutor(autorId);
		}catch (Exception e) {
			throw new Excepcion("Error durante el borrado");
		}
		Map<String,Object> map= new HashMap<>();
		map.put("mensaje", "Id borrado : " + autorId);
		return new ResponseEntity<Map>(map,HttpStatus.OK);
	}
}
