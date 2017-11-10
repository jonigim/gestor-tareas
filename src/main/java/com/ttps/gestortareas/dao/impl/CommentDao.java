package com.ttps.gestortareas.dao.impl;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Comment;

public class CommentDao extends AbstractDao<Comment> implements IGenericDAO<Comment> {

	
	public CommentDao() {
		super();
		this.persistenClass = Comment.class;
	}
	
}
