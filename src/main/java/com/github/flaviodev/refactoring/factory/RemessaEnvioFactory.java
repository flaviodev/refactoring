package com.github.flaviodev.refactoring.factory;

import com.github.flaviodev.refactoring.model.registros.base.Registro;
import com.github.flaviodev.refactoring.model.registros.remessa.CabecalhoRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaEmail;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaMulta;
import com.github.flaviodev.refactoring.tipo.TipoRegistro;

public interface RemessaEnvioFactory {
	public abstract CabecalhoRemessa criaCabecalhoRemessa();

	public abstract DetalheRemessa criaDetalheRemessa();

	public abstract DetalheRemessaEmail criaDetalheRemessaEmail();

	public abstract DetalheRemessaMulta criaDetalheRemessaMulta();

	@SuppressWarnings("rawtypes")
	default Registro criaConformeOTipo(TipoRegistro tipo) {
		switch (tipo) {
		case CABECALHO_REMESSA:
			return criaCabecalhoRemessa();

		case DETALHE_REMESSA:
			return criaDetalheRemessa();

		case DETALHE_REMESSA_DADOS_MULTA:
			return criaDetalheRemessaMulta();

		case DETALHE_REMESSA_EMAIL_SACADO:
			return criaDetalheRemessaEmail();

		default:
			throw new IllegalArgumentException("Tipo de Registro não tratado");
		}

	}
}
