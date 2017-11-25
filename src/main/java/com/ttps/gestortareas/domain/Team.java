package com.ttps.gestortareas.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<User> members;
	
	@ManyToOne(optional=false, cascade=CascadeType.DETACH)
	@JoinColumn(name = "user_id")
	private User owner;
	
	public Team() {
		
	}
	
	public Team(String name, List<User> members, User owner) {
		super();
		this.name = name;
		if (members == null) {
			this.members = new ArrayList<>();
		}else {
			this.members = members;
		}
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
