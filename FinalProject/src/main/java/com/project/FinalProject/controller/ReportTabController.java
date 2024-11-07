package com.project.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.FinalProject.domain.ReportTab;
import com.project.FinalProject.service.ReportTabService;

@RestController
public class ReportTabController {
   @Autowired
   private ReportTabService reportTabService;
   
   @PostMapping("/report/save")
   public ReportTab saveReport(@RequestBody ReportTab report) {
      
      return reportTabService.saveReport(report);
   }
   
   @GetMapping("/report/{studyKey}")
   public ReportTab getReportByStudyKey(@PathVariable("studyKey") Long studyKey) {
	   ReportTab report = reportTabService.getReportByStudyKey(studyKey);
	  System.out.println("report : " + report);
//       if (report == null) {
//          throw new RuntimeException("스터디 키 못찾음 : " + studyKey);
//       }
       return report;
   }

}
