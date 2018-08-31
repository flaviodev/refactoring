package com.github.flaviodev.refactoring.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.github.flaviodev.refactoring.model.base.EntidadeBase;

@MappedSuperclass
public abstract class Pessoa extends EntidadeBase<String> {

	private static final long serialVersionUID = 6548447923572856584L;

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "com.github.flaviodev.dp.model.base.UUIDGenerator")
	@Column(name = "id_pessoa", length = 32)
	private String id;

	@Basic(optional = false)
	@Column(length = 70)
	private String nomeRazaoSocial;

	@Basic(fetch = FetchType.LAZY, optional = false)
	@Column(length = 14)
	private String cpfCnpj;

	public Pessoa() {

	}

	public Pessoa(String nomeRazaoSocial, String cpfCnpj) {
		super();
		this.nomeRazaoSocial = nomeRazaoSocial;
		this.cpfCnpj = cpfCnpj;
	}

	@Override
	public String getId() {

		return id;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}

	public void setNomeRazaoSocial(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}

	@Override
	public int hashCode() {

		return super.hashCode();
	}

	@Override
	public String toString() {
		return String.format("Pessoa [id=%s, nomeRazaoSocial=%s, cpfCnpj=%s]", id, nomeRazaoSocial, cpfCnpj);
	}

}