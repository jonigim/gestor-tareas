package com.ttps.gestortareas.dao.impl;

import org.springframework.stereotype.Repository;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Team;

@Repository
public class TeamDao extends AbstractDao<Team> implements IGenericDAO<Team> {

	public TeamDao() {
		super();
		this.persistenClass = Team.class;
	}
}
