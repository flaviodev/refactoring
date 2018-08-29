package com.github.flaviodev.dp.builder;

import java.util.ArrayList;
import java.util.List;

import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;
import com.github.flaviodev.dp.observer.AcaoAposCriarOrcamento;

public class OrcamentoBuilder {

	private String nomeCliente;
	private String nomeVendedor;
	private List<ItemOrcamento> itens;
	private List<AcaoAposCriarOrcamento> acoes;

	public OrcamentoBuilder() {
		
		itens = new ArrayList<>();
		acoes = new ArrayList<>();
	}
	
	public OrcamentoBuilder paraCliente(String nomeCliente) {
		
		this.nomeCliente = nomeCliente;
		return this;
	}
	
	public OrcamentoBuilder doVendedor(String nomeVendedor) {
		
		this.nomeVendedor = nomeVendedor;
		return this;
	}
	
	public OrcamentoBuilder adicionaItem(ItemOrcamento item) {
		
		itens.add(item);
		return this;
	}

	public OrcamentoBuilder adicionaAcao(AcaoAposCriarOrcamento acao) {
		
		acoes.add(acao);
		return this;
	}
	
	public Orcamento constroi() {
		
		Orcamento orcamento = new Orcamento();
		orcamento.setNomeCliente(nomeCliente);
		orcamento.setNomeVendedor(nomeVendedor);
		orcamento.setItens(itens);
		
		acoes.forEach(acao -> acao.executa(orcamento));
		
		return orcamento;
	}
	
	
}
