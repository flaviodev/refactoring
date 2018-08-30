package com.github.flaviodev.dp.impostos.model;

import com.github.flaviodev.dp.model.Orcamento;

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
