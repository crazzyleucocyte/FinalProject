package com.project.FinalProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SearchCondition {
	
	@JsonProperty("pId")
	String pId;
	@JsonProperty("pName")
	String pName;
	String modality;
	String startDate;
	String endDate;
	Long reportStatus;
	Long verifyFlag;
	
	void setStartDate(String startDate) {
		if(startDate != null) {
			this.startDate = startDate.replace("-", "");
		}
	}
	void setEndDate(String endDate) {
		if(endDate != null) {
			this.endDate = endDate.replace("-", "");
		}
	}
	
}
