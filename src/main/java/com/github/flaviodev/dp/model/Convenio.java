package com.github.flaviodev.dp.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.github.flaviodev.dp.model.base.BaseEntity;
import com.github.flaviodev.dp.tipo.Banco;

@Entity
public class Convenio extends BaseEntity<String> {

	private static final long serialVersionUID = 1598684112407950607L;

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "com.github.flaviodev.dp.model.base.UUIDGenerator")
	@Column(name = "id_convenio", length = 32)
	private String id;

	@Column(nullable = false, length = 10)
	private String numero;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cedente cedente;

	@Enumerated(EnumType.STRING)
	@Basic(fetch = FetchType.LAZY, optional = false)
	@Column(length = 30)
	private Banco banco;

	@Column(nullable = false, length = 5)
	private String agencia;

	@Column(nullable = false, length = 10)
	private String conta;

	@Override
	public String getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cedente getCedente() {
		return cedente;
	}

	public void setCedente(Cedente cedente) {
		this.cedente = cedente;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}