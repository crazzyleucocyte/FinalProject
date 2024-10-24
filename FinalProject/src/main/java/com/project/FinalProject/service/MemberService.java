package com.project.FinalProject.service;

import com.project.FinalProject.domain.Member;
import com.project.FinalProject.repository.MemberRepository;
import com.project.FinalProject.security.MemberDetail;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements UserDetailsService {

	@Autowired
    MemberRepository memberRepository;

    
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with ID: " + id));
        System.out.println("MemberService(31) : "+member);
        if(member == null) {
        	System.out.println("MemberService(33) : "+member);
            throw new UsernameNotFoundException("계정을 찾을 수 없습니다.");
        }
        return new MemberDetail(member);
        
    }


	public void memberInsert(Member m) {
		memberRepository.save(m);
	}
}
