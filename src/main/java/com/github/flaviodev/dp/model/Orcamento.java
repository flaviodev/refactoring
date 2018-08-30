package com.github.flaviodev.dp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.github.flaviodev.dp.model.base.BaseEntity;

@Entity
public class Orcamento extends BaseEntity<String> {

	private static final long serialVersionUID = -2487684112407950607L;

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
	@Column(name = "id_orcamento", length = 32)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Sacado cliente;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orcamento")
	private List<ItemOrcamento> itens;

	private boolean enviadoPorEmail;

	private boolean impresso;

	@Override
	public String getId() {
		return id;
	}

	public Sacado getCliente() {
		return cliente;
	}

	public void setCliente(Sacado cliente) {
		this.cliente = cliente;
	}

	public List<ItemOrcamento> getItens() {

		if (itens == null)
			itens = new ArrayList<>();

		return itens;
	}

	public void adicionaItem(ItemOrcamento item) {

		getItens().add(item);
	}

	public void setItens(List<ItemOrcamento> itens) {

		this.itens = itens;
	}

	public boolean isEnviadoPorEmail() {
		return enviadoPorEmail;
	}

	public void setEnviadoPorEmail(boolean enviadoPorEmail) {
		this.enviadoPorEmail = enviadoPorEmail;
	}

	public boolean isImpresso() {
		return impresso;
	}

	public void setImpresso(boolean impresso) {
		this.impresso = impresso;
	}

	@Transient
	public double getValorTotal() {

		return getItens().stream().mapToDouble(ItemOrcamento::getTotalItem).sum();
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
