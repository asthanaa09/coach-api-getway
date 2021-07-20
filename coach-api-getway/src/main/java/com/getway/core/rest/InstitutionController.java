package com.getway.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.getway.core.model.Institution;
import com.getway.core.service.InstitutionService;

@RestController
@RequestMapping("/api/institution")
public class InstitutionController {

	@Autowired
	InstitutionService mInstitutionService;
	
	@PostMapping("")
	public ResponseEntity<?> createInstitution(@RequestBody Institution institution,
			@RequestParam(value = "id", required = false) Long id) {
		
		// TODO: Only admin can create brnch
		institution.setId(id);
		return new ResponseEntity<Institution>(mInstitutionService.createOrUpdate(institution), HttpStatus.OK);
	}
}
