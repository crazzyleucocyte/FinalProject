package com.project.FinalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FinalProject.domain.ImageTab;
import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.repository.ImageTabRepository;

@Service
public class ImageTabService {

	@Autowired
	private ImageTabRepository imageTabRepository;
	
	public List<ImageTab> getImagesBySeriesKey(Long seriesKey) {
	    return imageTabRepository.findBySeriesKey(seriesKey);
	
	}
	

    
}
