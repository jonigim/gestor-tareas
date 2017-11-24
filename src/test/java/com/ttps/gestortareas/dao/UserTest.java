package com.ttps.gestortareas.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ttps.gestortareas.domain.User;

public class UserTest {
	
	private IGenericDAO<User> userDao;
	private User userDb;
	
	
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app-ctx.xml");
		this.userDao = (IGenericDAO<User>) ctx.getBean("userDao");
		this.userDb = null;
	}
	
	@After
    public void tearDown() throws IOException {
        if (userDb !=null) {
        	userDao.remove(userDb);
        }
    }
	

	@Test
	public void testCreateUser() throws Exception {
		User user = this.createUser("juanprueba", "Juan Prueba");
		userDao.persist(user);
		long id = user.getId();
		assertNotNull(id);
		userDb = userDao.findById(id);
		assertEquals(userDb.getName(),"Juan Prueba");
	}
	
	@Test
	public void testDeleteUser() throws Exception{
		User user = this.createUser("AeLIMINAR", "Juan delete");
		userDao.persist(user);
		long id = user.getId();
		List<User> users = userDao.findAll();
		int cantUsers = users.size();
		
		User userToRemove = userDao.findById(id);
		userDao.remove(userToRemove);
		users = userDao.findAll();
		assertEquals(cantUsers-1, users.size());
	}
	
	@Test
	public void testUpdateUser() throws Exception{
		String oldName = "juanito";
		User user = this.createUser("usertoModify", oldName);
		userDao.persist(user);
		String newName = "Juanito Crecio";
		
		user.setName(newName);
		userDao.update(user);
		
		userDb = userDao.findById(user.getId());
		assertEquals(newName, userDb.getName());
	}
	
	
	private User createUser(String userName, String name) {
		return new User(userName, "p@wssw0rd", name, "test@mail.com");
	}
	
}
