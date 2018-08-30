package com.github.flaviodev.dp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.github.flaviodev.dp.model.base.BaseEntity;

@Entity
public class Cliente extends BaseEntity<String> {

	private static final long serialVersionUID = 2567684112407950607L;

	public static class Atributos {
		private Atributos() {
		}

		public static final String ID = "id";
		public static final String NOME_CLIENTE = "nomeCliente";
		public static final String ITENS = "itens";
	}

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "com.github.flaviodev.dp.model.base.UUIDGenerator")
	@Column(name = "id_cliente", length = 32)
	private String id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 20)
	private String cpf;

	@Column(nullable = false, length = 150)
	private String email;

	public Cliente() {

	}

	public Cliente(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	@Override
	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
}
