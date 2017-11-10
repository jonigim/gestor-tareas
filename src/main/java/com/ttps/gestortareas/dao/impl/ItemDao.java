package com.ttps.gestortareas.dao.impl;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Item;

public class ItemDao extends AbstractDao<Item> implements IGenericDAO<Item>  {

	public ItemDao() {
		super();
		this.persistenClass = Item.class;
	}
	
}
