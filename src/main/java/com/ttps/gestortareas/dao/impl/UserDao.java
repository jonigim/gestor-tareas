package com.ttps.gestortareas.dao.impl;

import org.springframework.stereotype.Repository;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.User;

@Repository
public class UserDao extends AbstractDao<User> implements IGenericDAO<User> {
	
	public UserDao() {
		super();
		this.persistenClass = User.class;
	}

}
