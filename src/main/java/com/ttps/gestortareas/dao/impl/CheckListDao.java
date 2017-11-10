package com.ttps.gestortareas.dao.impl;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.CheckList;

public class CheckListDao extends AbstractDao<CheckList> implements IGenericDAO<CheckList> {
	
	public CheckListDao() {
		super();
		this.persistenClass = CheckList.class;
	}

}
