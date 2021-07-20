package com.getway.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getway.core.model.Institute;
import com.getway.core.repositoy.InstituteRepository;

@Service
public class InstituteService {

	@Autowired
	SequenceGeneratorService mSequenceGeneratoryService;
	@Autowired
	InstituteRepository mInstitituteRepository;
	
	/**
	 * IMPORTANT
	 * 1. Institution can't be change once it gets persists
	 * 
	 * @param updated
	 * @return
	 */
	public Institute createOrUpdate(Institute updated) {
		if(updated.getId() == null) {
			// Create
			if(updated.getInstitution() == null)
				throw new RuntimeException("Missing Parent institution");
			
			updated.setId(mSequenceGeneratoryService.getSequenceNumber(Institute.SEQUENCE_KEY));
			updated = mInstitituteRepository.save(updated);
			
		} else {
			// Update
		}
			
		return updated;
	}
}
