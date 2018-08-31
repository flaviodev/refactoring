package com.github.flaviodev.refactoring.tipo;

import com.github.flaviodev.refactoring.factory.RemessaBancoDoBrasilFactory;
import com.github.flaviodev.refactoring.factory.RemessaCaixaFactory;
import com.github.flaviodev.refactoring.factory.RemessaFactory;

public enum Banco {
	BANCO_DO_BRASIL("001", "Banco do Brasil", RemessaBancoDoBrasilFactory.class), CAIXA_ECONOMICA("104",
			"Caixa Econômica Federal", RemessaCaixaFactory.class);

	private String numero;
	private String nome;
	private Class<? extends RemessaFactory> factory;

	private Banco(String numero, String nome, Class<? extends RemessaFactory> factory) {
		this.numero = numero;
		this.nome = nome;
		this.factory = factory;
	}

	public String getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public RemessaFactory getRemessaFactory() {
		try {
			return factory.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}

	public static Banco getPeloNumero(String numero) {
		for (Banco banco : Banco.values()) {
			if (banco.getNumero().equals(numero))
				return banco;
		}

		return null;
	}

}
