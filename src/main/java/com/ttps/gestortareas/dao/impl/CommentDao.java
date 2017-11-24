package com.ttps.gestortareas.dao.impl;

import org.springframework.stereotype.Repository;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Comment;

@Repository
public class CommentDao extends AbstractDao<Comment> implements IGenericDAO<Comment> {

	
	public CommentDao() {
		super();
		this.persistenClass = Comment.class;
	}
	
}
