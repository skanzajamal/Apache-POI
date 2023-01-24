package com.repository;

import com.model.ProjectImportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectImportRepository extends JpaRepository<ProjectImportEntity, String> {

}
