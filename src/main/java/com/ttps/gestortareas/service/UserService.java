package com.ttps.gestortareas.service;

import com.ttps.gestortareas.domain.User;
import com.ttps.gestortareas.exception.AuthenticationException;

public interface UserService {
	
	public User createUser(User user);
	public String authenticateUser(String user, String password) throws AuthenticationException;
	public User getUserById(long userId);
	public void updateUser(long userId, User user);

}
