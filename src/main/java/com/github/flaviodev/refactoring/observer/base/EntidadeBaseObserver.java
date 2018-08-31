package com.github.flaviodev.refactoring.observer.base;

import java.io.Serializable;

import com.github.flaviodev.refactoring.model.base.EntidadeBase;

public interface EntidadeBaseObserver<I extends Serializable, E extends EntidadeBase<I>> {

	E executa(E entidade);
}
