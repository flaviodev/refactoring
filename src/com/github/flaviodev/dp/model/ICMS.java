package com.github.flaviodev.dp.model;

public class ICMS extends Imposto {

	public ICMS() {

	}

	public ICMS(Imposto outroImposto) {

		super(outroImposto);
	}

	@Override
	public double calculaImposto(Orcamento orcamento) {

		return orcamento.getValorTotal() * 0.1 + calculaOutroImposto(orcamento);
	}

}
