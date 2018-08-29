package com.github.flaviodev.dp.builder;

import java.util.ArrayList;
import java.util.List;

import com.github.flaviodev.dp.model.ItemOrcamento;
import com.github.flaviodev.dp.model.Orcamento;
import com.github.flaviodev.dp.observer.AcaoAposCriarOrcamento;

public class OrcamentoBuilder {

	private Orcamento orcamento;
	private List<AcaoAposCriarOrcamento> acoes;

	public OrcamentoBuilder() {
		
		orcamento = new Orcamento();
		acoes = new ArrayList<>();
	}
	
	public OrcamentoBuilder paraCliente(String nomeCliente) {
		
		orcamento.setNomeCliente(nomeCliente);
		return this;
	}
	
	public OrcamentoBuilder doVendedor(String nomeVendedor) {
		
		orcamento.setNomeVendedor(nomeVendedor);
		return this;
	}
	
	public OrcamentoBuilder adicionaItem(ItemOrcamento item) {
		
		orcamento.adicionaItem(item);
		return this;
	}
	
	public List<AcaoAposCriarOrcamento> getAcoes() {
		
		return acoes;
	}

	protected void setAcoes(List<AcaoAposCriarOrcamento> acoes) {
		
		this.acoes = acoes;
	}

	public OrcamentoBuilder adicionaAcao(AcaoAposCriarOrcamento acao) {
		
		getAcoes().add(acao);
		return this;
	}
	
	public Orcamento constroi() {
		
		getAcoes().forEach(acao -> acao.executa(orcamento));
		
		return orcamento;
	}
	
	
}
