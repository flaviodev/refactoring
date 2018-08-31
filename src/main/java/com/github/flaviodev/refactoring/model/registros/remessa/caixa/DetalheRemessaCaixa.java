package com.github.flaviodev.refactoring.model.registros.remessa.caixa;

import com.github.flaviodev.refactoring.model.Remessa;
import com.github.flaviodev.refactoring.model.registros.remessa.DetalheRemessa;

public class DetalheRemessaCaixa extends DetalheRemessa {

	public DetalheRemessaCaixa() {
		// TODO Auto-generated constructor stub
	}
	
	public DetalheRemessaCaixa(String registroDoArquivo, Remessa remessa) {
		super(registroDoArquivo, remessa);
	}

	public DetalheRemessaCaixa(String registroDoArquivo, DetalheRemessa registroVinculado) {
		super(registroDoArquivo, registroVinculado);
	}

}
