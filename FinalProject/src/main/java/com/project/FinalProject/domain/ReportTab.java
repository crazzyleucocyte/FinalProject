package com.project.FinalProject.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "REPORTTAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
public class ReportTab {
	
	@Id
	@Column(name = "STUDYKEY")
	private Long studyKey;
	
	//코멘트
	@Column(name = "REPORT_Comment")
	private String reportComment; 
	 
	//판독날짜
	@CreatedDate
	@Column(name = "REPORT_TIME", updatable=false)
	private LocalDateTime reportTime; 

	
	//판독의
	@Column(name = "USER_NAME")
	private String userName; 
	
	
}
