package com.github.flaviodev.dp.builder;

import java.io.Serializable;

import com.github.flaviodev.dp.model.base.EntidadeBase;

public interface EntidadeBuilder<I extends Serializable, E extends EntidadeBase<I>> {
	
	E constroi();
}
