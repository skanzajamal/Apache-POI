package com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class EmployeeImportDto {

    int id;

    private String jobTitle;

    private String department;

    private String businessUnit;

    private String gender;

    private String hireDate;   //timestamp

    private String annualSalary;

    private String bonus;

    private String country;

    private String city;

    private String exitDate;   //timestamp
    
} //ENDLCLASS
