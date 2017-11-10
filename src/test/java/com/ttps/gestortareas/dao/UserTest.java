package com.ttps.gestortareas.dao;

import static org.junit.Assert.assertEquals;
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
		
		User user = this.createUser("juanprueba", "Juan Prueba");
		userDao.persist(user);
		long id = user.getId();
		assertNotNull(id);
		
		User userDB = userDao.findById(id);
		assertEquals(userDB.getName(),"Juan Prueba");
		
	}
	
	
	private User createUser(String userName, String name) {
		return new User(userName, "p@wssw0rd", name, "test@mail.com");
	}
	
}
