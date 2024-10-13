package com.project.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FinalProject.service.ViewerService;

@RestController
public class ViewerController {
	
	@RequestMapping("/")
	private String root() {
		return"index";
	}
	
	@Autowired
	ViewerService viewerService;
	
	@GetMapping("viewer/{studyKey}/{seriesKey}/{imageKey}")
	private String test(Model model,@PathVariable("studyKey") String studyKey ,@PathVariable("serieseKey") String seriesKey, @PathVariable("imageKey") String imageKey) {
		
		viewerService.findByImageKey(studyKey, seriesKey, imageKey);
		
		return "test";
	}

}
