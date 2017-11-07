package com.ttps.gestortareas.dao.impl;

public class TaskDao extends AbstractDao<Board> implements IGenericDAO<Board> {
	
	public TaskDao() {
		super();
		this.persistenClass = Board.class;
	}
	
}
