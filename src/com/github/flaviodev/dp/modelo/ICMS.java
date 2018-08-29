package com.github.flaviodev.dp.modelo;

public class ICMS extends Imposto {

	public ICMS() {

	}
	
	public ICMS(Imposto outroImposto) {

		super(outroImposto);
	}

	@Override
	public double calculaImposto(Orcamento orcamento) {
		
		return orcamento.getValor() * 0.1 + calculaOutroImposto(orcamento);
	}

}
