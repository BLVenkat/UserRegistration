package com.bridgelabz.userregisteration.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.userregisteration.dto.UserDto;
import com.bridgelabz.userregisteration.entity.User;
import com.bridgelabz.userregisteration.response.Response;
import com.bridgelabz.userregisteration.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/get-all-users")
	public ResponseEntity<Response> getAllUsers(){
		
		List<User> users = userService.getAllUsers();
		
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"Users Fetched Successfully",users), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Response> addUser(@RequestBody UserDto userDTO){
		
		User user= userService.addUser(userDTO);
		
		return new ResponseEntity<Response>(new Response(HttpStatus.CREATED.value(),"User Added Successfully",user), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response> getUser(@PathVariable UUID id){
		
		User user = userService.getUser(id);
		
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"User Fetched Successfully",user), HttpStatus.OK);
	}
}
