package com.github.flaviodev.dp.strategy.impostos;

import com.github.flaviodev.dp.strategy.Orcamento;

public class ICMS implements Imposto {

	@Override
	public double calculaImposto(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}

}
