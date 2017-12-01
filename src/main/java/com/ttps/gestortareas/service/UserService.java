package com.ttps.gestortareas.service;

import com.ttps.gestortareas.domain.User;

public interface UserService {
	
	public User createUser(User user);
	public String authenticateUser(String user, String password);
	public User getUserById(long userId);
	public void updateUser(long userId, User user);

}
