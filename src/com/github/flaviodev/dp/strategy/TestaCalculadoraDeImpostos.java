package com.github.flaviodev.dp.strategy;

import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.ICMS;
import com.github.flaviodev.dp.model.ISS;
import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;

public class TestaCalculadoraDeImpostos {

	public static void main(String[] args) {
		Orcamento orcamento = new OrcamentoBuilder().paraCliente("cliente").doVendedor("vendedor")
				.adicionaItem(new ItemOrcamento("notebook").setQuantidade(1).setValor(1000)).constroi();
		CalculadorDeImposto calculadora = new CalculadorDeImposto();

		calculadora.realizaCalculo(orcamento, new ISS());
		calculadora.realizaCalculo(orcamento, new ICMS());
	}
}
