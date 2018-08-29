package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.modelo.Orcamento;

public class NotificaDepartamentoDeVendas implements AcaoAposCriarOrcamento {

	@Override
	public void executa(Orcamento orcamento) {

		System.out.println("notifica departamento de vendas vendedor: " + orcamento.getNomeVendedor());
	}
}
