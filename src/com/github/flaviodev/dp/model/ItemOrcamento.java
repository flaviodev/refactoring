package com.github.flaviodev.dp.model;

public class ItemOrcamento {

	private double valor;
	private String descricao;
	private double quantidade;

	public ItemOrcamento(String descricao, double valor, double quantidade) {
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
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

	public double getTotalItem() {
		return valor * quantidade;
	}

}
