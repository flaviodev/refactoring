package com.github.flaviodev.dp.model.registros.remessa;

import org.apache.log4j.Logger;

import com.github.flaviodev.dp.builder.SacadoBuilder;
import com.github.flaviodev.dp.builder.TituloCobrancaBuilder;
import com.github.flaviodev.dp.model.TituloCobranca;
import com.github.flaviodev.dp.model.registros.base.Detalhe;

public class DetalheRemessa extends Detalhe {

	private Logger logger = Logger.getLogger(DetalheRemessa.class);

	public DetalheRemessa(String registroDoArquivo) {
		super(registroDoArquivo);
	}

	@Override
	public TituloCobranca processaRegistroArquivo() {
		TituloCobrancaBuilder builder = getBuilderRegistro().populaRegistro(processaDetalheVinculado());

		builder.comNumero(getRegistroDoArquivo().substring(2, 12).trim());
		builder.doSacado(new SacadoBuilder().comNomeRazaoSocial(getRegistroDoArquivo().substring(12, 104))
				.comCpfCnpj(getRegistroDoArquivo().substring(104, 118)).constroi());

		TituloCobranca titulo = builder.constroi();

		logger.info(titulo);

		return titulo;
	}

}
