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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		org.springframework.data.domain.Page<StudyTab> pageList =studyTabService.findAll(PageRequest.of(0, 28, Sort.by(Sort.Direction.ASC,"studyKey")));
		model.addAttribute("pageList", pageList);
		System.out.println("pageList : " + pageList);
		return "list";
	}
	
	// 검색 기능 추가
    @GetMapping("/search")
    public String searchStudy(@RequestParam(value = "pId", required = false) String pId,
                                   @RequestParam(value = "pName", required = false) String pName,
                                   @RequestParam(value = "startDate", required = false) String startDate,
                                   @RequestParam(value = "endDate", required = false) String endDate,
                                   @RequestParam(value = "reportStatus", required = false) String reportStatus,
                                   @RequestParam(value = "modality", required = false) String modality,
                                   @RequestParam(value = "verifyFlag", required = false) String verifyFlag,
                                   Model model) {
        
        
//      // pId가 비어있을 때 에러 메시지 반환
//      if ((pId == null || pId.isEmpty()) && (pName == null || pName.isEmpty()) && (studyDate == null || studyDate.isEmpty())) {
//            model.addAttribute("error", "Patient ID or Name is required");
//            return "searchResult";
//      }
        
        // pId로 검색
        if (pId != null && !pId.isEmpty()) {
            List<StudyTab> studies = studyTabService.findByPId(pId);
            if (!studies.isEmpty()) {
                model.addAttribute("studyTabs", studies);
            } else {
                model.addAttribute("error", "No study found with the given ID");
                }
            }
        
        // pName으로 검색
        if (pName != null && !pName.isEmpty()) {
            List<StudyTab> studies = studyTabService.findByPName(pName);
            if (!studies.isEmpty()) {
                model.addAttribute("studyTabs", studies);
            } else {
                model.addAttribute("error", "No study found with the given Name");
                }
            }
        
        
        // studyDate로 날짜범위로 검색
        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
            // 'YYYY-MM-DD' 형식을 'YYYYMMDD'로 변환
            String formattedStartDate = startDate.replace("-", "");
            String formattedEndDate = endDate.replace("-", "");
            // 디버깅 메시지
            System.out.println("Start date: " + formattedStartDate);
            System.out.println("End date: " + formattedEndDate);
            // 날짜 범위로 검색
            List<StudyTab> studiesByDateRange = studyTabService.findByStudyDateBetween(formattedStartDate, formattedEndDate);
            if (!studiesByDateRange.isEmpty()) {
                model.addAttribute("studyTabs", studiesByDateRange);
                } else {
                    model.addAttribute("error", "No study found in the given date range");
                    }
            }
        
        // reportStatus로 판독 상태 검색
        if (reportStatus != null && !reportStatus.isEmpty()) {
            Long reportStatusLong = Long.parseLong(reportStatus);
            List<StudyTab> studiesByStatus = studyTabService.findByReportStatus(reportStatusLong);
            if (!studiesByStatus.isEmpty()) {
                model.addAttribute("studyTabs", studiesByStatus);
                } else {
                    model.addAttribute("error", "No study found with the given report status");
                    }
            }
        
        // 검사 장비로 검색
        if (modality != null && !modality.isEmpty()) {
            List<StudyTab> studiesByModality = studyTabService.findByModality(modality);
            if (!studiesByModality.isEmpty()) {
                model.addAttribute("studyTabs", studiesByModality);
                } else {
                    model.addAttribute("error", "No study found with the given modality");
                    }
            }
        
        // verifyFlag로 검색
        if (verifyFlag != null && !verifyFlag.isEmpty()) {
            Long verifyFlagLong = Long.parseLong(verifyFlag);  // 문자열을 Long 타입으로 변환
            List<StudyTab> studiesByVerifyFlag = studyTabService.findByVerifyFlag(verifyFlagLong);
            if (!studiesByVerifyFlag.isEmpty()) {
                model.addAttribute("studyTabs", studiesByVerifyFlag);
            } else {
                model.addAttribute("error", "No study found with the given verify status");
            }
        }
        
        
        return "searchResult"; // 검색 결과 페이지 반환
        }
	
}
