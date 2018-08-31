package com.github.flaviodev.refactoring.observer;

import javax.persistence.EntityManager;

import com.github.flaviodev.refactoring.model.Orcamento;

public class PersisteOrcamento implements ConstroiOrcamentoObserver {

	@Override
	public void executa(Orcamento orcamento) {

		System.out.println("Salvando Orçamento ... ");

		EntityManager dao = orcamento.getEntityManager();

		dao.getTransaction().begin();

		if (orcamento.getCliente().isTransient())
			dao.persist(orcamento.getCliente());

		orcamento.getItens().forEach(item -> dao.persist(item));

		dao.persist(orcamento);

		dao.getTransaction().commit();

		System.out.println("Orçamento Salvo! ");
	}

}
