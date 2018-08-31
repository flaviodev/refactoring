package com.github.flaviodev.dp.observer.base;

import java.io.Serializable;

import com.github.flaviodev.dp.model.base.EntidadeBase;

public interface BaseEntityObserver<I extends Serializable, E extends EntidadeBase<I>> {

	void executa(E entidade);
}
