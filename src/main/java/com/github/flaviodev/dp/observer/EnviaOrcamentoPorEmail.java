package com.github.flaviodev.dp.observer;

import com.github.flaviodev.dp.model.Orcamento;

public class EnviaOrcamentoPorEmail implements ConstroiOrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {
		System.out.println("envia orcamento por e-mail para: " + orcamento.getCliente().getEmail());
		orcamento.setEnviadoPorEmail(true);
	}
}
