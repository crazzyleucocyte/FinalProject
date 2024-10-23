package com.project.FinalProject.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {

    // 사용자 아이디
    @Id
    @Column(name="ID", length=20, nullable = false)
    private String id;

    // 사용자 비밀번호
    @Column(name="PWD", length=30, nullable = false)
    @NonNull
    private String pwd;

    // 계정 생성 날짜
    @CreatedDate
    @Column(name="CREATE_DT", insertable=false, updatable=false, columnDefinition="DATE DEFAULT SYSDATE")
    private LocalDateTime createDate;
}
