package com.ttps.gestortareas.dao.impl;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Task;

public class TaskDao extends AbstractDao<Task> implements IGenericDAO<Task> {
	
	public TaskDao() {
		super();
		this.persistenClass = Task.class;
	}
	
}
