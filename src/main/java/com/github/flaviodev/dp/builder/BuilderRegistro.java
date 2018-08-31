package com.github.flaviodev.dp.builder;

import java.io.Serializable;

import com.github.flaviodev.dp.model.base.BaseEntity;

public interface BuilderRegistro<I extends Serializable, E extends BaseEntity<I>> extends Builder<I, E> {

	BuilderRegistro<I, E> comDadosDeOutraEntidade(E entidade);
}
