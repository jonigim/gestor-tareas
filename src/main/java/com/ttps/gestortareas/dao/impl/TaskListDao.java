package com.ttps.gestortareas.dao.impl;

import org.springframework.stereotype.Repository;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.TaskList;

@Repository
public class TaskListDao extends AbstractDao<TaskList> implements IGenericDAO<TaskList> {

	public TaskListDao() {
		super();
		this.persistenClass = TaskList.class;
	}
}
