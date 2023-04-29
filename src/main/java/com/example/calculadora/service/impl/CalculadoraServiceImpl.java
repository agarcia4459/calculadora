package com.example.calculadora.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.calculadora.service.CalculadoraService;

@Primary
@Component
public class CalculadoraServiceImpl implements CalculadoraService {

	@Override
	public double calcular(final String operacion) {
		// TODO Auto-generated method stub
		return 0;
	}
}
