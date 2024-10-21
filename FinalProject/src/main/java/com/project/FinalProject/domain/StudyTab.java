package com.project.FinalProject.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import jakarta.persistence.Table;

@Table (name = "STUDYTAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudyTab {

	@Id
	@Column(name = "STUDYKEY")
	private Long studyKey;

	@Column(name = "ABNORMALPATIENT")
	private Long abnormalPatient;

	@Column(name = "ACCESSNUM", length = 64)
	private String accessNum;

	@Column(name = "ADDEDINFO", length = 256)
	private String addedInfo;

	@Column(name = "AETITLE", length = 64)
	private String aeTitle;

	@Column(name = "AI_ABNORMAL_YN", length = 1)
	private String aiAbnormalYn;

	@Column(name = "AI_COMPANY", length = 64)
	private String aiCompany;

	@Column(name = "AI_FINDING", length = 64)
	private String aiFinding;

	@Column(name = "AI_MODEL_NAME", length = 64)
	private String aiModelName;

	@Column(name = "AI_NUMBER_OF_FINDINGS")
	private Integer aiNumberOfFindings;

	@Column(name = "AI_PRIORITY")
	private Integer aiPriority;

	@Column(name = "AI_REPORT", length = 4000)
	private String aiReport;

	@Column(name = "AI_RESULT_CODE")
	private Integer aiResultCode;

	@Column(name = "AI_SCORE")
	private Float aiScore;

	@Column(name = "AI_UPDATED", length = 14)
	private String aiUpdated;

	@Column(name = "AI_VERSION", length = 16)
	private String aiVersion;

	@Column(name = "ARCHSTATUS")
	private Long archStatus;

	@Column(name = "BACKUPDATETIME", length = 16)
	private String backupDateTime;

	@Column(name = "BACKUPLABEL", length = 64)
	private String backupLabel;

	@Column(name = "BACKUPSTATUS")
	private Long backupStatus;

	@Column(name = "BODYPART", length = 256)
	private String bodyPart;

	@Column(name = "BURNCNT")
	private Long burnCnt;

	@Column(name = "BURNDATETIME", length = 16)
	private String burnDateTime;

	@Column(name = "COMMENTS", length = 255)
	private String comments;

	@Column(name = "COMPSTATUS")
	private Long compStatus;

	@Column(name = "CONFIRMDATETIME", length = 16)
	private String confirmDateTime;

	@Column(name = "CONFIRMDR", length = 64)
	private String confirmDr;

	@Column(name = "DAP")
	private Float dap;

	@Column(name = "DELFLAG")
	private Long delFlag;

	@Column(name = "DEL_FLAG")
	private Long delFlagSmall;

	@Column(name = "DEPT", length = 64)
	private String dept;

	@Column(name = "EXAMCODE", length = 64)
	private String examCode;

	@Column(name = "EXAMSTATUS")
	private Long examStatus;

	@Column(name = "FILESIZE")
	private Integer fileSize;

	@Column(name = "HISADDEDINFO1", length = 256)
	private String hisAddedInfo1;

	@Column(name = "HISADDEDINFO2", length = 256)
	private String hisAddedInfo2;

	@Column(name = "HISADDEDINFO3", length = 256)
	private String hisAddedInfo3;

	@Column(name = "HISCOMMENTS", length = 256)
	private String hisComments;

	@Column(name = "HOSPITALID")
	private Long hospitalId;

	@Column(name = "IMAGECNT")
	private Long imageCnt;

	@Column(name = "INSERTDATE", length = 8)
	private String insertDate;

	@Column(name = "INSERTED", length = 14)
	private String inserted;

	@Column(name = "INSERTTIME", length = 8)
	private String insertTime;

	@Column(name = "INSNAME", length = 64)
	private String insName;

	@Column(name = "LATERALITY", length = 255)
	private String laterality;

	@Column(name = "MISMATCHFLAG")
	private Long mismatchFlag;

	@Column(name = "MODALITY", length = 16)
	private String modality;

	@Column(name = "MOVIECNT")
	private Long movieCnt;

	@Column(name = "MOVIEFLAG")
	private Long movieFlag;

	@Column(name = "NONIMAGECOUNT")
	private Integer nonImageCount;

	@Column(name = "NONSERIESCOUNT")
	private Integer nonSeriesCount;

	@Column(name = "OPENSTATUS")
	private Long openStatus;

	@Column(name = "OPERATORSNAME", length = 64)
	private String operatorsName;

	@Column(name = "OTHERSCPSENDSTATUS")
	private Long otherScpSendStatus;

	@Column(name = "PATAGE", length = 16)
	private String patAge;

	@Column(name = "PATIENTKEY")
	private Long patientKey;

	@Column(name = "PATKEY", length = 64)
	private String patKey;

	@Column(name = "PATKIND", length = 1)
	private String patKind;

	@Column(name = "PBIRTHDATETIME", length = 16)
	private String pBirthDateTime;

	@Column(name = "PENAME", length = 64)
	private String pEName;

	@Column(name = "PERFPHYSICIANNAME", length = 64)
	private String perfPhysicianName;

	@Column(name = "PFIRSTNAME", length = 64)
	private String pFirstName;

	@Column(name = "PID", length = 64)
	private String pId;

	@Column(name = "PKNAME", length = 64)
	private String pKName;

	@Column(name = "PLASTNAME", length = 64)
	private String pLastName;

	@Column(name = "PNAME", length = 64)
	private String pName;

	@Column(name = "PROTOCOLNAME", length = 256)
	private String protocolName;

	@Column(name = "PSEX", length = 16)
	private String pSex;

	@Column(name = "READCODE", length = 64)
	private String readCode;

	@Column(name = "READCODEDESC", length = 200)
	private String readCodeDesc;

	@Column(name = "READINGDATETIME", length = 16)
	private String readingDateTime;

	@Column(name = "READINGDR", length = 64)
	private String readingDr;

	@Column(name = "READINGKEYWORD", length = 128)
	private String readingKeyword;

	@Column(name = "READINGPRIORITY")
	private Long readingPriority;

	@Column(name = "READTYPE")
	private Long readType;

	@Column(name = "REASON4STUDY", length = 255)
	private String reason4Study;

	@Column(name = "REASONFORSTUDY", length = 255)
	private String reasonForStudy;

	@Column(name = "REFERTODRID", length = 64)
	private String referToDrId;

	@Column(name = "REFERTODRNAME", length = 64)
	private String referToDrName;

	@Column(name = "REFPHYSICIANNAME", length = 64)
	private String refPhysicianName;

	@Column(name = "REMOTEFLAG")
	private Long remoteFlag;

	@Column(name = "REPORTSTATUS")
	private Long reportStatus;

	@Column(name = "REQPHYSICIANNAME", length = 64)
	private String reqPhysicianName;

	@Column(name = "REQREADSTATUS")
	private Long reqReadStatus;

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

	@Column(name = "SERIESCNT")
	private Long seriesCnt;

	@Column(name = "SERIESMOVIECNT")
	private Long seriesMovieCnt;

	@Column(name = "SICKNAME", length = 256)
	private String sickName;

	@Column(name = "STATIONFILMROOM", length = 64)
	private String stationFilmRoom;

	@Column(name = "STATIONNAME", length = 64)
	private String stationName;

	@Column(name = "STEREOCOUNT")
	private Long stereoCount;

	@Column(name = "STORAGECOMPLETION", length = 1)
	private String storageCompletion;

	@Column(name = "STUDYDATE", length = 16)
	private String studyDate;

	@Column(name = "STUDYDESC", length = 256)
	private String studyDesc;

	@Column(name = "STUDYID", length = 64)
	private String studyId;

	@NonNull
	@Column(name = "STUDYINSUID", length = 64, nullable = false)
	private String studyInsuId;

	@Column(name = "STUDYTIME", length = 14)
	private String studyTime;

	@Column(name = "STUDYTYPE", length = 64)
	private String studyType;

	@Column(name = "TBFLAG")
	private Long tbFlag;

	@Column(name = "TEACHINGCASED")
	private Long teachingCased;

	@Column(name = "TRANSCRIBEDDATETIME", length = 16)
	private String transcribedDateTime;

	@Column(name = "TRANSCRIPTIONIST", length = 64)
	private String transcriptionist;

	@Column(name = "UPDATED", length = 14)
	private String updated;

	@NonNull
	@Column(name = "VALIDATEFLAG", nullable = false)
	private Long validateFlag;

	@Column(name = "VERIFYDATETIME", length = 14)
	private String verifyDateTime;

	@Column(name = "VERIFYFLAG")
	private Long verifyFlag;

	@Column(name = "VIEWPOSITION", length = 255)
	private String viewPosition;

	@Column(name = "WARD", length = 64)
	private String ward;
}



