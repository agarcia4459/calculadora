package com.example.calculadora.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.calculadora.service.impl.CalculadoraServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CalculadoraServiceImplTest {

	private CalculadoraServiceImpl calcService = new CalculadoraServiceImpl();

	@Test
	public void sumaTest() throws Exception {
		assertEquals(calcService.calcular("5+5"), 10.0, 0);
	}

	@Test
	public void restaTest() throws Exception {
		assertEquals(calcService.calcular("10-5"), 5.0, 0);
	}

	@Test
	public void invalidOperationExceptionTest() {
		final ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
			calcService.calcular("5*5");
		});

		assertEquals("La operación * no está soportada", thrown.getMessage());
	}
}

