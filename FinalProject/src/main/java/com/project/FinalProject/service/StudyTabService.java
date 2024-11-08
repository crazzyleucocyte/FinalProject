package com.project.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.dto.SearchCondition;
import com.project.FinalProject.repository.StudyTabRepository;

@Service
public class StudyTabService {
	
	@Autowired
	StudyTabRepository studyTabRepository;
	
	//기존 findAll 메소드
	public Page<StudyTab> findAll(PageRequest page){
		return studyTabRepository.findAll(page);
		}

	
	// SearchCondition을 사용한 검색 메서드
    public Page<StudyTab> searchStudies(SearchCondition searchCondition, Pageable pageable) {
        return studyTabRepository.searchStudies(
            searchCondition.getPId(),
            searchCondition.getPName(),
            searchCondition.getModality(),
            searchCondition.getStartDate(),
            searchCondition.getEndDate(),
            searchCondition.getReportStatus(),
            searchCondition.getVerifyFlag(),
            pageable
        );
    }

/*
	public Page<StudyTab> searchStudies(String pId, String pName, String modality, String startDate, String endDate, Long reportStatus, Long verifyFlag, Pageable pageable) {
        return studyTabRepository.searchStudies(pId, pName, modality, startDate, endDate, reportStatus, verifyFlag, pageable);
        }
*/
	
	public StudyTab getStudyByStudyKey(Long studyKey) {
		return studyTabRepository.findById(studyKey).orElse(null);
	}

	public List<StudyTab> getPastStudies(Long patientKey) {
		return studyTabRepository.findByPatientKey(patientKey);
	}

	}
