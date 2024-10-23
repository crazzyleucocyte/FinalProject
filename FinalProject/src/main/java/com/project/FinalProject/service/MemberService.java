package com.project.FinalProject.service;

import com.project.FinalProject.domain.Member;
import com.project.FinalProject.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 사용자 ID로 사용자 조회
    public Optional<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    // 사용자 저장 (비밀번호 암호화 포함)
    public Member saveMember(Member member) {
        member.setPwd(passwordEncoder.encode(member.getPwd())); // 비밀번호 암호화
        return memberRepository.save(member);
    }

    // Spring Security에서 사용자 인증을 처리하기 위해 사용
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Member not found"));

        return User.withUsername(member.getId())
                .password(member.getPwd())
                .authorities("ROLE_USER") // 기본 권한 설정
                .build();
    }
}