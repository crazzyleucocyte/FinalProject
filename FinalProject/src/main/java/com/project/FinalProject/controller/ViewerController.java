package com.project.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewerController {
	
//	@Autowired
//	ViewerService viewerService;
	
	@GetMapping("viewer/{studyKey}/{seriesKey}/{imageKey}")
	private String test(@PathVariable("studyKey") String studyKey ,@PathVariable("serieseKey") String seriesKey, @PathVariable("imageKey") String imageKey) {
		
		return "test";
	}

}
