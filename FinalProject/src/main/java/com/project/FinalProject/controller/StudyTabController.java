package com.project.FinalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		public List<StudyTab> searchStudies(@RequestBody SearchCondition searchCondition) {
			
			System.out.println("searchCondition : "+searchCondition);
			String pId = searchCondition.getPId();
			String pName = searchCondition.getPName();
			String modality = searchCondition.getModality();
			String startDate = searchCondition.getStartDate();
			String endDate = searchCondition.getEndDate();
			Long reportStatus = searchCondition.getReportStatus();
			Long verifyFlag = searchCondition.getVerifyFlag();
			List<StudyTab> studies = studyTabService.searchStudies(pId, pName, modality, startDate, endDate, reportStatus,
					verifyFlag);
//			model.addAttribute("studyTabs", studies);
	//
//			// 검색 후에도 값 유지
//			model.addAttribute("pId", pId);
//			model.addAttribute("pName", pName);
//			model.addAttribute("modality", modality);
//			model.addAttribute("startDate", startDate);
//			model.addAttribute("endDate", endDate);
//			model.addAttribute("reportStatus", reportStatus);
//			model.addAttribute("verifyFlag", verifyFlag);

			return studies;

		}
//	@PostMapping("/search")
//	@ResponseBody
//	public String searchStudiesByCondition(SearchCondition searchCondition) {
//			@RequestParam(value = "pId", required = false) String pId,
//			@RequestParam(value = "pName", required = false) String pName,
//			@RequestParam(value = "modality", required = false) String modality,
//			@RequestParam(value = "startDate", required = false) String startDate,
//			@RequestParam(value = "endDate", required = false) String endDate,
//			@RequestParam(value = "reportStatus", required = false) Long reportStatus,
//			@RequestParam(value = "verifyFlag", required = false) Long verifyFlag {
//		
//		List<StudyTab> studies = studyTabService.searchStudies(pId, pName, modality, startDate, endDate, reportStatus,
//				verifyFlag);
//		model.addAttribute("studyTabs", studies);
//		
//		// 검색 후에도 값 유지
//		model.addAttribute("pId", pId);
//		model.addAttribute("pName", pName);
//		model.addAttribute("modality", modality);
//		model.addAttribute("startDate", startDate);
//		model.addAttribute("endDate", endDate);
//		model.addAttribute("reportStatus", reportStatus);
//		model.addAttribute("verifyFlag", verifyFlag);
//		
//		return "searchResult";
//		
//	}
	
	@GetMapping("/study/{studykey}")
	public String getStudeyKey(@PathVariable("studykey") Long studyKey, Model model) {
		StudyTab studyTab = studyTabService.getStudyByStudyKey(studyKey);
		model.addAttribute("study", studyTab);
		// 과거 검사 내역 가져오기 (patientKey 기준)
		if (studyTab != null && studyTab.getPatientKey() != null) {
			List<StudyTab> pastStudies = studyTabService.getPastStudies(studyTab.getPatientKey());
			model.addAttribute("pastStudies", pastStudies);
		}
		return "Picdetail";
	}

	@GetMapping("/study/history/{patientKey}")
	@ResponseBody
	public List<StudyTab> getPatientHistory(@PathVariable("patientKey") Long patientKey, Model model) {
	
			List<StudyTab> pastStudies = studyTabService.getPastStudies(patientKey);
		return pastStudies;
	}
}
