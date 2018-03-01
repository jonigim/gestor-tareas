package com.ttps.gestortareas.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ttps.gestortareas.domain.Board;
import com.ttps.gestortareas.domain.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = -2693726915717357097L;
	private Long id;
	private String username;
	private String password;
	private String name;
	private String email;
	private List<BoardDTO> boards;
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.name = user.getName();
		this.email = user.getEmail();
		List<BoardDTO> boardsList = new ArrayList<>();
		for (Board board : user.getBoards()) {
			BoardDTO dto = new BoardDTO(board);
			boardsList.add(dto);
		}
		this.boards = boardsList;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<BoardDTO> getBoards() {
		return boards;
	}
	public void setBoards(List<BoardDTO> boards) {
		this.boards = boards;
	}

}
