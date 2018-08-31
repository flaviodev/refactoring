package com.github.flaviodev.refactoring.model.registros.remessa;

import com.github.flaviodev.refactoring.builder.SacadoBuilder;
import com.github.flaviodev.refactoring.builder.TituloCobrancaBuilder;
import com.github.flaviodev.refactoring.model.TituloCobranca;
import com.github.flaviodev.refactoring.model.registros.base.Detalhe;
import com.github.flaviodev.refactoring.model.registros.base.Registro;
import com.github.flaviodev.refactoring.observer.PersisteTituloObserver;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;

public class DetalheRemessa extends Detalhe {

	public DetalheRemessa() {
		getBuilderRegistro().adicionaAcaoAoConstruir(new PersisteTituloObserver());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setRegistroVinculado(Registro registroVinculado) {
		if (registroVinculado instanceof CabecalhoRemessa)
			getBuilderRegistro().naRemessa(((CabecalhoRemessa) registroVinculado).getRemessa());

	}

	@Override
	public TipoRegistro getTipo() {
		return TipoRegistro.DETALHE_REMESSA;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public TituloCobranca processaRegistroArquivo(String registroDoArquivo, Registro registroVinculado) {
		setRegistroVinculado(registroVinculado);

		TituloCobrancaBuilder builder = getBuilderRegistro().comNumero(registroDoArquivo.substring(2, 12).trim())
				.doSacado(new SacadoBuilder().comNomeRazaoSocial(registroDoArquivo.substring(12, 104).trim())
						.comCpfCnpj(registroDoArquivo.substring(104, 118)).constroi())
				.comVencimento(toDate(registroDoArquivo.substring(118, 126)))
				.comValor(toBigDecimal(registroDoArquivo.substring(126, 136)));

		return processaRegistroVinculado(builder.constroi());
	}

}
