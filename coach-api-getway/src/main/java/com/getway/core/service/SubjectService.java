package com.getway.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getway.core.model.Institution;
import com.getway.core.model.Subject;
import com.getway.core.repositoy.InstitutionRepository;
import com.getway.core.repositoy.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	@Autowired
	InstitutionRepository mInstitutionRepository;
	@Autowired
	SubjectRepository mSubjectRepository;
	
	/**
	 * Create new subject or update
	 * 
	 * IMPORTANT
	 * 1. Once subject gets created then institution can't be changed
	 * 
	 * @param subject
	 * @param institutionID
	 * @return
	 */
	public Subject createSubject(Subject subject, Long institutionID) {
		
		if(subject.getId() == null) {
			// create
			 Institution institution = mInstitutionRepository.findById(institutionID).get();
			 subject.setInstitution(institution);
			 subject.setId(sequenceGeneratorService.getSequenceNumber(Subject.SUBJECT_SEQUENCE));
			 subject = mSubjectRepository.save(subject);
		} else {
			// update
		}
		
		return subject;
	}
	
}

