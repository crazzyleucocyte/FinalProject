package com.project.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.repository.ImageTabRepository;

@Service
public class ImageTabService {

	@Autowired
	ImageTabRepository imageTabRepository;
	
	public String findByImageKey(String studyKey, String seriesKey, String ImageKey) {
		return imageTabRepository.findByImageKey(studyKey, seriesKey, ImageKey);
	}

	
	
	
}
