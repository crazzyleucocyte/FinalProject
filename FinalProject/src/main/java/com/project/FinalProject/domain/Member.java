package com.project.FinalProject.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "MEMBER")  // 오라클 테이블 이름을 'MEMBER'로 지정
@EntityListeners(AuditingEntityListener.class)
@ToString
public class Member {

    // 사용자 아이디
    @Id
    @Column(name="USERNAME", length=200, nullable = false)
    private String username;

    // 사용자 비밀번호
    @Column(name="PASSWORD", length=200, nullable = false)
    @NonNull
    private String password;

    @Column(name="ROLE", length=50, nullable = false)
    private String role;
}

