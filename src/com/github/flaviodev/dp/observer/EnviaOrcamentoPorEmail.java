package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.model.Orcamento;

public class EnviaOrcamentoPorEmail implements AcaoAposCriarOrcamento {

	@Override
	public void executa(Orcamento orcamento) {

		System.out.println("envia orcamento por e-mail para: " + orcamento.getNomeCliente());
	}
}
