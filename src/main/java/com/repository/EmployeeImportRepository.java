package com.repository;

import com.model.EmployeeImportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeImportRepository extends JpaRepository<EmployeeImportEntity, String> {

}
