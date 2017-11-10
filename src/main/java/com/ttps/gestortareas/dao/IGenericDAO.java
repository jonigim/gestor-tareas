package com.ttps.gestortareas.dao;

import java.util.List;

public interface IGenericDAO<T> {

	 T findById(Long id);

	 List<T> findAll();

	 long countAll();

	 T persist(T entity);
	 
	 void remove(T entity);
	 
	 void removeById(long id);

	 void removeAll();
	 
	 void update(T entity);
}
