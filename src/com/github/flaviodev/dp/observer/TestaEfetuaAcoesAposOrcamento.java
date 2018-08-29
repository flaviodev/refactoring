package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.builder.OrcamentoBuilder;
import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;

public class TestaEfetuaAcoesAposOrcamento {
	public static void main(String[] args) {

		Orcamento orcamento = new OrcamentoBuilder().paraCliente("cliente").doVendedor("vendedor")
				.adicionaItem(new ItemOrcamento("notebook").setQuantidade(2).setValor(2500))
				.adicionaAcao(new EnviaOrcamentoPorEmail()).adicionaAcao(new ImprimeOrcamento())
				.adicionaAcao(new NotificaDepartamentoDeVendas()).constroi();
		
		System.out.println(orcamento.getValorTotal());
	}
}
