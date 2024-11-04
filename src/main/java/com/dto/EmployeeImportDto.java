package com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeImportDto {

    private int id;

    private String fullName;

    private String jobTitle;

    private String department;

    private String businessUnit;

    private String gender;

    private Integer age;

    private String hireDate;   //timestamp

    private String annualSalary;

    private String bonus;

    private String country;

    private String city;

    private String exitDate;   //timestamp
    
} //ENDLCLASS
