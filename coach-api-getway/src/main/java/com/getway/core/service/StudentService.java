package com.getway.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getway.core.model.Student;
import com.getway.core.repositoy.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	SequenceGeneratorService mSequenceGenerator;
	@Autowired
	StudentRepository mStudentRepository;
	
	public Student save(Student updated) {
		
		if(updated.getId() == null) {
			// create
			updated.setId(mSequenceGenerator.getSequenceNumber(Student.SEQUENCE_KEY));
			updated = mStudentRepository.save(updated);
		} else {
			// update

		}
		
		return updated;
	}
}
