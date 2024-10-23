package com.project.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus.Series;
import org.springframework.stereotype.Service;

import com.project.FinalProject.domain.SeriesTab;
import com.project.FinalProject.repository.SeriesTabRepository;

@Service
public class SeriesTabService {

	@Autowired
	private SeriesTabRepository seriesTabRepository;
	
	// studyKey를 기준으로 시리즈 목록을 반환하는 메서드
	public List<SeriesTab> findByStudyKey(String studyKey) {
	    return seriesTabRepository.findByStudyKey(studyKey);
    }
}

