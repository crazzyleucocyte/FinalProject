package com.project.FinalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FinalProject.domain.ReportTab;
import com.project.FinalProject.repository.ReportTabRepository;

@Service
public class ReportTabService {

	@Autowired
	private ReportTabRepository reportTabRepository;

	public ReportTab saveReport(ReportTab report) {
		return reportTabRepository.save(report);
	}

	public ReportTab getReportByStudyKey(Long studyKey) {

		return reportTabRepository.findByStudyKey(studyKey).orElse(null);
	}

	public void deleteReportTabByStudyKey(ReportTab report) {
		System.out.println("\n\n\n\n\n\n\n\reportTabServiceDelete\n\n\n\n\n\n\n\n\n");
		reportTabRepository.delete(report);
	}

}
