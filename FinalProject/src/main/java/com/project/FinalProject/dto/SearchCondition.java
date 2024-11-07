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
}
