package com.github.flaviodev.dp.model.registros;

import com.github.flaviodev.dp.builder.TituloCobrancaBuilder;
import com.github.flaviodev.dp.model.TituloCobranca;
import com.github.flaviodev.dp.model.registros.base.Detalhe;

public class DetalheRemessaMulta extends Detalhe {

	public DetalheRemessaMulta(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}

	@Override
	public TituloCobranca processaRegistroArquivo() {
		TituloCobrancaBuilder builder = getBuilderRegistro().populaRegistro(processaDetalheVinculado());

		return builder.constroi();
	}

}
