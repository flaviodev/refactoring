package com.github.flaviodev.dp.model.registros.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import com.github.flaviodev.dp.builder.BuilderRegistro;
import com.github.flaviodev.dp.model.base.BaseEntity;
import com.github.flaviodev.dp.tipo.TipoRegistro;

public abstract class Registro<I extends Serializable, E extends BaseEntity<I>, B extends BuilderRegistro<I, E>> {

	private String registroDoArquivo;
	private TipoRegistro tipo;
	private Long sequenciaNoArquivo;

	private Registro<I, E, B> registroVinculado;

	public Registro(String registroDoArquivo) {
		this.registroDoArquivo = registroDoArquivo;
	}

	public Registro(String registroDoArquivo, Registro<I, E, B> registroVinculado) {
		this.registroDoArquivo = registroDoArquivo;
		this.registroVinculado = registroVinculado;
	}

	public String getRegistroDoArquivo() {
		return registroDoArquivo;
	}

	@SuppressWarnings("unchecked")
	public B getBuilderRegistro() {
		Class<B> clazzBuilder = (Class<B>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass())
				.getActualTypeArguments()[2];

		try {
			return clazzBuilder.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}

	}

	public TipoRegistro getTipo() {
		return tipo;
	}

	public void setTipo(TipoRegistro tipo) {
		this.tipo = tipo;
	}

	public Long getSequenciaNoArquivo() {
		return sequenciaNoArquivo;
	}

	public void setSequenciaNoArquivo(Long sequenciaNoArquivo) {
		this.sequenciaNoArquivo = sequenciaNoArquivo;
	}

	public abstract E processaRegistroArquivo();

	public E processaDetalheVinculado() {

		if (registroVinculado == null)
			return null;

		return registroVinculado.processaRegistroArquivo();
	}
}
