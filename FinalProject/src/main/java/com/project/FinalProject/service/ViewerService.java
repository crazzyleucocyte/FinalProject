package com.project.FinalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FinalProject.repository.ViewerRepository;

@Service
public class ViewerService {

	@Autowired
	ViewerRepository viewerRepository;
	
	public String findByImageKey(String studyKey, String seriesKey, String ImageKey) {
		return viewerRepository.findByImageKey(studyKey, seriesKey, ImageKey);
	}
	
	
}
