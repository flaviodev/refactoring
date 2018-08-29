package com.github.flaviodev.dp.decorator;

import com.github.flaviodev.dp.modelo.ICMS;
import com.github.flaviodev.dp.modelo.ISS;
import com.github.flaviodev.dp.modelo.Orcamento;

public class TesteDeImpostosComplexos {

	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(100);
		
		System.out.println(new ICMS(new ISS()).calculaImposto(orcamento));
		
	}
	
}
