package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.modelo.Orcamento;

public class ImprimeOrcamento implements AcaoAposCriarOrcamento {

	@Override
	public void executa(Orcamento orcamento) {

		System.out.println("imprime orcamento valor: " + orcamento.getValorTotal());
	}
}
