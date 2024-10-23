package com.project.FinalProject.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "MEMBER")  // 오라클 테이블 이름을 'MEMBER'로 지정
@EntityListeners(AuditingEntityListener.class)
public class Member {

    // 사용자 아이디
    @Id
    @Column(name="ID", length=200, nullable = false)
    private String id;

    // 사용자 비밀번호
    @Column(name="PWD", length=200, nullable = false)
    @NonNull
    private String pwd;

    
}

