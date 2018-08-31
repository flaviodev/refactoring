package com.github.flaviodev.refactoring.model.registros.remessa.bancodobrasil;

import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessaEmail;

public class DetalheRemessaEmailBancoDoBrasil extends DetalheRemessaEmail {

	public DetalheRemessaEmailBancoDoBrasil() {
	}
	
	public DetalheRemessaEmailBancoDoBrasil(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}
}
