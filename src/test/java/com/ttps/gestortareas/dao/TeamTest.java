package com.ttps.gestortareas.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ttps.gestortareas.domain.Team;
import com.ttps.gestortareas.domain.User;


public class TeamTest {
	
	private IGenericDAO<Team> teamDao;
	private IGenericDAO<User> userDao;
	private User userDb;
	private Team teamDb;
	
	
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-ctx.xml");
		this.teamDao = (IGenericDAO<Team>) ctx.getBean("teamDao");
		this.userDao = (IGenericDAO<User>) ctx.getBean("userDao");
		this.userDb = userDao.persist(this.createUser("user1", "probando juan"));
		this.teamDb = new Team("Team1", null, userDb);
	}
	
	@After
    public void tearDown() throws IOException {
		if (teamDb != null) {
        	teamDao.remove(teamDb);
        }
        userDao.remove(userDb);
        
    }
	

	@Test
	public void testCreateTeam() throws Exception {
		
		List<User> users = userDao.findAll();
		User user = users.get(0);
		
		Team team = new Team("Team1", null, user);
		teamDao.persist(team);
		
		long id = team.getId();
		assertNotNull(id);
		assertEquals(0, team.getMembers().size());
		teamDao.remove(team);
	}
	
	
	@Test
	public void testAddMembers() {
		User user = this.createUser("testteam", "Pedro");
		List<Team> teams = teamDao.findAll();
		Team team = teams.get(0);
		userDao.persist(user);
		team = teamDao.findById(team.getId());
		int sizeMembers = team.getMembers().size();
		team.getMembers().add(user);
		teamDao.update(team);
		assertEquals(sizeMembers+1,team.getMembers().size());
		team.getMembers().remove(user);
		teamDao.update(team);
		userDao.remove(user);
	}
	
	private User createUser(String userName, String name) {
		return new User(userName, "p@wssw0rd", name, "test@mail.com");
	}
}
