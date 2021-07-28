package com.getway.core.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getway.core.model.Student;
import com.getway.core.repositoy.StudentRepository;
import com.getway.core.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService mStudentService;
	
	@PostMapping("")
	public Student student(@RequestBody Student student,
			@RequestParam(value = "id", required = false) Long id) {
		System.out.println("___________________________");
		student.setId(id);
		return mStudentService.save(student);
	}
	
	@GetMapping("")
	public List<Student> all() {
		System.out.println("__________1");
		return studentRepository.findAll();
	}
}
