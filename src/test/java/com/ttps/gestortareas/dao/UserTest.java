package com.ttps.gestortareas.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ttps.gestortareas.dao.impl.UserDao;
import com.ttps.gestortareas.domain.User;

public class UserTest {
	
	private UserDao userDao;
	
	@Before
	public void setUp() throws Exception {
		this.userDao = DaoFactory.getUserDao();
	}

	@Test
	public void testCreateUser() throws Exception {
		User user = new User("user", "p@wssw0rd", "Juan Prueba", "test@mail.com");
		userDao.persist(user);
		long id = user.getId();
		assertNotNull(id);
		
		
	}
}
