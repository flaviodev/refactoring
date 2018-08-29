package com.github.flaviodev.dp.strategy;

import com.github.flaviodev.dp.modelo.Imposto;
import com.github.flaviodev.dp.modelo.Orcamento;

public class CalculadorDeImposto {

	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {

		System.out.println(imposto.calculaImposto(orcamento));
	}

}
