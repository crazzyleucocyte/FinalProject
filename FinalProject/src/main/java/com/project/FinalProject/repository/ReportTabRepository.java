package com.project.FinalProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FinalProject.domain.ReportTab;


@Repository
public interface ReportTabRepository extends JpaRepository<ReportTab, Long> {

   Optional<ReportTab> findByStudyKey(Long studyKey);

}
