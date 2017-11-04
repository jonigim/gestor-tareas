package com.ttps.gestortareas.dao.impl;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Board;

public class BoardDao extends AbstractDao<Board> implements IGenericDAO<Board> {
	
	public BoardDao() {
		super();
		this.persistenClass = Board.class;
	}

}
