package com.project.FinalProject.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.FinalProject.domain.Member;

public class MemberDetail implements UserDetails {
	
	 private Member member;

	    public MemberDetail(Member member) {
	        this.member = member;
	    }
		// 권한정보 제공
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	    	return Collections.singletonList(new SimpleGrantedAuthority(member.getRole()));
	    }
		// 비밀번호 정보 제공
	    @Override
	    public String getPassword() {
	    	System.out.println("MemberDetail getPassword : "+ member.getPassword());
	        return member.getPassword();
	    }
		// ID 정보 제공
	    @Override
	    public String getUsername() {
	    	System.out.println("MemberDetail getUsername : "+ member.getUsername());
	        return member.getUsername();
	    }
		// 계정 만료여부 제공
	    // 특별히 사용을 안할시 항상 true를 반환하도록 처리
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	    // 계정 비활성화 여부 제공
	    // 특별히 사용 안할시 항상 true를 반환하도록 처리
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	     
	    // 계정의 활성화 여부
	    // 딱히 사용안할시 항상 true를 반환하도록 처리
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
}
