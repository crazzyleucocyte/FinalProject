package com.project.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FinalProject.domain.SeriesTab;

@Repository
public interface SeriesTabRepository extends JpaRepository<SeriesTab, Long>{

}
