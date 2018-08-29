package com.github.flaviodev.dp.modelo;

public class ISS extends Imposto {

	public ISS() {

	}

	public ISS(Imposto outroImposto) {

		super(outroImposto);
	}

	@Override
	public double calculaImposto(Orcamento orcamento) {

		return orcamento.getValorTotal() * 0.05 + calculaOutroImposto(orcamento);
	}

}
