package com.ttps.gestortareas.domain;

import java.util.List;

public class CheckList {
	
	private Long id;
	private List<Item> items;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

}
