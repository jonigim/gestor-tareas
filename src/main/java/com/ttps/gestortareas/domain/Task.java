package com.ttps.gestortareas.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	
	@ManyToMany
	private List<User> members;
	
	private Date assignmentDate;
	private Date expirationDate;
	
	
	@OneToMany
	@JoinColumn(name="task_id")
	private List<Comment> comments;
	
	@OneToOne(optional = true)
	private CheckList checklist;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="task_list_id")
	private TaskList taskList;
	
	public Task(){
		
	}
	
	public Task(String name, String description, List<User> members, Date assignmentDate, Date expirationDate,
			List<Comment> comments, CheckList checklist, TaskList taskList) {
		super();
		this.name = name;
		this.description = description;
		this.members = members;
		this.assignmentDate = assignmentDate;
		this.expirationDate = expirationDate;
		this.comments = comments;
		this.checklist = checklist;
		this.taskList = taskList;
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

	public String getDescription() {
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

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public CheckList getChecklist() {
		return checklist;
	}

	public void setChecklist(CheckList checklist) {
		this.checklist = checklist;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}
}
