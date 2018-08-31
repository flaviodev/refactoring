package com.github.flaviodev.refactoring.builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.github.flaviodev.refactoring.model.base.EntidadeBase;
import com.github.flaviodev.refactoring.observer.base.EntidadeBaseObserver;

public abstract class RegistroBuilder<I extends Serializable, E extends EntidadeBase<I>> implements EntidadeBuilder<I, E> {

	public RegistroBuilder() {
		acoesAoConstruir = new ArrayList<>();
	}
	
	private List<EntidadeBaseObserver<I, E>> acoesAoConstruir;

	public abstract RegistroBuilder<I, E> comDadosDeOutraEntidade(E entidade);

	public List<EntidadeBaseObserver<I, E>> getAcoesAoConstruir() {
		return acoesAoConstruir;
	}

	public RegistroBuilder<I,E> adicionaAcaoAoConstruir(EntidadeBaseObserver<I, E> acaoAoConstruir) {
		acoesAoConstruir.add(acaoAoConstruir);
		
		return this;
	}
	
}
