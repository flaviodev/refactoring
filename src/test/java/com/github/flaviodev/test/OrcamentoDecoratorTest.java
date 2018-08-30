package com.github.flaviodev.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.flaviodev.dp.impostos.model.ICMS;
import com.github.flaviodev.dp.impostos.model.ISS;
import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;

public class OrcamentoDecoratorTest {

	@Test
	public void deveCalcularImpostoSimples() {

		Orcamento orcamento = FabricaTest.criaOrcamentoBuilderComUmItem()
				.adicionaItem(new ItemOrcamento("Mochila para notebook", 250, 1)).constroi();

		Double valorDoImposto = new ICMS().calculaImposto(orcamento);
		assertEquals("Valor do imposto calculado diferente do esperado", new Double(1025), valorDoImposto);
	}

	@Test
	public void deveCalcularImpostoComposto() {

		Orcamento orcamento = FabricaTest.criaOrcamentoBuilderComUmItem().constroi();

		Double valorDoImposto = new ICMS(new ISS()).calculaImposto(orcamento);
		assertEquals("Valor do imposto calculado diferente do esperado", new Double(1500), valorDoImposto);
	}
}
