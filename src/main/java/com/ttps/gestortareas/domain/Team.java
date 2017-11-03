package com.ttps.gestortareas.domain;

import java.util.List;

public class Team {

	private Long id;
	private String name;
	private List<User> members;
	private User owner;
	
	public Team(String name, List<User> members, User owner) {
		super();
		this.name = name;
		this.members = members;
		this.owner = owner;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public void addMember(User newMember) {
		this.members.add(newMember);
	}
	
	
}
