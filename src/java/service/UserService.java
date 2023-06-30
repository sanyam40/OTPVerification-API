package com.boot.service;

import org.springframework.stereotype.Service;

import com.boot.entity.User;

@Service
public class UserService {

	public User user = new User();

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
		user.setUsername("sanyam21csu234@ncuindia.edu");
		user.setPassword("000");
	}
}
