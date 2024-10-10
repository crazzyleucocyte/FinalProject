package com.project.FinalProject.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesTabId implements Serializable {

	private Long studyKey;
	private Long seriesKey;
}
