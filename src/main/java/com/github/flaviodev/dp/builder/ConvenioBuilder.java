package com.github.flaviodev.dp.builder;

import com.github.flaviodev.dp.model.Cedente;
import com.github.flaviodev.dp.model.Convenio;
import com.github.flaviodev.dp.tipo.Banco;

public class ConvenioBuilder implements EntidadeBuilder<String,Convenio> {

	private String numero;
	private Cedente cedente;
	private Banco banco;
	private String agencia;
	private String conta;

	public ConvenioBuilder comNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public ConvenioBuilder paraCedente(Cedente cedente) {
		this.cedente = cedente;
		return this;
	}

	public ConvenioBuilder noBanco(Banco banco) {
		this.banco = banco;
		return this;
	}

	public ConvenioBuilder naAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}

	public ConvenioBuilder paraConta(String conta) {
		this.conta = conta;
		return this;
	}

	@Override
	public Convenio constroi() {

		Convenio convenio = new Convenio();
		convenio.setAgencia(agencia);
		convenio.setBanco(banco);
		convenio.setCedente(cedente);
		convenio.setConta(conta);
		convenio.setNumero(numero);

		return convenio;
	}
}
