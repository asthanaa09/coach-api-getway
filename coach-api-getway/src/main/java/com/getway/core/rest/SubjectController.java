package com.getway.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getway.core.model.Subject;
import com.getway.core.service.SubjectService;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

	@Autowired
	SubjectService mSubjectService;
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Subject subject,
			@RequestParam("institutionID") Long institutionID,
			@RequestParam(value = "subjectID", required = false) Long subjectID) {
		
		subject.setId(subjectID);
		return new ResponseEntity<Subject>(mSubjectService.createSubject(subject, institutionID), HttpStatus.OK);
	}
	
}
