package com.github.flaviodev.refactoring.observer;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.github.flaviodev.refactoring.model.Cedente;
import com.github.flaviodev.refactoring.model.Convenio;
import com.github.flaviodev.refactoring.model.Remessa;
import com.github.flaviodev.refactoring.observer.base.EntidadeBaseObserver;

public class PersisteRemessaObserver implements EntidadeBaseObserver<String, Remessa> {

	private Logger logger = Logger.getLogger(PersisteRemessaObserver.class);

	@Override
	public void executa(Remessa remessa) {

		logger.info("Persistindo remessa ... ");

		EntityManager em = remessa.getEntityManager();

		em.getTransaction().begin();

		persisteConvenio(remessa.getConvenio(), em);

		em.persist(remessa);

		em.getTransaction().commit();

		logger.info("Remessa persistida com sucesso!");
	}

	private void persisteConvenio(Convenio convenio, EntityManager em) {

		if (convenio == null)
			return;

		persisteCedente(convenio.getCedente(), em);

		if (convenio.isTransient())
			em.persist(convenio);
		else
			em.merge(convenio);
	}

	private void persisteCedente(Cedente cedente, EntityManager em) {
		if (cedente == null)
			return;

		if (cedente.isTransient())
			em.persist(cedente);
		else
			em.merge(cedente);
	}

}
