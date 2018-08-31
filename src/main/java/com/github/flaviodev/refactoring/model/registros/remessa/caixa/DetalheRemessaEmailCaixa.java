package com.github.flaviodev.refactoring.model.registros.remessa.caixa;

import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaEmail;

public class DetalheRemessaEmailCaixa extends DetalheRemessaEmail {

	public DetalheRemessaEmailCaixa() {
	}
	
	public DetalheRemessaEmailCaixa(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}
}
