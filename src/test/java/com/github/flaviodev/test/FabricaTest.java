package com.github.flaviodev.test;

import com.github.flaviodev.refactoring.builder.OrcamentoBuilder;
import com.github.flaviodev.refactoring.model.ItemOrcamento;
import com.github.flaviodev.refactoring.model.Sacado;

public class FabricaTest {

	private FabricaTest() {

	}

	public static Sacado criaCliente() {

		return new Sacado("Flávio Almeida", "111.111.111-11", "flavio@almeida.com.br");
	}

	public static OrcamentoBuilder criaOrcamentoBuilderSemItens() {

		return new OrcamentoBuilder().paraCliente(criaCliente());
	}

	public static OrcamentoBuilder criaOrcamentoBuilderComUmItem() {

		return new OrcamentoBuilder().paraCliente(criaCliente())
				.adicionaItem(new ItemOrcamento("MacBook Pro", 10000, 1));
	}

}
