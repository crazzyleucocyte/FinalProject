package com.project.FinalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FinalProject.repository.PatientTabRepository;

@Service
public class PatientTabService {
	
	@Autowired
	PatientTabRepository patientTabRepository;

}
