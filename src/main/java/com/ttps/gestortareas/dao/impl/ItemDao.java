package com.ttps.gestortareas.dao.impl;

import org.springframework.stereotype.Repository;

import com.ttps.gestortareas.dao.IGenericDAO;
import com.ttps.gestortareas.domain.Item;

@Repository
public class ItemDao extends AbstractDao<Item> implements IGenericDAO<Item>  {

	public ItemDao() {
		super();
		this.persistenClass = Item.class;
	}
	
}
