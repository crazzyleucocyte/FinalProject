package com.project.FinalProject.domain;

import com.project.FinalProject.dto.ImageTabId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Table (name = "STUDYTAB")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(ImageTabId.class)
public class ImageTab {
	
	@Id
    @Column(name = "STUDYKEY")
    private Long studyKey;

	@Id
    @Column(name = "SERIESKEY")
    private Long seriesKey;
	
	@Id
	@Column(name = "IMAGEKEY")
    private Long imageKey;
	
	

	@Column(name = "ACQDATE", length = 8)
    private String acqDate;

    @Column(name = "ACQTIME", length = 16)
    private String acqTime;

    @Column(name = "ADDITIONALDESC", length = 32)
    private String additionalDesc;

    @Column(name = "AI_FINDING_COUNT")
    private Long aiFindingCount;

    @Column(name = "AI_SCORE")
    private Long aiScore;

    @Column(name = "ARCHPATH", length = 255)
    private String archPath;

    @Column(name = "ARCHSTATUS")
    private Long archStatus;

    @Column(name = "BITSALLOCATED")
    private Long bitsAllocated;

    @Column(name = "BITSSTORED")
    private Long bitsStored;

    @Column(name = "CODECTYPE", length = 128)
    private String codecType;

    @Column(name = "COMPSIZE")
    private Long compSize;

    @Column(name = "COMPSTATUS")
    private Long compStatus;

    @Column(name = "CONTENTDATE", length = 8)
    private String contentDate;

    @Column(name = "CONTENTTIME", length = 16)
    private String contentTime;

    @Column(name = "CURSEQNUM")
    private Long curSeqNum;

    @Column(name = "DELFLAG")
    private Long delFlag;

    @Column(name = "FMXDATA", length = 255)
    private String fmxData;

    @Column(name = "FNAME", length = 256)
    private String fName;

    @Column(name = "FRAMECNT")
    private Long frameCount;

    @Column(name = "FRAMERATE")
    private Float frameRate;

    @Column(name = "FRAMETIME")
    private Float frameTime;

    @Column(name = "GEOMSTATUS")
    private Long geomStatus;

    @Column(name = "HIDEFLAG")
    private Long hideFlag;

    @Column(name = "HIGHBIT")
    private Long highBit;

    @Column(name = "HOSPITALID", columnDefinition = "NUMBER DEFAULT 0")
    private Long hospitalId;

    @Column(name = "IMAGECOMMENTS", length = 255)
    private String imageComments;

    @Column(name = "IMAGEORIENTATION", length = 256)
    private String imageOrientation;

    @Column(name = "IMAGEPOSITION", length = 256)
    private String imagePosition;

    @Column(name = "IMAGESIZE")
    private Long imageSize;

    @Column(name = "IMAGETYPE", length = 256)
    private String imageType;

    @Column(name = "INSERTDATE", length = 8)
    private String insertDate;

    @Column(name = "INSERTED", length = 14)
    private String inserted;

    @Column(name = "INSERTTIME", length = 8)
    private String insertTime;

    @Column(name = "INSTANCECREATIONDATE", length = 8)
    private String instanceCreationDate;

    @Column(name = "INSTANCECREATIONTIME", length = 14)
    private String instanceCreationTime;

    @Column(name = "INSTANCENUM", length = 16)
    private String instanceNum;

    @Column(name = "KEYFLAG")
    private Long keyFlag;

    @Column(name = "LATERALITY", length = 64)
    private String laterality;

    @Column(name = "LEV")
    private Long lev;

    @Column(name = "LOSSYIMAGECOMPRESSION", length = 64)
    private String lossyImageCompression;

    @Column(name = "LTSTORAGEID", columnDefinition = "NUMBER DEFAULT 0")
    private Long ltStorageId;

    @Column(name = "LUTDATA", length = 255)
    private String lutData;

    @Column(name = "MOVFNAME", length = 255)
    private String movFName;

    @Column(name = "MOVIEFLAG", columnDefinition = "NUMBER DEFAULT 0")
    private Long movieFlag;

    @Column(name = "MOVPATH", length = 255)
    private String movPath;

    @Column(name = "MOVSTSTORAGEID")
    private Long movStStorageId;

    @Column(name = "PATH", length = 256)
    private String path;

    @Column(name = "PATIENTORIENTATION", length = 64)
    private String patientOrientation;

    @Column(name = "PHOTOMETRIC")
    private Long photometric;

    @Column(name = "PHOTOMETRICINTERPRETATION", length = 16)
    private String photometricInterpretation;

    @Column(name = "PIXELCOLUMNS")
    private Long pixelColumns;

    @Column(name = "PIXELREPRESENTATION")
    private Long pixelRepresentation;

    @Column(name = "PIXELROWS")
    private Long pixelRows;

    @Column(name = "PIXELSPACING", length = 256)
    private String pixelSpacing;

    @Column(name = "PLANARCONFIGURATION")
    private Long planarConfiguration;

    @Column(name = "PRESENTATIONLUTSHAPE", length = 16)
    private String presentationLutShape;

    @Column(name = "PRESENTATIONSTATEDATA", length = 255)
    private String presentationStateData;

    @Column(name = "RECENDDATE", length = 8)
    private String recEndDate;

    @Column(name = "RECENDTIME", length = 6)
    private String recEndTime;

    @Column(name = "RECSTARTDATE", length = 8)
    private String recStartDate;

    @Column(name = "RECSTARTTIME", length = 6)
    private String recStartTime;

    @Column(name = "REPORTSTATUS", length = 255)
    private String reportStatus;

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

    @Column(name = "SAMPLEPERPIXEL")
    private Long samplePerPixel;
    
    @NonNull
    @Column(name = "SERIESINSUID", length = 64, nullable = false)
    private String seriesInsUid;

    @Column(name = "SERIESNUMBER")
    private Long seriesNumber;

    @Column(name = "SHARPENVALUE")
    private Long sharpenValue;

    @Column(name = "SOPCLASSUID", length = 64)
    private String sopClassUid;

    @NonNull
    @Column(name = "SOPINSTANCEUID", length = 64, nullable = false)
    private String sopInstanceUid;

    @Column(name = "SOURCEAETITLE", length = 64)
    private String sourceAeTitle;

    @Column(name = "SOURCEAPPLICATIONENTITYTITLE", length = 16)
    private String sourceApplicationEntityTitle;

    @Column(name = "SPECIFICCHARACTERSET", length = 64)
    private String specificCharacterSet;

    @Column(name = "STSTORAGEID")
    private Long stStorageId;

    @Column(name = "STUDYID", length = 64)
    private String studyId;

    @NonNull
    @Column(name = "STUDYINSUID", length = 64, nullable = false)
    private String studyInsUid;

    @Column(name = "TRANSFERSYNTAXUID", length = 64)
    private String transferSyntaxUid;

    @Column(name = "UPDATED", length = 14)
    private String updated;

    @Column(name = "VERIFYFLAG")
    private Long verifyFlag;

    @Column(name = "VIEWPOSITION", length = 255)
    private String viewPosition;

    @Column(name = "WEBSTORAGEID")
    private Long webStorageId;

    @Column(name = "WINDOW")
    private Long window;
}
