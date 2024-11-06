package com.project.FinalProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.FinalProject.domain.ImageTab;
import com.project.FinalProject.domain.StudyTab;

@Repository
public interface ImageTabRepository extends JpaRepository<ImageTab, Long> {
	
	// 스터디 키와 시리즈 키로 이미지를 조회하는 쿼리
    @Query("SELECT i FROM ImageTab i WHERE i.studyKey = :studyKey AND i.seriesKey = :seriesKey ORDER BY i.studyKey, i.seriesKey")
    List<ImageTab> findByStudyKeyAndSeriesKey(@Param("studyKey") Long studyKey, @Param("seriesKey") Long seriesKey);
    

	// 스터디 키와 시리즈 키로 이미지를 조회할때 curSeqNum으로 정렬
    List<ImageTab> findByStudyKeyAndSeriesKeyOrderByCurSeqNumAsc(Long studyKey, Long seriesKey);
		//OrderByCurSeqNumAsc : curSeqNum 기준으로 오름차순 정렬하여 이미지를 반환하겠다는 의미

    // studyKey, seriesKey, curSeqNum 조건으로 첫 번째 이미지 찾기
    @Query("SELECT i FROM ImageTab i WHERE i.studyKey = :studyKey AND i.seriesKey = :seriesKey ORDER BY i.curSeqNum ASC")
    List<ImageTab> findTopByStudyKeyAndSeriesKeyOrderByCurSeqNumAsc(
            @Param("studyKey") Long studyKey, 
            @Param("seriesKey") Long seriesKey
            );
    
    
    }