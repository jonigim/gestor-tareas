package com.ttps.gestortareas.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ttps.gestortareas.dao.IGenericDAO;

@Transactional
@Repository
public abstract class AbstractDao<T> implements IGenericDAO<T> {

	protected Class<T> persistenClass;

	public final void setClazz(Class<T> clazzToSet) {
		this.persistenClass = clazzToSet;
	}
	
	@PersistenceContext
	private EntityManager entityManger;

	public EntityManager getEntityManger() {
		return entityManger;
	}
	
	public void setEntityManger(EntityManager entityManger) {
		this.entityManger = entityManger;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return this.getEntityManger().createQuery("from " + persistenClass.getName()).getResultList();
	}
	
	@Override
	public long countAll() {
		return this.findAll().size();
	}

	@Override
	public T persist(T entity) {
		this.getEntityManger().persist(entity);
		return entity;
	}

	@Override
	public void remove(T entity) {
		this.getEntityManger().remove(this.getEntityManger().merge(entity));
	}

	@Override
	public void removeById(long id) {
		T entity = this.findById(id);
		this.remove(entity);

	}

	@Override
	public void removeAll() {
		List<T> entityList = this.findAll();
		for (T entity : entityList) {
			this.remove(entity);
		}
	}

	@Override
	public T findById(Long id) {
		return this.getEntityManger().find(persistenClass, id);
	}
	
	@Override
	public void update(T entity) {
		this.getEntityManger().merge(entity);
	}

}
