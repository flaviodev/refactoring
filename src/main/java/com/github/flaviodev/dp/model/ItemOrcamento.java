package com.github.flaviodev.dp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.github.flaviodev.dp.model.base.BaseEntity;

@Entity
public class ItemOrcamento extends BaseEntity<String> {

	private static final long serialVersionUID = 5174263295854186259L;

	public static class Atributos {
		private Atributos() {
		}

		public static final String ID = "id";
		public static final String VALOR = "valor";
		public static final String DESCRICAO = "descricao";
		public static final String QUANTIDADE = "quantidade";
		public static final String ORCAMENTO = "orcamento";
	}

	@Id
	@GeneratedValue(generator = "UUIDGenerator")
	@GenericGenerator(name = "UUIDGenerator", strategy = "com.github.flaviodev.dp.model.base.UUIDGenerator")
	@Column(name = "id_orcamento", length = 32)
	private String id;

	@Column(nullable = false)
	private double valor;

	@Column(nullable = false, length = 100)
	private String descricao;

	@Column(nullable = false)
	private double quantidade;

	@ManyToOne(fetch = FetchType.LAZY)
	private Orcamento orcamento;

	public ItemOrcamento() {

	}

	public ItemOrcamento(String descricao, double valor, double quantidade) {
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	@Override
	public String getId() {
		return id;
	}

	public double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	@Transient
	public double getTotalItem() {
		return valor * quantidade;
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
