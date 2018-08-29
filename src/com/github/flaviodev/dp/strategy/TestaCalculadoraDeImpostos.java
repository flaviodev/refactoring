package com.github.flaviodev.dp.strategy;

import com.github.flaviodev.dp.modelo.ICMS;
import com.github.flaviodev.dp.modelo.ISS;
import com.github.flaviodev.dp.modelo.Orcamento;

public class TestaCalculadoraDeImpostos {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(100);
		CalculadorDeImposto calculadora = new CalculadorDeImposto();
		
		calculadora.realizaCalculo(orcamento, new ISS());
		calculadora.realizaCalculo(orcamento, new ICMS());
	}
}
