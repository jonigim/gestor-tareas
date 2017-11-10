package com.ttps.gestortareas.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.utils.EMF;

public abstract class AbstractDao<T> implements IGenericDAO<T> {

	protected Class<T> persistenClass;

	public final void setClazz(Class<T> clazzToSet) {
		this.persistenClass = clazzToSet;
	}
	
	@PersistenceContext(unitName = "up", type = PersistenceContextType.TRANSACTION) 
	private EntityManager entityManger;

	@Override
	public List<T> findAll() {
		EntityManager em = EMF.getEMF().createEntityManager();
		return em.createQuery("from " + persistenClass.getName()).getResultList();
	}

	@Override
	public long countAll() {
		return this.findAll().size();
	}

	@Override
	public T persist(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		//EntityManager em = this.entityManger;
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return entity;
	}

	@Override
	public void remove(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(entity));
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			em.close();
		}
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
		EntityManager em = EMF.getEMF().createEntityManager();
		return em.find(persistenClass, id);
	}
	
	@Override
	public void update(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		
	}

}
