package com.ttps.gestortareas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.User;
import com.ttps.gestortareas.service.UserService;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private IGenericDAO<User> userDao;
	
	@Override
	public User createUser(User user) {
		return userDao.persist(user);
	}
	
	@Override
	public String authenticateUser(String user, String password) {
		return null;
	}
	
	@Override
	public User getUserById(long userId) {
		return userDao.findById(userId);
	}
	
	@Override
	public void updateUser(long userId, User user) {
		User userDb = userDao.findById(userId);
		if (user != null) {
			userDb.setName(user.getName());
			userDb.setEmail(user.getEmail());
			userDb.setPassword(user.getPassword());
			userDao.update(userDb);
		}
	}

}
