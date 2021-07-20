package com.getway.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getway.core.model.Institution;
import com.getway.core.repositoy.InstitutionRepository;

@Service
public class InstitutionService {

	@Autowired
	InstitutionRepository mInstitutionRepository;
	@Autowired
	SequenceGeneratorService mSequenceGeneratorService;
	
	/**
	 * Create or update institution details 
	 * TODO: Apply validations
	 * 
	 * @param institution
	 * @return
	 */
	public Institution createOrUpdate(Institution institution) {
		
		if(institution.getId() == null) {
			// Create
			institution.setId(mSequenceGeneratorService.getSequenceNumber(Institution.SEQUNCE_NAME));
			institution = mInstitutionRepository.save(institution); 
		} else {
			// Update
		}
		
		return institution;
	}
}
