package com.github.flaviodev.refactoring.observer;

import com.github.flaviodev.refactoring.model.Orcamento;

public class ImprimeOrcamento implements ConstroiOrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {

		System.out.println("imprime orcamento valor: " + orcamento.getValorTotal());
		orcamento.setImpresso(true);
	}
}
