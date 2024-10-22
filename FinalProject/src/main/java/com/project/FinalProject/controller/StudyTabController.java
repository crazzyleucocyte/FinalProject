package com.project.FinalProject.controller;

import java.util.List;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.service.StudyTabService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.format.annotation.DateTimeFormat;

@Controller
public class StudyTabController {

	@Autowired
	StudyTabService studyTabService;

	@RequestMapping("/")
	private String root() {
		return "login";
	}

	@PostMapping("/login")
	private String login() {
		return "home";
	}

	@RequestMapping("/list")
	private String getList(Model model) {
		org.springframework.data.domain.Page<StudyTab> pageList = studyTabService
				.findAll(PageRequest.of(0, 28, Sort.by(Sort.Direction.ASC, "studyKey")));
		model.addAttribute("pageList", pageList);
		System.out.println("pageList : " + pageList);
		return "list";
	}

	// 중첩된 검색 가능
	@GetMapping("/search")
	public String searchStudies(@RequestParam(value = "pId", required = false) String pId,
			@RequestParam(value = "pName", required = false) String pName,
			@RequestParam(value = "modality", required = false) String modality,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "reportStatus", required = false) Long reportStatus,
			@RequestParam(value = "verifyFlag", required = false) Long verifyFlag, Model model) {

		List<StudyTab> studies = studyTabService.searchStudies(pId, pName, modality, startDate, endDate, reportStatus,
				verifyFlag);
		model.addAttribute("studyTabs", studies);
		return "searchResult";
	}

	//ajax로 과거 검사 이력 가져오기
	@GetMapping("/search/patient/{pId}")
	private @ResponseBody List<StudyTab> patientHistory(@PathVariable("pId") String pId){
		List<StudyTab> result = studyTabService.findByPId(pId);
		
		return result;
	}
	
	
	
	
	
	
	
}
