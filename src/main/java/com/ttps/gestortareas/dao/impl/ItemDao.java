package com.ttps.gestortareas.dao.impl;

public class ItemDao extends AbstractDao<Board> implements IGenericDAO<Board>  {

	public ItemDao() {
		super();
		this.persistenClass = Board.class;
	}
	
}
