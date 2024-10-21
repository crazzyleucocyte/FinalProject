package com.project.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FinalProject.domain.PatientTab;

@Repository
public interface PatientTabRepository extends JpaRepository<PatientTab, String>{

}
