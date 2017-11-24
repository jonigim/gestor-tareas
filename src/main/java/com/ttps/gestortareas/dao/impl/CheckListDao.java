package com.ttps.gestortareas.dao.impl;

import org.springframework.stereotype.Repository;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.CheckList;

@Repository
public class CheckListDao extends AbstractDao<CheckList> implements IGenericDAO<CheckList> {
	
	public CheckListDao() {
		super();
		this.persistenClass = CheckList.class;
	}

}
