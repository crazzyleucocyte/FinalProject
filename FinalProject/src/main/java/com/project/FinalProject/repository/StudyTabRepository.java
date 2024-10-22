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
    
    /*
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
*/
	@Query("SELECT s FROM StudyTab s WHERE " +
		       "(:pId IS NULL OR s.pId = :pId) AND " +
	 	       "(:pName IS NULL OR s.pName = :pName) AND " +
		       "(:modality IS NULL OR s.modality = :modality) AND " +
		       "(:startDate IS NULL OR s.studyDate >= :startDate) AND " +
		       "(:endDate IS NULL OR s.studyDate <= :endDate) AND " +
		       "(:reportStatus IS NULL OR s.reportStatus = :reportStatus) AND " +
		       "(:verifyFlag IS NULL OR s.verifyFlag = :verifyFlag)")
		List<StudyTab> searchStudies(@Param("pId") String pId,
		                             @Param("pName") String pName,
		                             @Param("modality") String modality,
		                             @Param("startDate") String startDate,
		                             @Param("endDate") String endDate,
		                             @Param("reportStatus") Long reportStatus,
		                             @Param("verifyFlag") Long verifyFlag);

	
}