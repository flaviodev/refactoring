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
	public Remessa executa(Remessa remessa) {

		EntityManager em = remessa.getEntityManager();

		em.getTransaction().begin();

		remessa.setConvenio(persisteConvenio(remessa.getConvenio(), em));

		if (remessa.isTransient())
			em.persist(remessa);
		else
			remessa = em.merge(remessa);

		em.getTransaction().commit();

		logger.info("=====================================================================");
		logger.info("Persistindo Remessa:  " + remessa);
		logger.info("=====================================================================\n\n");

		return remessa;
	}

	private Convenio persisteConvenio(Convenio convenio, EntityManager em) {

		if (convenio == null)
			return null;

		convenio.setCedente(persisteCedente(convenio.getCedente(), em));

		if (convenio.isTransient())
			em.persist(convenio);
		else
			convenio = em.merge(convenio);

		return convenio;
	}

	private Cedente persisteCedente(Cedente cedente, EntityManager em) {
		if (cedente == null)
			return null;

		if (cedente.isTransient())
			em.persist(cedente);
		else
			cedente = em.merge(cedente);

		return cedente;
	}
}
