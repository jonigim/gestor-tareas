package com.ttps.gestortareas.dao;

import java.util.List;

public interface GenericDAO<T> {

	 T findById(Long id);

	 List<T> findAll();

	 long countAll();

	 void persist(T entity);
	 
	 void remove(T entity);
	 
	 void removeById(long id);

	 void removeAll();
}
