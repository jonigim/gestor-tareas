package com.ttps.gestortareas.dao.impl;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.User;

public class UserDao extends AbstractDao<User> implements IGenericDAO<User> {
	
	public UserDao() {
		super();
		this.persistenClass = User.class;
	}

}
