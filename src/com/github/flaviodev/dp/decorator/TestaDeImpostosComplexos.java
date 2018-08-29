package com.github.flaviodev.dp.decorator;

import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.modelo.ICMS;
import com.github.flaviodev.dp.modelo.ISS;
import com.github.flaviodev.dp.modelo.ItemOrcamento;
import com.github.flaviodev.dp.modelo.Orcamento;

public class TestaDeImpostosComplexos {

	public static void main(String[] args) {

		Orcamento orcamento = new OrcamentoBuilder().paraCliente("cliente").doVendedor("vendedor")
				.adicionaItem(new ItemOrcamento("notebook").setQuantidade(2).setValor(2500)).constroi();

		System.out.println(new ICMS(new ISS()).calculaImposto(orcamento));

	}

}
