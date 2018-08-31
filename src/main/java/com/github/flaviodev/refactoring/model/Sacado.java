package com.github.flaviodev.refactoring.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Sacado extends Pessoa {

	private static final long serialVersionUID = 1285684112407950607L;

	@Column(length = 150)
	private String email;

	public Sacado() {

	}

	public Sacado(String nomeRazaoSocial, String cpfCnpj, String email) {
		super(nomeRazaoSocial, cpfCnpj);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return String.format("Sacado [id=%s, nomeRazaoSocial=%s, cpfCnpj=%s, email=%s]", getId(), getNomeRazaoSocial(),
				getCpfCnpj(), email);
	}

}
