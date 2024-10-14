package com.project.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FinalProject.domain.StudyTab;

@Repository
public interface StudyTabRepository extends JpaRepository<StudyTab, Long> {
	
	

}
