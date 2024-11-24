package com.project.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FinalProject.domain.ReportTab;
import com.project.FinalProject.service.ReportTabService;

@RestController
//@RequestMapping("/report")
public class ReportTabController {
	@Autowired
	private ReportTabService reportTabService;

	@PostMapping("/report/save")
	public ReportTab saveReport(@RequestBody ReportTab report) {
		System.out.println("save report : " + report);
		return reportTabService.saveReport(report);
	}

	@GetMapping("/report/{studyKey}")
	public ReportTab getReportByStudyKey(@PathVariable("studyKey") Long studyKey) {
		ReportTab report = reportTabService.getReportByStudyKey(studyKey);
		System.out.println("find report : " + report);
		if (report == null) {
			report = new ReportTab();
			System.out.println("report in if : " + report);
		}
		return report;
	}

	@DeleteMapping("/report/delete/{studyKey}")
	public ReportTab deleteReportBystudyKey(@PathVariable("studyKey") Long studyKey) {
		System.out.println("delete Report studyKey : " + studyKey);
		ReportTab report = reportTabService.getReportByStudyKey(studyKey);
		System.out.println("find report : " + report);
		if (report != null) {
			reportTabService.deleteReportTabByStudyKey(report);
		}
		return report;
	}
}
