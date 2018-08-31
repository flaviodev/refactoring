package com.github.flaviodev.refactoring.observer.base;

import java.io.Serializable;

import com.github.flaviodev.refactoring.model.base.EntidadeBase;

public interface BaseEntityObserver<I extends Serializable, E extends EntidadeBase<I>> {

	void executa(E entidade);
}
