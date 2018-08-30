package com.github.flaviodev.dp.model.base;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity<I extends Serializable> implements Serializable {

	private static final long serialVersionUID = 7373447920782854276L;

	@Version
	private Integer version;

	public abstract I getId();

	public Integer getVersion() {
		return version;
	}

	public boolean isTransient() {
		return getId() == null;
	}

	public EntityManager getDao() {

		return JPAUtil.INSTANCE.getEntityManager();
	}

	@SuppressWarnings("unchecked")
	public <E extends BaseEntity<I>> E persiste() {

		if (!isTransient())
			throw new IllegalStateException("Entidade já persistida");

		EntityManager dao = getDao();
		dao.getTransaction().begin();
		dao.persist(this);
		dao.getTransaction().commit();
		dao.close();

		return (E) this;
	}

	@SuppressWarnings("unchecked")
	public <E extends BaseEntity<I>> E altera() {

		E entidadeAlterada = null;

		if (isTransient())
			throw new IllegalStateException("Entidade não está persistida");

		EntityManager dao = getDao();
		dao.getTransaction().begin();
		entidadeAlterada = (E) dao.merge(this);
		dao.getTransaction().commit();
		dao.close();

		return entidadeAlterada;
	}

	public void exclui() {

		if (isTransient())
			throw new IllegalStateException("Entidade não está persistida");

		EntityManager dao = getDao();
		dao.getTransaction().begin();
		dao.remove(dao.merge(this));
		dao.getTransaction().commit();
		dao.close();
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		@SuppressWarnings("rawtypes")
		BaseEntity other = (BaseEntity) obj;
		if (getId() == null) {

			if (other.getId() != null)
				return false;

		} else if (!getId().equals(other.getId())) {

			return false;
		}

		return true;
	}
}