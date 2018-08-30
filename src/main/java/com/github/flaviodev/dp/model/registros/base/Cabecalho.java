package com.github.flaviodev.dp.model.registros.base;

import com.github.flaviodev.dp.builder.RemessaBuilder;
import com.github.flaviodev.dp.model.Remessa;

public abstract class Cabecalho extends Registro<String, Remessa, RemessaBuilder> {

	public Cabecalho(String registroDoArquivo) {
		super(registroDoArquivo);
	}

	private Remessa remessa;

	public Remessa getRemessa() {
		return remessa;
	}

	public void setRemessa(Remessa remessa) {
		this.remessa = remessa;
	}

}
