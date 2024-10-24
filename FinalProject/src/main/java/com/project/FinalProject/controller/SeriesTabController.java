package com.project.FinalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus.Series;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.FinalProject.domain.SeriesTab;
import com.project.FinalProject.service.SeriesTabService;

import org.springframework.ui.Model;

@Controller
@RequestMapping
public class SeriesTabController {
	
	@Autowired
	private SeriesTabService seriesTabService;
	
	// studyKey를 기준으로 시리즈 목록을 조회하여 모델에 추가하고 페이지로 전달
	@GetMapping("/series")
	public String getSeriesByStudyKey(@RequestParam(name = "studyKey", required = true) String studyKey, Model model) {
	    if (studyKey == null || studyKey.isEmpty()) {
	    } else {
	    }
	    List<SeriesTab> seriesList = seriesTabService.findByStudyKey(studyKey);
	    model.addAttribute("seriesList", seriesList);
	    return "seriesPage";
	    }
	}
