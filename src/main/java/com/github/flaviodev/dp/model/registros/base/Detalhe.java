package com.github.flaviodev.dp.model.registros.base;

import com.github.flaviodev.dp.builder.TituloCobrancaBuilder;
import com.github.flaviodev.dp.model.TituloCobranca;

public abstract class Detalhe extends Registro<String, TituloCobranca, TituloCobrancaBuilder> {

	public Detalhe(String registroDoArquivo) {
		super(registroDoArquivo);
	}

	public Detalhe(String registroDoArquivo,
			Registro<String, TituloCobranca, TituloCobrancaBuilder> registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}

}
