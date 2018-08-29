package com.github.flaviodev.dp.model;

import java.util.ArrayList;
import java.util.List;

public class Orcamento {

	private String nomeCliente;
	private String nomeVendedor;
	private List<ItemOrcamento> itens;

	public Orcamento() {

		itens = new ArrayList<>();
	}

	public String getNomeCliente() {
		
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		
		this.nomeCliente = nomeCliente;
	}

	public String getNomeVendedor() {
		
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		
		this.nomeVendedor = nomeVendedor;
	}

	public List<ItemOrcamento> getItens() {
		
		return itens;
	}

	public void adicionaItem(ItemOrcamento item) {
		
		getItens().add(item);
	}
	
	protected void setItens(List<ItemOrcamento> itens) {
		
		this.itens = itens;
	}

	public double getValorTotal() {
		
		return getItens().stream().mapToDouble(ItemOrcamento::getTotalItem).sum();
	}
}
