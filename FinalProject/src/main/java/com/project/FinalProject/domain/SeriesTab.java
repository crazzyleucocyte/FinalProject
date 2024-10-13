package com.project.FinalProject.domain;

import com.project.FinalProject.dto.SeriesTabId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "SERIESTAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(SeriesTabId.class)
public class SeriesTab {
	
	
	@Id
    @Column(name = "SERIESKEY")
    private Long seriesKey;
	
	@Id
    @Column(name = "STUDYKEY")
    private Long studyKey;
	 
	

	@Column(name = "ANATOMICALORIENTATIONTYPE", length = 64)
    private String anatomicalOrientationType;

    @Column(name = "ANATOMICAL_ORIENTATION_TYPE", length = 255)
    private String anatomicalOrientationType255;

    @Column(name = "BODYPART", length = 256)
    private String bodyPart;

    @Column(name = "BODY_PART", length = 255)
    private String bodyPart255;

    @Column(name = "COMMENTS", length = 255)
    private String comments;

    @Column(name = "DELFLAG")
    private Long delFlag;

    @Column(name = "FILESIZE")
    private Long fileSize;

    @Column(name = "HOSPITALID", columnDefinition = "NUMBER DEFAULT 0")
    private Long hospitalId;

    @Column(name = "IMAGECNT")
    private Long imageCount;

    @Column(name = "INSERTDATE", length = 8)
    private String insertDate;

    @Column(name = "INSERTED", length = 14)
    private String inserted;

    @Column(name = "INSERTTIME", length = 8)
    private String insertTime;

    @Column(name = "INSERT_DATE", length = 255)
    private String insertDate255;

    @Column(name = "INSERT_TIME", length = 255)
    private String insertTime255;

    @Column(name = "INSTITUTIONALDEPARTMENTNAME", length = 64)
    private String institutionalDepartmentName;

    @Column(name = "INSTITUTIONAL_DEPARTMENT_NAME", length = 255)
    private String institutionalDepartmentName255;

    @Column(name = "INSTITUTIONNAME", length = 256)
    private String institutionName;

    @Column(name = "INSTITUTION_NAME", length = 255)
    private String institutionName255;

    @Column(name = "LATERALITY", length = 64)
    private String laterality;

    @Column(name = "MANUFACTURER", length = 64)
    private String manufacturer;

    @Column(name = "MANUMODELNAME", length = 64)
    private String manuModelName;

    @Column(name = "MANU_MODELNAME", length = 255)
    private String manuModelName255;

    @Column(name = "MANU_MODEL_NAME", length = 255)
    private String manuModelNameFull;

    @Column(name = "MODALITY", length = 16)
    private String modality;

    @Column(name = "MOVIECNT")
    private Long movieCount;

    @Column(name = "NONIMAGECOUNT")
    private Long nonImageCount;

    @Column(name = "OPERATORSNAME", length = 64)
    private String operatorsName;

    @Column(name = "OPERATORS_NAME", length = 255)
    private String operatorsName255;

    @Column(name = "PATPOSITION", length = 64)
    private String patPosition;

    @Column(name = "PAT_POSITION", length = 255)
    private String patPosition255;

    @Column(name = "PERFORMINGPHYSICIANNAME", length = 64)
    private String performingPhysicianName;

    @Column(name = "PERFORMING_PHYSICIAN_NAME", length = 255)
    private String performingPhysicianName255;

    @Column(name = "PROTOCOLNAME", length = 64)
    private String protocolName;

    @Column(name = "PROTOCOL_NAME", length = 255)
    private String protocolName255;

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

    @Column(name = "SERIESCURSEQNUM")
    private Long seriesCurSeqNum;

    @Column(name = "SERIESDATE", length = 8)
    private String seriesDate;

    @Column(name = "SERIESDESC", length = 256)
    private String seriesDesc;

    @NonNull
    @Column(name = "SERIESINSUID", length = 64, nullable = false)
    private String seriesInsUid;

    @Column(name = "SERIESNUM")
    private Long seriesNum;

    @Column(name = "SERIESTIME", length = 14)
    private String seriesTime;

    @Column(name = "SERIESTYPE", length = 64)
    private String seriesType;

    @Column(name = "SERIES_DATE", length = 255)
    private String seriesDate255;

    @Column(name = "SERIES_DESC", length = 255)
    private String seriesDesc255;

    @Column(name = "SERIES_INS_UID", length = 255)
    private String seriesInsUid255;

    @Column(name = "SERIES_KEY", precision = 19)
    private Double seriesKeyDouble;

    @Column(name = "SERIES_TIME", length = 255)
    private String seriesTime255;

    @Column(name = "SERIES_TYPE", length = 255)
    private String seriesType255;

    @Column(name = "STATIONNAME", length = 64)
    private String stationName;

    @Column(name = "STATION_NAME", length = 255)
    private String stationName255;

    @Column(name = "STUDYID", length = 64)
    private String studyId;

    @NonNull
    @Column(name = "STUDYINSUID", length = 64, nullable = false)
    private String studyInsUid;

    @Column(name = "STUDY_ID", length = 255)
    private String studyId255;

    @Column(name = "STUDY_INS_UID", length = 255)
    private String studyInsUid255;

    @Column(name = "UPDATED", length = 14)
    private String updated;

    @Column(name = "VERIFYFLAG")
    private Long verifyFlag;

    @Column(name = "VIEWPOSITION", length = 255)
    private String viewPosition;

    @Column(name = "VIEW_POSITION", length = 255)
    private String viewPosition255;
}
