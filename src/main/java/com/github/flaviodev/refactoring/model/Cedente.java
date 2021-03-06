package com.github.flaviodev.refactoring.model;

import javax.persistence.Entity;

@Entity
public class Cedente extends Pessoa {

	private static final long serialVersionUID = 2567684112407950607L;

	public Cedente() {

	}

	public Cedente(String nomeRazaoSocial, String cpfCnpj) {
		super(nomeRazaoSocial, cpfCnpj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return String.format("Cedente [id=%s, nomeRazaoSocial=%s, cpfCnpj=%s]", getId(), getNomeRazaoSocial(),
				getCpfCnpj());
	}

}
