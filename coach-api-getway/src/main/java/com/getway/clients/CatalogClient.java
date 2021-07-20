package com.getway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="COACH-CATALOG-SERVICE")
public interface CatalogClient {

	@GetMapping("/api/catalog")
	public String updateCatalog(@RequestParam("studentID") Long studentID,
			@RequestParam("subjectIDs") String subjectIDs);
	
	@GetMapping("/api/catalog/remove")
	public String removeCatalog(@RequestParam("studentID") Long studentID,
			@RequestParam("subjectID") Long subjectID);	
}
