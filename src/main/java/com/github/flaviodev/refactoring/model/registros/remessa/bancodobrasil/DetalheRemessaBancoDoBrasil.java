package com.github.flaviodev.refactoring.model.registros.remessa.bancodobrasil;

import com.github.flaviodev.refactoring.model.Remessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;

public class DetalheRemessaBancoDoBrasil extends DetalheRemessa {

	public DetalheRemessaBancoDoBrasil() {
	}
	
	public DetalheRemessaBancoDoBrasil(String registroDoArquivo, Remessa remessa) {
		super(registroDoArquivo, remessa);
	}

	public DetalheRemessaBancoDoBrasil(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}

}
