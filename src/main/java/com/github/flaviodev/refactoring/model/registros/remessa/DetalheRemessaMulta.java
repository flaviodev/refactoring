package com.github.flaviodev.refactoring.model.registros.remessa;

import com.github.flaviodev.refactoring.builder.TituloCobrancaBuilder;
import com.github.flaviodev.refactoring.model.TituloCobranca;
import com.github.flaviodev.refactoring.model.registros.base.Detalhe;
import com.github.flaviodev.refactoring.model.registros.base.Registro;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;

public class DetalheRemessaMulta extends Detalhe {

	public DetalheRemessaMulta() {
	}

	@Override
	public TipoRegistro getTipo() {
		return TipoRegistro.DETALHE_REMESSA_DADOS_MULTA;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public TituloCobranca processaRegistroArquivo(String registroDoArquivo, Registro registroVinculado) {
		setRegistroVinculado(registroVinculado);

		TituloCobrancaBuilder builder = getBuilderRegistro().comMulta(toBigDecimal(registroDoArquivo.substring(2, 12)))
				.comJurosDia(toBigDecimal(registroDoArquivo.substring(12, 22)));

		return processaRegistroVinculado(builder.constroi());
	}

}
