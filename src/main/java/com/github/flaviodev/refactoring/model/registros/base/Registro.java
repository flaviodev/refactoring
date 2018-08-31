package com.github.flaviodev.refactoring.model.registros.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Date;

import com.github.flaviodev.refactoring.builder.RegistroBuilder;
import com.github.flaviodev.refactoring.model.base.EntidadeBase;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;
import com.github.flaviodev.refactoring.util.DateUtil;

@SuppressWarnings("rawtypes")
public abstract class Registro<I extends Serializable, E extends EntidadeBase<I>, B extends RegistroBuilder<I, E>> {

	private B builderRegistro;
	private Long sequenciaNoArquivo;

	private Registro registroVinculado;

	public Registro() {

	}

	public Registro(Registro registroVinculado) {
		this.registroVinculado = registroVinculado;
	}

	public Registro getRegistroVinculado() {
		return registroVinculado;
	}

	public void setRegistroVinculado(Registro registroVinculado) {
		this.registroVinculado = registroVinculado;
	}

	@SuppressWarnings("unchecked")
	public B getBuilderRegistro() {

		if (builderRegistro == null) {

			try {
				Class<B> clazzBuilder = (Class<B>) ((ParameterizedType) getClass().getSuperclass().getSuperclass()
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

	public abstract E processaRegistroArquivo(String registroDoArquivo, Registro registroVinculado);

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
