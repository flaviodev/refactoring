package com.github.flaviodev.refactoring.observer;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.github.flaviodev.refactoring.model.Sacado;
import com.github.flaviodev.refactoring.model.TituloCobranca;
import com.github.flaviodev.refactoring.observer.base.EntidadeBaseObserver;

public class PersisteTituloObserver implements EntidadeBaseObserver<String, TituloCobranca> {

	private Logger logger = Logger.getLogger(PersisteTituloObserver.class);

	@Override
	public void executa(TituloCobranca titulo) {

		logger.info("Persistindo título ... ");

		EntityManager em = titulo.getEntityManager();

		em.getTransaction().begin();

		titulo.setSacado(persisteSacado(titulo.getSacado(), em));

		if (titulo.isTransient())
			em.persist(titulo);
		else
			em.merge(titulo);

		em.getTransaction().commit();

		logger.info("Título persistido com sucesso!");
	}

	private Sacado persisteSacado(Sacado sacado, EntityManager em) {

		if (sacado == null)
			return null;

		if (sacado.isTransient())
			em.persist(sacado);
		else
			sacado = em.merge(sacado);

		return sacado;
	}
}
