package com.github.flaviodev.refactoring.builder;

import java.io.Serializable;

import com.github.flaviodev.refactoring.model.base.EntidadeBase;

public interface EntidadeBuilder<I extends Serializable, E extends EntidadeBase<I>> {

	E constroi();
}
