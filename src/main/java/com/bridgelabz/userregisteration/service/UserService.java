package com.bridgelabz.userregisteration.service;

import java.util.List;
import java.util.UUID;

import com.bridgelabz.userregisteration.dto.UserDto;
import com.bridgelabz.userregisteration.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public User addUser(UserDto userDTO);
	
	public User getUser(UUID uuid);
	
}
