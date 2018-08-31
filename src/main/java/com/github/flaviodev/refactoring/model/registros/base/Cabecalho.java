package com.github.flaviodev.refactoring.model.registros.base;

import com.github.flaviodev.refactoring.builder.RemessaBuilder;
import com.github.flaviodev.refactoring.model.Remessa;
import com.github.flaviodev.refactoring.observer.PersisteRemessaObserver;

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

	@Override
	public RemessaBuilder getBuilderRegistro() {
		return (RemessaBuilder) super.getBuilderRegistro().adicionaAcaoAoConstruir(new PersisteRemessaObserver());
	}

}
