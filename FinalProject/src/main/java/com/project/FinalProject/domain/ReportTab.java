package com.project.FinalProject.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ReportTab {
	@Id
	@Column(name = "STUDYKEY")
	private Long studyKey;
	
	@Column(name = "COMMENT")
	private String comment; //코멘트
	
	@CreatedDate
	@Column(name = "REPORT_TIME", updatable = false)
	private LocalDateTime reportTime; //판독날짜

	
	@Column(name = "USERNAME")
	private String userName; //판독의
	
	
}
