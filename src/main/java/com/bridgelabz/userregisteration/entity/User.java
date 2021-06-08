package com.bridgelabz.userregisteration.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@PrimaryKey
	private UUID id;
	
	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String email;
	
	private String address;
}
