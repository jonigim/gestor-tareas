package com.ttps.gestortareas.dao.impl;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.TaskList;

public class TaskListDao extends AbstractDao<TaskList> implements IGenericDAO<TaskList> {

	public TaskListDao() {
		super();
		this.persistenClass = TaskList.class;
	}
}
