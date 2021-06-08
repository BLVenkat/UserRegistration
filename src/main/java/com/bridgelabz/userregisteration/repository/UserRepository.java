package com.bridgelabz.userregisteration.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.userregisteration.entity.User;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID> {

	@AllowFiltering
	public Optional<User> findByEmail(String email);
}
