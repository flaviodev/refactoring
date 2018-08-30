package com.github.flaviodev.test;

import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.Cliente;
import com.github.flaviodev.dp.model.ItemOrcamento;

public class FabricaTest {

	private FabricaTest() {

	}

	public static Cliente criaCliente() {

		return new Cliente("Flávio Almeida", "111.111.111-11", "flavio@almeida.com.br");
	}

	public static OrcamentoBuilder criaOrcamentoBuilderSemItens() {

		return new OrcamentoBuilder().paraCliente(criaCliente());
	}

	public static OrcamentoBuilder criaOrcamentoBuilderComUmItem() {

		return new OrcamentoBuilder().paraCliente(criaCliente())
				.adicionaItem(new ItemOrcamento("MacBook Pro", 10000, 1));
	}

}
