package com.ttps.gestortareas.dao;

import com.ttps.gestortareas.dao.impl.AbstractDao;
import com.ttps.gestortareas.domain.TaskList;

public class TaskListDao extends AbstractDao<TaskList> implements IGenericDAO<TaskList> {

	public TaskListDao() {
		super();
		this.persistenClass = TaskList.class;
	}
}
