package com.github.flaviodev.refactoring.builder;

import com.github.flaviodev.refactoring.model.Sacado;

public class SacadoBuilder implements EntidadeBuilder<String, Sacado> {

	private String nomeRazaoSocial;
	private String cpfCnpj;
	private String email;

	public SacadoBuilder comNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
		return this;
	}

	public SacadoBuilder comCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
		return this;
	}

	public SacadoBuilder comEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public Sacado constroi() {

		Sacado sacado = new Sacado();
		sacado.setNomeRazaoSocial(nomeRazaoSocial);
		sacado.setCpfCnpj(cpfCnpj);
		sacado.setEmail(email);

		return sacado;
	}
}
