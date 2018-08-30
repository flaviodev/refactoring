package com.github.flaviodev.dp.tipo;

public enum Banco {
	BANCO_DO_BRASIL("001", "Banco do Brasil"), 
	CAIXA_ECONOMICA("104", "Caixa Econômica Federal");
	
	private String numero;
	private String nome;
	
	private Banco(String numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}
	
}
