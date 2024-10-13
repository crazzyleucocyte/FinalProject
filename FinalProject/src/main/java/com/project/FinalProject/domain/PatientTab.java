package com.project.FinalProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "PATIENTTAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientTab {
	
	@Id
    @Column(name = "PID", length = 64)
    private String pId;

	@Column(name = "COMMENTS", length = 64)
    private String comments;

    @Column(name = "DELFLAG")
    private Long delFlag;

    @Column(name = "HOSPITALID", columnDefinition = "NUMBER DEFAULT 0")
    private Long hospitalId;

    @Column(name = "INSERTDATE", length = 8)
    private String insertDate;

    @Column(name = "INSERTED", length = 14)
    private String inserted;

    @Column(name = "INSERTTIME", length = 8)
    private String insertTime;

    @Column(name = "INSNAME", length = 255)
    private String insName;

    @Column(name = "PATIENTKEY")
    private Long patientKey;

    @Column(name = "PATKEY", length = 64)
    private String patKey;

    @Column(name = "PBIRTHDATE", length = 8)
    private String pBirthDate;

    @Column(name = "PBIRTHTIME", length = 8)
    private String pBirthTime;

    @Column(name = "PENAME", length = 64)
    private String pEName;

    @Column(name = "PFIRSTNAME", length = 64)
    private String pFirstName;

    @Column(name = "PKNAME", length = 64)
    private String pKName;

    @Column(name = "PLASTNAME", length = 64)
    private String pLastName;

    @Column(name = "PNAME", length = 64, nullable = false)
    @NonNull
    private String pName;

    @Column(name = "PSEX", length = 2)
    private String pSex;

    @Column(name = "RESERVED1")
    private Long reserved1;

    @Column(name = "RESERVED10", length = 255)
    private String reserved10;

    @Column(name = "RESERVED2")
    private Long reserved2;

    @Column(name = "RESERVED3")
    private Long reserved3;

    @Column(name = "RESERVED4", length = 255)
    private String reserved4;

    @Column(name = "RESERVED5", length = 255)
    private String reserved5;

    @Column(name = "RESERVED6", length = 255)
    private String reserved6;

    @Column(name = "RESERVED7", length = 255)
    private String reserved7;

    @Column(name = "RESERVED8", length = 255)
    private String reserved8;

    @Column(name = "RESERVED9", length = 255)
    private String reserved9;

    @Column(name = "UPDATED", length = 14)
    private String updated;
}
