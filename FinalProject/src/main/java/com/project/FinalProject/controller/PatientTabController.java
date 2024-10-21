package com.project.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.FinalProject.service.PatientTabService;

@Controller
public class PatientTabController {

	@Autowired
	PatientTabService patientTabService;
}
