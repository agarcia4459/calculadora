package com.example.calculadora.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.calculadora.api.CalculadoraController;
import com.example.calculadora.service.CalculadoraService;

@AutoConfigureMockMvc
@WebMvcTest(CalculadoraController.class)
public class CalculadoraControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CalculadoraService service;

	@Test
	public void calculateApiOk() throws Exception {
		mvc.perform(get("/calc/5+5")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	public void calculateApiBadRequest() throws Exception {
		mvc.perform(get("/calc/5*5")).andExpect(status().isBadRequest());
	}
}
