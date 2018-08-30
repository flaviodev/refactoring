package com.github.flaviodev.dp.model.registros.base;

import java.io.Serializable;

import com.github.flaviodev.dp.builder.BuilderRegistro;
import com.github.flaviodev.dp.model.base.BaseEntity;
import com.github.flaviodev.dp.tipo.TipoRegistro;

public abstract class Registro<I extends Serializable, E extends BaseEntity<I>, B extends BuilderRegistro<I, E>> {

	private String registroDoArquivo;
	private B builderRegistro;
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

	public B getBuilderRegistro() {
		return builderRegistro;
	}

	public void setBuilderRegistro(B builderRegistro) {
		this.builderRegistro = builderRegistro;
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
