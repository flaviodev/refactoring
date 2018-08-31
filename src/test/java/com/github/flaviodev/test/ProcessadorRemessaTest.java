package com.github.flaviodev.test;

import org.junit.Test;

import com.github.flaviodev.refactoring.model.registros.ProcessadorRemessa;

public class ProcessadorRemessaTest {

	@Test
	public void deveCalcularImpostoSimples() {
		ProcessadorRemessa processador = ProcessadorRemessa.get();
		
		processador.processaRemessa(getClass().getClassLoader().getResourceAsStream("CB01012018.REM"));
	}

}
