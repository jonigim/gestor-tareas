package com.ttps.gestortareas.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ttps.gestortareas.domain.User;
import com.ttps.gestortareas.dto.UserDTO;
import com.ttps.gestortareas.exception.AuthenticationException;
import com.ttps.gestortareas.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	private static final String TOKEN = "token";
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<Void>authenticateUser(@RequestHeader Map<String, String> mapHeaders) {
		try {
			String token = userService.authenticateUser(mapHeaders.get("user"), mapHeaders.get("password"));
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set(TOKEN, token);
			responseHeaders.set("access-control-expose-headers", TOKEN);
			return new ResponseEntity<>(responseHeaders, HttpStatus.NO_CONTENT);
		} catch (AuthenticationException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user = userService.createUser(user);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") long id, @RequestHeader Map<String, String> mapHeaders) {

		try {
			String token = mapHeaders.get(TOKEN);
			checkToken(token);
			User user = userService.getUserById(id);
			if (user == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			UserDTO userDto = new UserDTO(user);
			return new ResponseEntity<>(userDto, HttpStatus.OK);
		}catch (AuthenticationException e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user, @RequestHeader Map<String, String> mapHeaders) {
		try {
			String token = mapHeaders.get(TOKEN);
			checkToken(token);
			userService.updateUser(id, user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch (AuthenticationException e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private void checkToken(String token) throws AuthenticationException {
		if((token==null) || (!token.endsWith("123456")) || token.length()<7 ) {
			throw new AuthenticationException();
		}
		
	}

}
