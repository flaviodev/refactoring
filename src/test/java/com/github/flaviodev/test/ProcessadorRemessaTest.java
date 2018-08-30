package com.github.flaviodev.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.flaviodev.dp.impostos.model.ICMS;
import com.github.flaviodev.dp.impostos.model.ISS;
import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;
import com.github.flaviodev.dp.model.registros.ProcessadorRemessa;

public class ProcessadorRemessaTest {

	@Test
	public void deveCalcularImpostoSimples() {
		ProcessadorRemessa processador = ProcessadorRemessa.get();
		
		processador.processaRemessa(getClass().getClassLoader().getResourceAsStream("CB01012018.REM"));
	}

}
