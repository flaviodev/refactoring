package com.github.flaviodev.dp.strategy;

import com.github.flaviodev.dp.impostos.model.Imposto;
import com.github.flaviodev.dp.model.Orcamento;

public class CalculadorDeImposto {

	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {

		System.out.println(imposto.calculaImposto(orcamento));
	}

}
