package com.dto;

import com.model.EmployeeImportEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DtoConverter {

    public static EmployeeImportDto toDto(EmployeeImportEntity entity){
        EmployeeImportDto dto = new EmployeeImportDto();
        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        dto.setJobTitle(entity.getJobTitle());
        dto.setDepartment(entity.getDepartment());
        dto.setBusinessUnit(entity.getBusinessUnit());
        dto.setGender(entity.getGender());
        dto.setAge(entity.getAge());
        dto.setHireDate(entity.getHireDate());
        dto.setAnnualSalary(entity.getAnnualSalary());
        dto.setBonus(entity.getBonus());
        dto.setCountry(entity.getCountry());
        dto.setCity(entity.getCity());
        dto.setExitDate(entity.getExitDate());
        return dto;
    }

    public static List<EmployeeImportDto> toDtoList(List<EmployeeImportEntity> entities){
        return entities.stream().map(DtoConverter::toDto).collect(Collectors.toList());
    }
}
