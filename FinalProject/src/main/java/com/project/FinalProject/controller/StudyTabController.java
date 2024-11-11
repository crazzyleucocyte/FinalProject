package com.project.FinalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.dto.SearchCondition;
import com.project.FinalProject.service.StudyTabService;

@Controller
public class StudyTabController {

	@Autowired
	StudyTabService studyTabService;
	
	// 중첩된 검색 가능
	@PostMapping("/search")
	@ResponseBody
	public Page<StudyTab> searchStudies(@RequestBody SearchCondition searchCondition, @PageableDefault(size=10, sort = "studyKey", direction = Sort.Direction.DESC)Pageable pageable) {
		
		System.out.println("searchCondition : "+searchCondition);
		Page<StudyTab> studies = studyTabService.searchStudies(searchCondition,pageable);
		
		return studies;
	}

	@GetMapping("/study/history/{patientKey}")
	@ResponseBody
	public List<StudyTab> getPatientHistory(@PathVariable("patientKey") Long patientKey, Model model) {
	
			List<StudyTab> pastStudies = studyTabService.getPastStudies(patientKey);
		
		return pastStudies;
	}
}
