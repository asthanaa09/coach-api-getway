package com.getway.core.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.getway.core.model.Role;
import com.getway.core.model.Role.RoleType;

@Repository
public interface RoleRepository extends MongoRepository<Role, Long> {
	
	public Role findByRoleType(RoleType roleType);
}
