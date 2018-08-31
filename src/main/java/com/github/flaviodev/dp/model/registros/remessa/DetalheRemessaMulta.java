package com.github.flaviodev.dp.model.registros.remessa;

import com.github.flaviodev.dp.builder.TituloCobrancaBuilder;
import com.github.flaviodev.dp.model.TituloCobranca;
import com.github.flaviodev.dp.model.registros.base.Detalhe;
import com.github.flaviodev.dp.tipo.TipoRegistro;

public class DetalheRemessaMulta extends Detalhe {

	public DetalheRemessaMulta(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}

	@Override
	public TipoRegistro getTipo() {
		return TipoRegistro.DETALHE_REMESSA_DADOS_MULTA;
	}

	@Override
	public TituloCobranca processaRegistroArquivo() {
		String registro = getRegistroDoArquivo();

		TituloCobrancaBuilder builder = getBuilderRegistro().comMulta(toBigDecimal(registro.substring(2, 12)))
				.comJurosDia(toBigDecimal(registro.substring(12, 22)));

		return processaRegistroVinculado(builder.constroi());
	}

}
