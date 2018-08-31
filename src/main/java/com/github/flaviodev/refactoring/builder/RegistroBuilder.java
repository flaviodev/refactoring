package com.github.flaviodev.refactoring.builder;

import java.io.Serializable;

import com.github.flaviodev.refactoring.model.base.EntidadeBase;

public interface RegistroBuilder<I extends Serializable, E extends EntidadeBase<I>> extends EntidadeBuilder<I, E> {

	RegistroBuilder<I, E> comDadosDeOutraEntidade(E entidade);
}
