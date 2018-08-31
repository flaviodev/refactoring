package com.github.flaviodev.refactoring.builder;

import java.util.ArrayList;
import java.util.List;

import com.github.flaviodev.refactoring.model.ItemOrcamento;
import com.github.flaviodev.refactoring.model.Orcamento;
import com.github.flaviodev.refactoring.model.Sacado;
import com.github.flaviodev.refactoring.observer.ConstroiOrcamentoObserver;

public class OrcamentoBuilder {

	private Sacado cliente;
	private List<ItemOrcamento> itens;
	private List<ConstroiOrcamentoObserver> acoes;

	public OrcamentoBuilder() {

		itens = new ArrayList<>();
		acoes = new ArrayList<>();
	}

	public OrcamentoBuilder paraCliente(Sacado cliente) {

		this.cliente = cliente;
		return this;
	}

	public OrcamentoBuilder adicionaItem(ItemOrcamento item) {

		itens.add(item);
		return this;
	}

	public OrcamentoBuilder adicionaAcao(ConstroiOrcamentoObserver acao) {

		acoes.add(acao);
		return this;
	}

	public List<ConstroiOrcamentoObserver> getAcoes() {
		return acoes;
	}

	public Orcamento constroi() {

		Orcamento orcamento = new Orcamento();
		orcamento.setCliente(cliente);
		orcamento.setItens(itens);

		acoes.forEach(acao -> acao.executa(orcamento));

		return orcamento;
	}
}
