package com.ttps.gestortareas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<T> implements GenericDAO<T> {

	 
   @PersistenceContext
   EntityManager entityManager;
   
   private Class< T > clazz;
   
   public final void setClazz( Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
   }
 
   @Override
   public List<T> findAll(){
	      return entityManager.createQuery( "from " + clazz.getName() )
	       .getResultList();
	   }

	@Override
	public long countAll() {
		return this.findAll().size();
	}

	@Override
	public void persist(T entity) {
		 entityManager.persist( entity );
		
	}

	@Override
	public void remove(T entity) {
		entityManager.remove( entity );
		
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
		  return entityManager.find( clazz, id );
	}

}
