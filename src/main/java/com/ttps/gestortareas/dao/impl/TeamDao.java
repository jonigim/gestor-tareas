package com.ttps.gestortareas.dao.impl;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Team;

public class TeamDao extends AbstractDao<Team> implements IGenericDAO<Team> {

	public TeamDao() {
		super();
		this.persistenClass = Team.class;
	}
}
