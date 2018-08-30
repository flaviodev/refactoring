package com.github.flaviodev.dp.model.registros.remessa;

import org.apache.log4j.Logger;

import com.github.flaviodev.dp.builder.SacadoBuilder;
import com.github.flaviodev.dp.builder.TituloCobrancaBuilder;
import com.github.flaviodev.dp.model.TituloCobranca;
import com.github.flaviodev.dp.model.registros.base.Detalhe;

public class DetalheRemessaEmail extends Detalhe {

	private Logger logger = Logger.getLogger(DetalheRemessaEmail.class);

	public DetalheRemessaEmail(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}

	@Override
	public TituloCobranca processaRegistroArquivo() {
		String registro = getRegistroDoArquivo();
		
		TituloCobrancaBuilder builder = getBuilderRegistro().populaRegistro(processaDetalheVinculado());

		builder.doSacado(new SacadoBuilder().comEmail(registro.substring(2, 152).trim()).constroi());

		TituloCobranca titulo = builder.constroi();

		logger.info(titulo);

		return titulo;
	}

}
