package com.crudejemplo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExcepcionClases extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<?> handleCrudOperationException(Excepcion e, WebRequest w){
		return new ResponseEntity<Object>(e,HttpStatus.BAD_REQUEST);
	}
}
