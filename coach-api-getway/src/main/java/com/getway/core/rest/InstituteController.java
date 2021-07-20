package com.getway.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getway.core.model.Institute;
import com.getway.core.model.Institution;
import com.getway.core.repositoy.InstitutionRepository;
import com.getway.core.service.InstituteService;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {

	@Autowired
	InstituteService mInstituteService;
	@Autowired
	InstitutionRepository mInstitutionRepository;
	
	/**
	 * @param institute
	 * @param institutionID - Parent institution, mandatory for institute creation
	 * @param instituteID - Institute id for update
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Institute institute,
			@RequestParam(value = "institutionID", required = false) Long institutionID,
			@RequestParam(value = "instituteID", required = false) Long instituteID) {
		
		if(institutionID != null) {
			Institution institution = mInstitutionRepository.findById(institutionID).get();
			institute.setInstitution(institution);
		}
		
		institute.setId(instituteID);
		
		return new ResponseEntity<Institute>(mInstituteService.createOrUpdate(institute), HttpStatus.OK);
	}
	
	
}
