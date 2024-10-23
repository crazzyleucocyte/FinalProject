package com.project.FinalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	 @GetMapping("/")
	 public String home() {
	     return "/home"; // 로그인 성공 시 home.html로 이동
	    }
	}

