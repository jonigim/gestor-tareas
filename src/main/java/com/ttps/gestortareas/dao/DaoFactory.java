package com.ttps.gestortareas.dao;

import com.ttps.gestortareas.dao.impl.TeamDao;
import com.ttps.gestortareas.dao.impl.UserDao;

public class DaoFactory {
	
	public static UserDao getUserDao() {
		return new UserDao();
	}
	
	public static TeamDao getTeamDao() {
		return new TeamDao();
	}

}
