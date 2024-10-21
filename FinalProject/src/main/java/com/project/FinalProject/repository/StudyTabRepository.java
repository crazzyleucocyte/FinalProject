package com.project.FinalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.FinalProject.domain.StudyTab;

@Repository
public interface StudyTabRepository extends JpaRepository<StudyTab, Long> {
	//명시적인 JPQL 쿼리
    @Query("SELECT s FROM StudyTab s WHERE s.pId = :pId")
	//pId로 검색
    List<StudyTab> findByPId(@Param("pId") String pId);
    
    // pName으로 명시적인 JPQL 쿼리 사용
    @Query("SELECT s FROM StudyTab s WHERE s.pName = :pName")
    List<StudyTab> findByPName(@Param("pName") String pName);
    
    // studyDate 범위로 검색
    List<StudyTab> findByStudyDateBetween(String startDate, String endDate);
    
    // reportStatus로 검색
    List<StudyTab> findByReportStatus(Long reportStatus);
    
    // modality로 검색
    List<StudyTab> findByModality(String modality);
    
    // verifyFlag로 검색
    List<StudyTab> findByVerifyFlag(Long verifyFlag);

    
}