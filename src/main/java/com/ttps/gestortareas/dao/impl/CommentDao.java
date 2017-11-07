package com.ttps.gestortareas.dao.impl;

public class CommentDao extends AbstractDao<Board> implements IGenericDAO<Board> {

	
	public CommentDao() {
		super();
		this.persistenClass = Board.class;
	}
	
}
