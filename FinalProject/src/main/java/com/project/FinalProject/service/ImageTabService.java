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

	// 수정된 메소드: curSeqNum으로 정렬하여 이미지 목록을 가져오기
	public List<ImageTab> getImagesByStudyKeyAndSeriesKey(Long studyKey, Long seriesKey) {
        return imageTabRepository.findByStudyKeyAndSeriesKeyOrderByCurSeqNumAsc(studyKey, seriesKey);
	}
	
	// studyKey와 seriesKey로 curSeqNum을 낮은순으로 가져오는 메서드
    public ImageTab getFirstImageBySeries(Long studyKey, Long seriesKey) {
    	List<ImageTab> images = imageTabRepository.findTopByStudyKeyAndSeriesKeyOrderByCurSeqNumAsc(studyKey, seriesKey);
    	return images.isEmpty() ? null : images.get(0); // 가장 낮은 curSeqNum의 첫 번째 이미지 반환
    }
    
    // 시리즈의 모든 이미지를 curSeqNum 순으로 가져오는 메서드
    public List<ImageTab> getAllImagesBySeries(Long studyKey, Long seriesKey) {
        return imageTabRepository.findByStudyKeyAndSeriesKeyOrderByCurSeqNumAsc(studyKey, seriesKey);
    }
}
	
