package com.crudejemplo.controlador;

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
		return null;
	}
	
	@DeleteMapping("/{autorId}")
	public ResponseEntity<?> borrarAutor(@PathVariable(required=true) int autorId){
		return null;
	}
}
