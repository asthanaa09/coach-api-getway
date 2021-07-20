package com.getway.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getway.core.model.Student;
import com.getway.core.model.User;
import com.getway.core.repositoy.RoleRepository;
import com.getway.core.repositoy.UserRepository;
import com.getway.core.service.SequenceGeneratorService;
import com.getway.core.service.StudentService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	SequenceGeneratorService mSequenceGenerator;
	@Autowired
	StudentService mStudentService;
	@Autowired
	RoleRepository mRoleRepository;
	@Autowired
	UserRepository mUserRepository;
	
	@PostMapping("")
	public User save(@RequestBody User user) {
		
		if(user.getStudent() != null) {
			// Create Student
			Student student = mStudentService.save(user.getStudent());
			user.setStudent(student);
		}
		
		List<User> users = mUserRepository.findByUsername(user.getUsername());
		if(users != null && !users.isEmpty())
			throw new RuntimeException("Username already exists");
			
		if(user.getId() == null) {
			// create
			user.setId(mSequenceGenerator.getSequenceNumber(User.SEQUENCE_NAME));
			user = mUserRepository.save(user);
		} else {
			// update
		}
		
		return user;
	}
}
  