package com.github.flaviodev.refactoring.tipo;

import com.github.flaviodev.refactoring.factory.RemessaEnvioBancoDoBrasilFactory;
import com.github.flaviodev.refactoring.factory.RemessaEnvioCaixaFactory;
import com.github.flaviodev.refactoring.factory.RemessaEnvioFactory;

public enum Banco {
	BANCO_DO_BRASIL("001", "Banco do Brasil", RemessaEnvioBancoDoBrasilFactory.class), CAIXA_ECONOMICA("104",
			"Caixa Econômica Federal", RemessaEnvioCaixaFactory.class);

	private String numero;
	private String nome;
	private Class<? extends RemessaEnvioFactory> factory;

	private Banco(String numero, String nome, Class<? extends RemessaEnvioFactory> factory) {
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

	public RemessaEnvioFactory getRemessaFactory() {
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
