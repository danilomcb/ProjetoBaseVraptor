package br.com.projetobase.arq.dao.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.projetobase.arq.dao.Dao;
import br.com.projetobase.arq.dominio.AbstractEntity;

public abstract class HibernateDao<T extends AbstractEntity> implements Dao<T> {

	@Inject
	protected EntityManager session;
	
	protected Class<T> clazz;
	
	public HibernateDao() {
		Class<T> clazz = inferGenericType();
		this.clazz = clazz;
	}
	
	@Override
	public T save(T entity) {
		session.persist(entity);
		return entity;
	}

	@Override
	public T find(Long id) {
		return (T) session.find(clazz, id);
	}

	@Override
	public Collection<T> all() {
		return null;
	} 
	
	public void remove(T entity) {
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> inferGenericType() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
