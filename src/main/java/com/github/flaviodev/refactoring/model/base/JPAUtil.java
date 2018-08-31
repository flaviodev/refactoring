package com.github.flaviodev.refactoring.model.base;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;

public enum JPAUtil {

	INSTANCE;

	private EntityManagerFactory factory;

	private JPAUtil() {

		this.factory = Persistence.createEntityManagerFactory("dpPu");
	}

	public EntityManager getEntityManager() {

		return this.factory.createEntityManager();
	}

	public static <I extends Serializable, E extends EntidadeBase<I>> Criteria createCriteria(Class<E> classeEntidade,
			String alias) {

		return ((Session) INSTANCE.getEntityManager().getDelegate()).createCriteria(classeEntidade, alias);
	}

	public static <I extends Serializable, E extends EntidadeBase<I>> Criteria createCriteria(Class<E> classeEntidade) {

		return ((Session) INSTANCE.getEntityManager().getDelegate()).createCriteria(classeEntidade);
	}

	public static String getAlias(String... aliases) {

		if (aliases == null || aliases.length == 0)
			throw new IllegalArgumentException("Valores para montagem do alias não pode ser nula ou vazia");

		StringBuilder aliasesContatenados = new StringBuilder(aliases[0]);
		boolean primeiro = true;

		for (String alias : aliases) {

			if (primeiro) {

				primeiro = false;
			} else {

				aliasesContatenados.append('.');
				aliasesContatenados.append(alias);
			}
		}

		return aliasesContatenados.toString();
	}
}
