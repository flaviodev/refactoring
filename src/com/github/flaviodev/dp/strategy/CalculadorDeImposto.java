package com.github.flaviodev.dp.strategy;

import com.github.flaviodev.dp.strategy.impostos.Imposto;

public class CalculadorDeImposto {

	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {

			System.out.println(imposto.calculaImposto(orcamento));
	}

}
