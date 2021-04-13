package com.repository;

import com.model.ProjectImportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectImportRepository extends JpaRepository<ProjectImportEntity, String> {
}
