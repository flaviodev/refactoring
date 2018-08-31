package com.github.flaviodev.refactoring.model.registros.remessa;

import org.apache.log4j.Logger;

import com.github.flaviodev.refactoring.builder.SacadoBuilder;
import com.github.flaviodev.refactoring.builder.TituloCobrancaBuilder;
import com.github.flaviodev.refactoring.model.TituloCobranca;
import com.github.flaviodev.refactoring.model.registros.base.Detalhe;
import com.github.flaviodev.refactoring.observer.EnviaBoletoParaClienteObserver;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;

public class DetalheRemessaEmail extends Detalhe {

	private Logger logger = Logger.getLogger(DetalheRemessaEmail.class);

	public DetalheRemessaEmail() {
		getBuilderRegistro().adicionaAcaoAoConstruir(new EnviaBoletoParaClienteObserver());
	}
	
	public DetalheRemessaEmail(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
		getBuilderRegistro().adicionaAcaoAoConstruir(new EnviaBoletoParaClienteObserver());
	}

	@Override
	public TipoRegistro getTipo() {
		return TipoRegistro.DETALHE_REMESSA_EMAIL_SACADO;
	}

	@Override
	public TituloCobranca processaRegistroArquivo() {
		String registro = getRegistroDoArquivo();

		TituloCobrancaBuilder builder = getBuilderRegistro()
				.doSacado(new SacadoBuilder().comEmail(registro.substring(2, 152).trim()).constroi());

		TituloCobranca titulo = processaRegistroVinculado(builder.constroi());

		logger.info(titulo);

		return titulo;
	}
}
