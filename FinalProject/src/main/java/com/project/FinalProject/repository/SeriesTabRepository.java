package com.project.FinalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.project.FinalProject.domain.SeriesTab;

@Repository
public interface SeriesTabRepository extends JpaRepository<SeriesTab, Long>{

	// studyKey를 기준으로 시리즈 번호를 조회하는 쿼리
	@Query("SELECT s FROM SeriesTab s WHERE s.studyKey = :studyKey")
	List<SeriesTab> findByStudyKey(@Param("studyKey") String studyKey);
	}
