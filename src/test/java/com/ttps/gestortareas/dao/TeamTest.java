package com.ttps.gestortareas.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ttps.gestortareas.dao.impl.TeamDao;
import com.ttps.gestortareas.dao.impl.UserDao;
import com.ttps.gestortareas.domain.Team;
import com.ttps.gestortareas.domain.User;


public class TeamTest {
	
	private TeamDao teamDao;
	private UserDao userDao;
	
	
	@Before
	public void setUp() throws Exception {
		this.teamDao = DaoFactory.getTeamDao();
		this.userDao = DaoFactory.getUserDao();
		userDao.persist(this.createUser("user1", "probando juan"));
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
	}
	
	
	@Test
	public void testAddMembers() {
		User user = this.createUser("testteam", "Pedro");
		Team team = teamDao.findAll().get(0);
		userDao.persist(user);
		int sizeMembers = team.getMembers().size();
		team.getMembers().add(user);
		teamDao.update(team);
		assertEquals(sizeMembers+1,team.getMembers().size());
	}
	
	private User createUser(String userName, String name) {
		return new User(userName, "p@wssw0rd", name, "test@mail.com");
	}
}
