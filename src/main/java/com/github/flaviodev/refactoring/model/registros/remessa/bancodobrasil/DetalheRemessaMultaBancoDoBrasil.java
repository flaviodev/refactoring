package com.github.flaviodev.refactoring.model.registros.remessa.bancodobrasil;

import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaMulta;

public class DetalheRemessaMultaBancoDoBrasil extends DetalheRemessaMulta {

	public DetalheRemessaMultaBancoDoBrasil() {
	}
	
	public DetalheRemessaMultaBancoDoBrasil(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}
}
