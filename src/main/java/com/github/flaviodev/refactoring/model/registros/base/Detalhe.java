package com.github.flaviodev.refactoring.model.registros.base;

import com.github.flaviodev.refactoring.builder.TituloCobrancaBuilder;
import com.github.flaviodev.refactoring.model.TituloCobranca;

public abstract class Detalhe extends Registro<String, TituloCobranca, TituloCobrancaBuilder> {

	public Detalhe() {
	}
	
	public Detalhe(String registroDoArquivo) {
		super(registroDoArquivo);
	}

	public Detalhe(String registroDoArquivo,
			Registro<String, TituloCobranca, TituloCobrancaBuilder> registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}

}
