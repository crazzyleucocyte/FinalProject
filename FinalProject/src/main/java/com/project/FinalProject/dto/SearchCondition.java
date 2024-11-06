package com.project.FinalProject.dto;

import lombok.Data;

@Data
public class SearchCondition {

	String pId;
	String pName;
	String modality;
	String startDate;
	String endDate;
	Long reportStatus;
	Long verifyFlag;
}
