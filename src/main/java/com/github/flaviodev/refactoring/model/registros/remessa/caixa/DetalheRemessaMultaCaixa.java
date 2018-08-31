package com.github.flaviodev.refactoring.model.registros.remessa.caixa;

import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaMulta;

public class DetalheRemessaMultaCaixa extends DetalheRemessaMulta {

	public DetalheRemessaMultaCaixa() {
	}
	
	public DetalheRemessaMultaCaixa(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}
}
