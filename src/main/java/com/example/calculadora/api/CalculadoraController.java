package com.example.calculadora.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculadora.service.CalculadoraService;

@RestController
public class CalculadoraController {

	private final CalculadoraService calcService;

	@Autowired
	public CalculadoraController(final CalculadoraService calcService) {
		this.calcService = calcService;
	}

	@GetMapping(value = "/calc/{operacion}")
	@ResponseBody
	public ResponseEntity<Double> calcular(@PathVariable("operacion") final String operacion) {
		return null;
	}
}
