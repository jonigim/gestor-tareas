package com.ttps.gestortareas.domain;

import java.sql.Date;
import java.util.List;

public class Task {

	private Long id;
	private String name;
	private String description;
	private List<User> members;
	private Date assignmentDate;
	private Date expirationDate;
	private List<Comment> comments; 
	private CheckList items;
	
	public Task(String name, String description, List<User> members, Date assignmentDate, Date expirationDate,
			List<Comment> comments, CheckList items) {
		super();
		this.name = name;
		this.description = description;
		this.members = members;
		this.assignmentDate = assignmentDate;
		this.expirationDate = expirationDate;
		this.comments = comments;
		this.items = items;
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
	public String getDescrition() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public Date getAssignmentDate() {
		return assignmentDate;
	}
	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public Date getVencimiento() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public List<Comment> getCommets() {
		return comments;
	}
	public void setCommentss(List<Comment> comments) {
		this.comments = comments;
	}
	public CheckList getItems() {
		return items;
	}
	public void setItems(CheckList items) {
		this.items = items;
	}
	public void assignUser(User user) {
		this.members.add(user);
	}
		
	
}
