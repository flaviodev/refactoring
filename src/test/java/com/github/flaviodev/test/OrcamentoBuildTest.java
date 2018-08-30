package com.github.flaviodev.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.Cliente;
import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;
import com.github.flaviodev.dp.observer.EnviaOrcamentoPorEmail;
import com.github.flaviodev.dp.observer.ImprimeOrcamento;

public class OrcamentoBuildTest {

	private final static String NOME = "Iberê Tenório";
	private final static String CPF = "222.222.222-22";
	private final static String EMAIL = "ibere@manualdomundo.com.br";

	private Cliente criaCliente() {
		return new Cliente(NOME, CPF, EMAIL);
	}

	private void assertCliente(Orcamento orcamento) {
		assertEquals(NOME, orcamento.getCliente().getNome());
		assertEquals(CPF, orcamento.getCliente().getCpf());
		assertEquals(EMAIL, orcamento.getCliente().getEmail());
	}

	@Test
	public void deveCriarOrcamentoComUmItem() {

		Orcamento orcamento = new OrcamentoBuilder().paraCliente(criaCliente())
				.adicionaItem(new ItemOrcamento("Bastão de cola quente", 10, 3)).constroi();

		assertCliente(orcamento);

		assertTrue("Orçamento devia ter apenas um item", orcamento.getItens().size() == 1);
		assertEquals("Bastão de cola quente", orcamento.getItens().get(0).getDescricao());
		assertEquals(new Double(10), new Double(orcamento.getItens().get(0).getValor()));
		assertEquals(new Double(3), new Double(orcamento.getItens().get(0).getQuantidade()));
	}

	@Test
	public void deveCriarOrcamentoComDoisItens() {

		Orcamento orcamento = new OrcamentoBuilder().paraCliente(criaCliente())
				.adicionaItem(new ItemOrcamento("Bastão de cola quente", 10, 3))
				.adicionaItem(new ItemOrcamento("Bicarbonado de Sódio", 2, 2)).constroi();

		assertCliente(orcamento);

		assertTrue("Orçamento devia ter apenas dois itens", orcamento.getItens().size() == 2);
	}

	@Test
	public void deveCriarOrcamentoComUmItemEUmaAcao() {

		OrcamentoBuilder builder = new OrcamentoBuilder().paraCliente(criaCliente())
				.adicionaItem(new ItemOrcamento("Bastão de cola quente", 10, 3))
				.adicionaAcao(new EnviaOrcamentoPorEmail());

		Orcamento orcamento = builder.constroi();

		assertCliente(orcamento);

		assertTrue("Orçamento devia ter apenas um item", orcamento.getItens().size() == 1);
		assertTrue("Orçamento devia ter apenas uma acao", builder.getAcoes().size() == 1);

		assertEquals(EnviaOrcamentoPorEmail.class, builder.getAcoes().get(0).getClass());
	}

	@Test
	public void deveCriarOrcamentoComUmItemEDuasAcoes() {

		OrcamentoBuilder builder = new OrcamentoBuilder().paraCliente(criaCliente())
				.adicionaItem(new ItemOrcamento("Bastão de cola quente", 10, 3))
				.adicionaAcao(new EnviaOrcamentoPorEmail()).adicionaAcao(new ImprimeOrcamento());

		Orcamento orcamento = builder.constroi();

		assertCliente(orcamento);

		assertTrue("Orçamento devia ter apenas um item", orcamento.getItens().size() == 1);
		assertTrue("Orçamento devia ter apenas uma acao", builder.getAcoes().size() == 2);
	}
}
