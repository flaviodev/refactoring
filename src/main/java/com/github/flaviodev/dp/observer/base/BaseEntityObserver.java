package com.github.flaviodev.dp.observer.base;

import java.io.Serializable;

import com.github.flaviodev.dp.model.base.BaseEntity;

public interface BaseEntityObserver<I extends Serializable, E extends BaseEntity<I>> {

	void executa(E entidade);
}
