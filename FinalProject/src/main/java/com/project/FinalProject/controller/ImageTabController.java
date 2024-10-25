package com.project.FinalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.FinalProject.domain.ImageTab;
import com.project.FinalProject.domain.StudyTab;
import com.project.FinalProject.service.ImageTabService;
import com.project.FinalProject.service.StudyTabService;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ImageTabController {

	@Autowired
	private ImageTabService imageTabService;

	// 스터디 키와 시리즈 키로 이미지 목록을 조회하는 컨트롤러 메소드
	@GetMapping("/images")
	public String getImagesByStudyKeyAndSeriesKey(@RequestParam(name = "studyKey") Long studyKey,
			@RequestParam(name = "seriesKey") Long seriesKey, Model model) {
		System.out.println("스터디 키: " + studyKey);
		System.out.println("시리즈 키: " + seriesKey);

		// 스터디 키와 시리즈 키로 이미지 목록을 가져옴
		List<ImageTab> images = imageTabService.getImagesByStudyKeyAndSeriesKey(studyKey, seriesKey);

		// 모델에 이미지 목록 추가
		model.addAttribute("images", images);
		return "imagePage"; // 이미지 목록을 보여줄 HTML 페이지
	}
}