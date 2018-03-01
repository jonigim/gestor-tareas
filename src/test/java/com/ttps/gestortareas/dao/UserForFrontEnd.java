package com.ttps.gestortareas.dao;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ttps.gestortareas.domain.Board;
import com.ttps.gestortareas.domain.User;

public class UserForFrontEnd {
	
	private IGenericDAO<User> userDao;
	private IGenericDAO<Board> boardDao;
	private User userDb;
	
	
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-ctx.xml");
		this.userDao = (IGenericDAO<User>) ctx.getBean("userDao");
		this.boardDao = (IGenericDAO<Board>) ctx.getBean("boardDao");
	}
	
	@After
    public void tearDown() throws IOException {

	}
	

	@Test
	public void testCreateUser() throws Exception {
		User user = this.createUser("juanprueba", "Juan Prueba");
		Board board1 = this.createBoard("Entrega 6", user);
		userDao.persist(user);;
		boardDao.persist(board1);
		List<Board> boards = new ArrayList<>();
		boards.add(board1);
		user.setBoards(boards);
		userDao.update(user);
	}
	
	
	private User createUser(String userName, String name) {
		return new User(userName, "p@wssw0rd", name, "test@mail.com");
	}
	
	private Board createBoard(String name, User user) {
		Date finishDate = new Date(2018,03,01);
		Date startDate = new Date(2017,07,01);
		return new Board(name, startDate, finishDate,new ArrayList<>(),new ArrayList<>(), user);
	}
	
}
