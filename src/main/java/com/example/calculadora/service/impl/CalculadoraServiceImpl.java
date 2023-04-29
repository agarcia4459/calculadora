package com.example.calculadora.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.calculadora.service.CalculadoraService;

@Primary
@Component
public class CalculadoraServiceImpl implements CalculadoraService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculadoraServiceImpl.class);

	@Override
	public double calcular(final String operacion) {
		LOGGER.debug("Operacion recibida {}", operacion);
		final String[] split = operacion.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
		final double primerOperante = Double.parseDouble(split[0]);
		LOGGER.debug("primerOperante = {}", primerOperante);
		final String operador = split[1];
		LOGGER.debug("operador {}", operador);
		final double segundoOperante = Double.parseDouble(split[2]);
		LOGGER.debug("segundoOperante = {}", segundoOperante);

		switch (operador) {
		case "+":
			return primerOperante + segundoOperante;
		case "-":
			return primerOperante - segundoOperante;
		default:
			LOGGER.error("Operador {} no implementado", operador);
			throw new ArithmeticException("La operación " + operador + " no está soportada");
		}
	}
}
