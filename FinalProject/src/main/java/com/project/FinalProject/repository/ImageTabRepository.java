package com.project.FinalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.FinalProject.domain.ImageTab;
import com.project.FinalProject.domain.StudyTab;

@Repository
public interface ImageTabRepository extends JpaRepository<ImageTab, Long> {

	@Query(value="select * from IMAGETAB where STUDY_KEY = :studyKey and SERIES_KEY = :seriesKey and IMAGE_KEY = :imageKey", nativeQuery=true)
	String findByImageKey(@Param("studyKey")String studyKey,@Param("seriesKey") String seriesKey, @Param("imageKey")String imageKey);

	
	

}
