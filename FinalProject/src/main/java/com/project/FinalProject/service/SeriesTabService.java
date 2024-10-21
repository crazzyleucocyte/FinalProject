package com.project.FinalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.FinalProject.repository.SeriesTabRepository;

@Service
public class SeriesTabService {

	@Autowired
	SeriesTabRepository seriesTabRepository;
}
