package com.github.flaviodev.refactoring.factory;

import com.github.flaviodev.refactoring.model.registros.remessa.CabecalhoRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaEmail;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaMulta;
import com.github.flaviodev.refactoring.model.registros.remessa.caixa.CabecalhoRemessaCaixa;
import com.github.flaviodev.refactoring.model.registros.remessa.caixa.DetalheRemessaCaixa;
import com.github.flaviodev.refactoring.model.registros.remessa.caixa.DetalheRemessaEmailCaixa;
import com.github.flaviodev.refactoring.model.registros.remessa.caixa.DetalheRemessaMultaCaixa;

public class RemessaCaixaFactory implements RemessaFactory {

	@Override
	public CabecalhoRemessa criaCabecalhoRemessa() {
		return new CabecalhoRemessaCaixa();
	}

	@Override
	public DetalheRemessa criaDetalheRemessa() {
		return new DetalheRemessaCaixa();
	}

	@Override
	public DetalheRemessaEmail criaDetalheRemessaEmail() {
		return new DetalheRemessaEmailCaixa();
	}

	@Override
	public DetalheRemessaMulta criaDetalheRemessaMulta() {
		return new DetalheRemessaMultaCaixa();
	}

}
