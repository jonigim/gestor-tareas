package com.ttps.gestortareas.dto;

import java.io.Serializable;
import java.sql.Date;

import com.ttps.gestortareas.domain.Board;

public class BoardDTO implements Serializable {
	
	private static final long serialVersionUID = -7543453611140935600L;
	private Long id;
	private String name;
	private Date startDate;
	private Date finishDate;
	private int members;
	
	public BoardDTO(Board board) {
		super();
		this.id = board.getId();
		this.name = board.getName();
		this.startDate = board.getStartDate();
		this.finishDate = board.getFinishDate();
		this.members = board.getUserMembers().size();
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	
	

}
