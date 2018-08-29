package com.github.flaviodev.dp.model;

public class ItemOrcamento {

	private double valor;
	private String descricao;
	private double quantidade;

	public ItemOrcamento(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public ItemOrcamento setValor(double valor) {
		this.valor = valor;
		return this;
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

	public ItemOrcamento setQuantidade(double quantidade) {
		this.quantidade = quantidade;
		return this;
	}

	public double getTotalItem() {
		return valor * quantidade;
	}

}
