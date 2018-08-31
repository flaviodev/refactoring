package com.github.flaviodev.refactoring.model.registros.remessa;

import com.github.flaviodev.refactoring.builder.SacadoBuilder;
import com.github.flaviodev.refactoring.builder.TituloCobrancaBuilder;
import com.github.flaviodev.refactoring.model.Remessa;
import com.github.flaviodev.refactoring.model.TituloCobranca;
import com.github.flaviodev.refactoring.model.registros.base.Detalhe;
import com.github.flaviodev.refactoring.observer.PersisteTituloObserver;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;

public class DetalheRemessa extends Detalhe {

	public DetalheRemessa(String registroDoArquivo, Remessa remessa) {
		super(registroDoArquivo);
		getBuilderRegistro().naRemessa(remessa);
		getBuilderRegistro().adicionaAcaoAoConstruir(new PersisteTituloObserver());
	}

	public DetalheRemessa(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
		getBuilderRegistro().adicionaAcaoAoConstruir(new PersisteTituloObserver());
	}


	@Override
	public TipoRegistro getTipo() {
		return TipoRegistro.DETALHE_REMESSA;
	}

	@Override
	public TituloCobranca processaRegistroArquivo() {

		String registro = getRegistroDoArquivo();

		TituloCobrancaBuilder builder = getBuilderRegistro().comNumero(registro.substring(2, 12).trim())
				.doSacado(new SacadoBuilder().comNomeRazaoSocial(registro.substring(12, 104).trim())
						.comCpfCnpj(registro.substring(104, 118)).constroi())
				.comVencimento(toDate(registro.substring(118, 126)))
				.comValor(toBigDecimal(registro.substring(126, 136)));

		return processaRegistroVinculado(builder.constroi());
	}

}
