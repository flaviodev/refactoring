package com.github.flaviodev.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.flaviodev.dp.impostos.model.ICMS;
import com.github.flaviodev.dp.impostos.model.ISS;
import com.github.flaviodev.dp.model.Orcamento;

public class OrcamentoStrategyTest {

	@Test
	public void deveCalcularICMS() {

		Orcamento orcamento = FabricaTest.criaOrcamentoBuilderComUmItem().constroi();

		Double valorDoImposto = new ICMS().calculaImposto(orcamento);
		assertEquals("Valor do imposto calculado diferente do esperado", new Double(1000), valorDoImposto);
	}

	@Test
	public void deveCalcularISS() {

		Orcamento orcamento = FabricaTest.criaOrcamentoBuilderComUmItem().constroi();

		Double valorDoImposto = new ISS().calculaImposto(orcamento);
		assertEquals("Valor do imposto calculado diferente do esperado", new Double(500), valorDoImposto);
	}
}
