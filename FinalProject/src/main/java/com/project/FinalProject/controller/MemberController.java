package com.project.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.FinalProject.domain.Member;
import com.project.FinalProject.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/home")
	public String homePage() {
		return "home";
	}

	@GetMapping("/tosignup")
	public String toSingup(Member m) {
		return "signUp";

	}

	@PostMapping("/signup")
	public String memberInsert(Member m) {
		System.out.println("Member : " + m);
		m.setPassword(passwordEncoder.encode(m.getPassword())); // 암호화하는 부분
		memberService.memberInsert(m);
		return "login";
	}

}
