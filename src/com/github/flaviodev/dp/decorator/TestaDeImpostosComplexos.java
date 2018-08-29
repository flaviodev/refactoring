package com.github.flaviodev.dp.decorator;

import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.ICMS;
import com.github.flaviodev.dp.model.ISS;
import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;

public class TestaDeImpostosComplexos {

	public static void main(String[] args) {

		Orcamento orcamento = new OrcamentoBuilder().paraCliente("cliente").doVendedor("vendedor")
				.adicionaItem(new ItemOrcamento("notebook").setQuantidade(2).setValor(2500)).constroi();

		System.out.println(new ICMS(new ISS()).calculaImposto(orcamento));

	}

}
