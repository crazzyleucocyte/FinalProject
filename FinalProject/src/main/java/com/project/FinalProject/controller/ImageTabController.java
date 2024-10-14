package com.project.FinalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.service.ImageTabService;
import com.project.FinalProject.service.StudyTabService;

@Controller
public class ImageTabController {

	@Autowired
	ImageTabService imageTabService;
	
	
	@GetMapping("viewer/{studyKey}/{seriesKey}/{imageKey}")
	private String test(Model model,@PathVariable("studyKey") String studyKey ,@PathVariable("serieseKey") String seriesKey, @PathVariable("imageKey") String imageKey) {
		
		imageTabService.findByImageKey(studyKey, seriesKey, imageKey);
		
		return "test";
	}

}
