package com.github.flaviodev.refactoring.factory;

import com.github.flaviodev.refactoring.model.registros.remessa.CabecalhoRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaEmail;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaMulta;
import com.github.flaviodev.refactoring.model.registros.remessa.bancodobrasil.CabecalhoRemessaBancoDoBrasil;
import com.github.flaviodev.refactoring.model.registros.remessa.bancodobrasil.DetalheRemessaBancoDoBrasil;
import com.github.flaviodev.refactoring.model.registros.remessa.bancodobrasil.DetalheRemessaEmailBancoDoBrasil;
import com.github.flaviodev.refactoring.model.registros.remessa.bancodobrasil.DetalheRemessaMultaBancoDoBrasil;

public class RemessaEnvioBancoDoBrasilFactory implements RemessaEnvioFactory {

	@Override
	public CabecalhoRemessa criaCabecalhoRemessa() {
		return new CabecalhoRemessaBancoDoBrasil();
	}

	@Override
	public DetalheRemessa criaDetalheRemessa() {
		return new DetalheRemessaBancoDoBrasil();
	}

	@Override
	public DetalheRemessaEmail criaDetalheRemessaEmail() {
		return new DetalheRemessaEmailBancoDoBrasil();
	}

	@Override
	public DetalheRemessaMulta criaDetalheRemessaMulta() {
		return new DetalheRemessaMultaBancoDoBrasil();
	}

}
