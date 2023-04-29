package com.example.calculadora.api;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculadora.service.CalculadoraService;

import io.corp.calculator.TracerImpl;

@RestController
public class CalculadoraController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculadoraController.class);
	private static final Pattern operacionesValidasPattern = Pattern.compile("[0-9]+(\\+|-)[0-9]+");

	private final CalculadoraService calcService;

	@Autowired
	public CalculadoraController(final CalculadoraService calcService) {
		this.calcService = calcService;
	}

	@GetMapping(value = "/calc/{operacion}")
	@ResponseBody
	public ResponseEntity<Double> calcular(@PathVariable("operacion") final String operacion) {
		LOGGER.debug("Inicio operacion {}", operacion);
		if (!isValid(operacion)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		final TracerImpl tracerAPI = new TracerImpl();
		final double resultado = calcService.calcular(operacion);
		tracerAPI.trace(resultado);
		return ResponseEntity.ok(resultado);
	}

	private boolean isValid(final String operacion) {
		if (ObjectUtils.isEmpty(operacion) || !operacionesValidasPattern.matcher(operacion).find()) {
			return false;
		} else {

			return true;
		}
	}
}
