package com.getway.core.repositoy;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.getway.core.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	public List<User> findByUsername(String username);
}
