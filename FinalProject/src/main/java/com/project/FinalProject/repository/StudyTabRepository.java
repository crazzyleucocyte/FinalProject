package com.project.FinalProject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.FinalProject.domain.StudyTab;

@Repository
public interface StudyTabRepository extends JpaRepository<StudyTab, Long> {
	
	@Query("SELECT s FROM StudyTab s WHERE " +
		   "(:pId IS NULL OR s.pId LIKE CONCAT('%', :pId, '%')) AND " +
		   "(:pName IS NULL OR s.pName LIKE CONCAT('%', :pName, '%')) AND " +
		   "(:modality IS NULL OR s.modality = :modality) AND " +
		   "(:startDate IS NULL OR s.studyDate >= :startDate) AND " +
		   "(:endDate IS NULL OR s.studyDate <= :endDate) AND " +
		   "(:reportStatus IS NULL OR s.reportStatus = :reportStatus) AND " +
		   "(:verifyFlag IS NULL OR s.verifyFlag = :verifyFlag)")
	Page<StudyTab> searchStudies(@Param("pId") String pId,
		                         @Param("pName") String pName,
		                         @Param("modality") String modality,
		                         @Param("startDate") String startDate,
		                         @Param("endDate") String endDate,
		                         @Param("reportStatus") Long reportStatus,
		                         @Param("verifyFlag") Long verifyFlag,
								 Pageable pageable);
	
	
	
	@Query(value = "select * from STUDYTAB where PID = :pId order by STUDYDATE desc", nativeQuery = true)
	List<StudyTab> findByPIdOrderByStudyDateDesc(@Param("pId") String pId);

	List<StudyTab> findByPatientKey(Long patientKey);
	}