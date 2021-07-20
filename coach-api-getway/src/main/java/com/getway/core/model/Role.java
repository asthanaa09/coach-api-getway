package com.getway.core.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

/**
 * User roles, to protect resources based on specified role
 * 
 * Ref: Uses of enums with mongo db
 * 
 * https://blog.tericcabrel.com/using-mongodb-with-spring-boot-project-part-1/
 * 
 * @author Anurag Asthana
 *
 */
@Document(collection = "roles")
public class Role extends BaseEntity {

	public static enum RoleType {
		COACHING_ADMIN,
		COACHING_STAFF,
		TEACHER,
		STUDENT,
		ADMIN
	} 
	
	// TODO: What is does
	@Field(targetType =  FieldType.STRING)
	private RoleType roleType;

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
}
