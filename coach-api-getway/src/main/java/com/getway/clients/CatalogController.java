package com.getway.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/getway")
public class CatalogController {

	@Autowired
	private CatalogClient catalogClient;

	/**
	 * @param studentID
	 * @param subjectIDs - 1, 2, 3, 4
	 * @return
	 */
	@GetMapping("/catalog")
	public ResponseEntity<?> updateCatalog(@RequestParam("studentID") Long studentID,
			@RequestParam("subjectIDs") String subjectIDs) {
		return new ResponseEntity<String>(catalogClient.updateCatalog(studentID, subjectIDs), HttpStatus.OK);
	}
	
	@GetMapping("/catalog/remove")
	public ResponseEntity<?> remove(@RequestParam("studentID") Long studentID,
			@RequestParam("subjectID") Long subjectID) {
		return new ResponseEntity<String>(catalogClient.removeCatalog(studentID, subjectID), HttpStatus.OK);
	}
}
