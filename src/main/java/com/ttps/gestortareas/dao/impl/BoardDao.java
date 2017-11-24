package com.ttps.gestortareas.dao.impl;

import org.springframework.stereotype.Repository;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Board;

@Repository
public class BoardDao extends AbstractDao<Board> implements IGenericDAO<Board> {
	
	public BoardDao() {
		super();
		this.persistenClass = Board.class;
	}

}
