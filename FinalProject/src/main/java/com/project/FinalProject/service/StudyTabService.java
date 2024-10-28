package com.project.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.repository.StudyTabRepository;

@Service
public class StudyTabService {
	
	@Autowired
	StudyTabRepository studyTabRepository;
	
	//기존 findAll 메소드
	public Page<StudyTab> findAll(PageRequest page){
		return studyTabRepository.findAll(page);
		}

	public List<StudyTab> searchStudies(String pId, String pName, String modality, String startDate, String endDate, Long reportStatus, Long verifyFlag) {
        return studyTabRepository.searchStudies(pId, pName, modality, startDate, endDate, reportStatus, verifyFlag);
        }
	}
