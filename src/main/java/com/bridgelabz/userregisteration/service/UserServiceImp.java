package com.bridgelabz.userregisteration.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.userregisteration.dto.UserDto;
import com.bridgelabz.userregisteration.entity.User;
import com.bridgelabz.userregisteration.exception.UserException;
import com.bridgelabz.userregisteration.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(UserDto userDTO) {
		
		Optional<User> isUserPresent = userRepository.findByEmail(userDTO.getEmail());	
		if(isUserPresent.isPresent()) {
			throw new UserException(HttpStatus.CONFLICT.value(),"User Email is Already exit");
		}
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		user.setId(UUID.randomUUID());
		return userRepository.save(user);
	}

	@Override
	public User getUser(UUID uuid) {
		
		Optional<User> isUserPresent =  userRepository.findById(uuid);
		if(!isUserPresent.isPresent()) {
			throw new UserException(HttpStatus.NOT_FOUND.value(),"User Not Found");
		}
		return isUserPresent.get();

	}
	

}
