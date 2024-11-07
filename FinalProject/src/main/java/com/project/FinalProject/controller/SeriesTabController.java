package com.project.FinalProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus.Series;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.FinalProject.domain.ImageTab;
import com.project.FinalProject.domain.SeriesTab;
import com.project.FinalProject.service.ImageTabService;
import com.project.FinalProject.service.SeriesTabService;

import org.springframework.ui.Model;

@Controller
public class SeriesTabController {

	@Autowired
	private SeriesTabService seriesTabService;
	
	@Autowired
	private ImageTabService imageTabService;

	// 스터디키를 기준으로 시리즈 목록을 조회하여 모델에 추가하고 페이지로 전달
	@GetMapping("/series")
    public String getSeriesPage(@RequestParam(name = "studyKey") Long studyKey, Model model) {
        List<SeriesTab> seriesList = seriesTabService.getSeriesByStudyKey(studyKey);
        List<Map<String, String>> imagePaths = new ArrayList<>();

        // 각 시리즈에 대해 curSeqNum이 가장 낮은 이미지를 가져옴
        for (SeriesTab series : seriesList) {
            ImageTab firstImage = imageTabService.getFirstImageBySeries(studyKey, series.getSeriesKey());
            if (firstImage != null) {
                // 경로를 `wadouri` 형식으로 변환하여 사용
                String imagePath = "wadouri:PACSStorage/" + firstImage.getPath() + firstImage.getFName();
                System.out.println("Generated Image Path: " + imagePath.replace("\\", "/")); // 이미지 경로 확인

                Map<String, String> imageInfo = new HashMap<>();
                imageInfo.put("imagePath", imagePath.replace("\\", "/"));
                imageInfo.put("seriesKey", String.valueOf(series.getSeriesKey()));
                imageInfo.put("curSeqNum", String.valueOf(firstImage.getCurSeqNum()));
                imagePaths.add(imageInfo);
            }
        }

        model.addAttribute("seriesList", seriesList);
        model.addAttribute("imagePaths", imagePaths); // `imagePaths` 모델에 추가
        
        return "seriesPage";
	}
	
	@GetMapping("/series/images")
    public String getSeriesImagesPage(@RequestParam(name = "studyKey") Long studyKey,
                                      @RequestParam(name = "seriesKey") Long seriesKey, Model model) {
        // 선택된 시리즈의 모든 이미지를 가져와 모델에 추가
        List<ImageTab> imageList = imageTabService.getAllImagesBySeries(studyKey, seriesKey);
        List<String> imagePaths = new ArrayList<>();

        for (ImageTab image : imageList) {
        	String imagePath = "wadouri:http://localhost:8080/PACSStorage/" + image.getPath() + image.getFName();
            imagePaths.add(imagePath.replace("\\", "/"));
        }

        model.addAttribute("imagePaths", imagePaths);
        return "seriesImage";
    }
}