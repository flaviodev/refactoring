package com.github.flaviodev.refactoring.factory;

import com.github.flaviodev.refactoring.model.registros.remessa.CabecalhoRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaEmail;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaMulta;

public interface RemessaFactory {
	CabecalhoRemessa criaCabecalhoRemessa();

	DetalheRemessa criaDetalheRemessa();

	DetalheRemessaEmail criaDetalheRemessaEmail();

	DetalheRemessaMulta criaDetalheRemessaMulta();
}
