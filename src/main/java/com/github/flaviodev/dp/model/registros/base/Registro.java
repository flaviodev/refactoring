package com.github.flaviodev.dp.model.registros.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Date;

import com.github.flaviodev.dp.builder.BuilderRegistro;
import com.github.flaviodev.dp.model.base.BaseEntity;
import com.github.flaviodev.dp.tipo.TipoRegistro;
import com.github.flaviodev.dp.util.DateUtil;

@SuppressWarnings("rawtypes")
public abstract class Registro<I extends Serializable, E extends BaseEntity<I>, B extends BuilderRegistro<I, E>> {

	private String registroDoArquivo;
	private B builderRegistro;
	private Long sequenciaNoArquivo;

	private Registro registroVinculado;

	public Registro(String registroDoArquivo) {
		this.registroDoArquivo = registroDoArquivo;
	}

	public Registro(String registroDoArquivo, Registro registroVinculado) {
		this.registroDoArquivo = registroDoArquivo;
		this.registroVinculado = registroVinculado;
	}

	public String getRegistroDoArquivo() {
		return registroDoArquivo;
	}

	@SuppressWarnings("unchecked")
	public B getBuilderRegistro() {

		if (builderRegistro == null) {

			try {
				Class<B> clazzBuilder = (Class<B>) ((ParameterizedType) getClass().getSuperclass()
						.getGenericSuperclass()).getActualTypeArguments()[2];

				builderRegistro = clazzBuilder.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {

			}
		}

		return builderRegistro;
	}

	public abstract TipoRegistro getTipo();

	public Long getSequenciaNoArquivo() {
		return sequenciaNoArquivo;
	}

	public void setSequenciaNoArquivo(Long sequenciaNoArquivo) {
		this.sequenciaNoArquivo = sequenciaNoArquivo;
	}

	public abstract E processaRegistroArquivo();

	@SuppressWarnings("unchecked")
	public E processaRegistroVinculado(E entidade) {

		if (registroVinculado == null)
			return entidade;

		return (E) registroVinculado.getBuilderRegistro().comDadosDeOutraEntidade(entidade).constroi();
	}

	public Date toDate(String data) {
		return DateUtil.toDate(data, "ddMMyyyy");
	}

	public BigDecimal toBigDecimal(String valor) {
		return new BigDecimal(valor).divide(new BigDecimal(100));
	}
}
