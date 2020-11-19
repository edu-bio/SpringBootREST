package com.crudejemplo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Excepcion extends RuntimeException {

	private String mensaje;
	
	public Excepcion(String mensaje) {
		this.mensaje=mensaje;
	}
	
	@Override
	public String getMessage() {
		return this.mensaje;
	}
}
