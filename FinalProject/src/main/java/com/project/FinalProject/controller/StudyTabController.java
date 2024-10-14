package com.project.FinalProject.controller;

import java.util.List;import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.service.StudyTabService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Controller
public class StudyTabController {

	@Autowired
	StudyTabService studyTabService; 
	
	@RequestMapping("/")
	private String root(Model model) {
		org.springframework.data.domain.Page<StudyTab> pageList =studyTabService.findAll(PageRequest.of(0, 28, Sort.by(Sort.Direction.ASC,"studyKey")));
		model.addAttribute("pageList", pageList);
		System.out.println("pageList : " + pageList);
		return "index";
	}
}
