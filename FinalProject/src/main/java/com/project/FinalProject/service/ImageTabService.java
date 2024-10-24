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
	
	// 시리즈 키로 이미지 목록을 조회하는 서비스 메소드
	public List<ImageTab> getImagesByStudyKeyAndSeriesKey(Long studyKey, Long seriesKey) {
        return imageTabRepository.findByStudyKeyAndSeriesKey(studyKey, seriesKey);
        }
	}
