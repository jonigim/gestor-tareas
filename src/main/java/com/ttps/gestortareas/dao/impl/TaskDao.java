package com.ttps.gestortareas.dao.impl;

import org.springframework.stereotype.Repository;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Task;

@Repository
public class TaskDao extends AbstractDao<Task> implements IGenericDAO<Task> {
	
	public TaskDao() {
		super();
		this.persistenClass = Task.class;
	}
	
}
