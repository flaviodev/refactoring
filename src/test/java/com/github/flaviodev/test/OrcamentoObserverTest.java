package com.github.flaviodev.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;
import com.github.flaviodev.dp.observer.EnviaOrcamentoPorEmail;
import com.github.flaviodev.dp.observer.ImprimeOrcamento;
import com.github.flaviodev.dp.observer.PersisteOrcamento;

public class OrcamentoObserverTest {

	@Test
	public void deveImprimirAposCriarOrcamento() {

		OrcamentoBuilder orcamentoBuilder = new OrcamentoBuilder();
		orcamentoBuilder.paraCliente(FabricaTest.criaCliente())
				.adicionaItem(new ItemOrcamento("Teclado Wifi MacBook", 1000, 1));
		orcamentoBuilder.adicionaAcao(new ImprimeOrcamento());

		Orcamento orcamento = orcamentoBuilder.constroi();

		assertFalse("Orçamento não devia ter sido enviado por email", orcamento.isEnviadoPorEmail());
		assertTrue("Orçamento devia ter sido impresso", orcamento.isImpresso());
		assertTrue("Orçamento não devia ter sido salvo", orcamento.isTransient());
		assertTrue("Cliente não devia ter sido salvo", orcamento.getCliente().isTransient());
		orcamento.getItens().forEach(item -> assertTrue("Item orçamento não devia ter sido salvo", item.isTransient()));
	}

	@Test
	public void deveEnviarEmailAposCriarOrcamento() {

		OrcamentoBuilder orcamentoBuilder = new OrcamentoBuilder();
		orcamentoBuilder.paraCliente(FabricaTest.criaCliente())
				.adicionaItem(new ItemOrcamento("Mouse Wifi MacBook", 500, 1));
		orcamentoBuilder.adicionaAcao(new EnviaOrcamentoPorEmail());

		Orcamento orcamento = orcamentoBuilder.constroi();

		assertTrue("Orçamento devia ter sido enviado por email", orcamento.isEnviadoPorEmail());
		assertFalse("Orçamento não devia ter sido impresso", orcamento.isImpresso());
		assertTrue("Orçamento não devia ter sido salvo", orcamento.isTransient());
		assertTrue("Cliente não devia ter sido salvo", orcamento.getCliente().isTransient());

		orcamento.getItens().forEach(item -> assertTrue("Item orçamento não devia ter sido salvo", item.isTransient()));
	}

	@Test
	public void deveSalvarAposCriarOrcamento() {

		OrcamentoBuilder orcamentoBuilder = new OrcamentoBuilder();
		orcamentoBuilder.paraCliente(FabricaTest.criaCliente()).adicionaItem(new ItemOrcamento("MacBook Pro", 10000, 1))
				.adicionaItem(new ItemOrcamento("Mochila para notebook", 250, 1));
		orcamentoBuilder.adicionaAcao(new PersisteOrcamento());

		Orcamento orcamento = orcamentoBuilder.constroi();

		assertFalse("Orçamento não devia ter sido enviado por email", orcamento.isEnviadoPorEmail());
		assertFalse("Orçamento não devia ter sido impresso", orcamento.isImpresso());
		assertFalse("Orçamento devia ter sido salvo", orcamento.isTransient());
		assertFalse("Cliente devia ter sido salvo", orcamento.getCliente().isTransient());
		orcamento.getItens().forEach(item -> assertFalse("Item orçamento devia ter sido salvo", item.isTransient()));
	}

	@Test
	public void deveEnviarPorEmailESalvarAposCriarOrcamento() {

		OrcamentoBuilder orcamentoBuilder = new OrcamentoBuilder();
		orcamentoBuilder.paraCliente(FabricaTest.criaCliente()).adicionaItem(new ItemOrcamento("MacBook Pro", 10000, 1))
				.adicionaItem(new ItemOrcamento("Mochila para notebook", 250, 1));
		orcamentoBuilder.adicionaAcao(new EnviaOrcamentoPorEmail()).adicionaAcao(new PersisteOrcamento());

		Orcamento orcamento = orcamentoBuilder.constroi();

		assertTrue("Orçamento devia ter sido enviado por email", orcamento.isEnviadoPorEmail());
		assertFalse("Orçamento não devia ter sido impresso", orcamento.isImpresso());
		assertFalse("Orçamento devia ter sido salvo", orcamento.isTransient());
		assertFalse("Cliente devia ter sido salvo", orcamento.getCliente().isTransient());
		orcamento.getItens().forEach(item -> assertFalse("Item orçamento devia ter sido salvo", item.isTransient()));
	}

}
