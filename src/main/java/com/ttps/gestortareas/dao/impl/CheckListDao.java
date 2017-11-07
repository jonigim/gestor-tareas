package com.ttps.gestortareas.dao.impl;

public class CheckListDao extends AbstractDao<Board> implements IGenericDAO<Board> {
	
	public CheckListDao() {
		super();
		this.persistenClass = Board.class;
	}

}
