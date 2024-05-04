package com.ucsal.reservalami.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManipuladorExcecoes {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<?> manipularCodigoLamiOuNumeroSalaDuplicado(SQLIntegrityConstraintViolationException e) {
		Map<String, String> response = new HashMap<>();
		response.put("mensagemErro", "Alguns atributos precisam ser únicos");
		return ResponseEntity.status(HttpStatusCode.valueOf(409)).body(response);

	}
}
