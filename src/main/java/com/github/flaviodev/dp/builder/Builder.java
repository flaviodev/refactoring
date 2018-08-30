package com.github.flaviodev.dp.builder;

import java.io.Serializable;

import com.github.flaviodev.dp.model.base.BaseEntity;

public interface Builder<I extends Serializable, E extends BaseEntity<I>> {
	
	E constroi();
}
