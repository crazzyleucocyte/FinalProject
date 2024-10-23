package com.project.FinalProject.repository;

import com.project.FinalProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    // findById는 JpaRepository에서 기본 제공
}
