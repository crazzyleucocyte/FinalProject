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
	
	// 특정 스터디키, 시리어스키, 이미지키에 해당하는 다이콤이미지 파일을 보여주기
	@GetMapping("/images")
	public String getImagesBySeriesKey(@RequestParam(name = "seriesNum") Long seriesKey, Model model) {
	    if (seriesKey == null) {
	        System.out.println("seriesKey is missing");
	        return "errorPage"; // 파라미터가 없을 때 보여줄 페이지
	    } else {
	        System.out.println("Received seriesKey: " + seriesKey);
	    }

	    // 시리즈 키로 이미지 목록을 가져옴
	    List<ImageTab> images = imageTabService.getImagesBySeriesKey(seriesKey);

	    if (images.isEmpty()) {
	        System.out.println("No images found for seriesKey: " + seriesKey);
	    }

	    model.addAttribute("images", images);
	    return "imagePage"; // 이미지를 보여줄 HTML 페이지 이름
	}
}