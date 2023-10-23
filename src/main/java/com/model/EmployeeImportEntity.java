package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee_import")
public class EmployeeImportEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private int id;

        @Column(nullable = false, length = 64)
        private String jobTitle;

        @Column(nullable = false, length = 64)
        private String department;

        @Column(nullable = false, length = 64)
        private String businessUnit;

        @Column
        private String gender;

        @Column(nullable = false, length = 256)
        private String hireDate;   //timestamp

        @Column
        private String annualSalary;

        @Column
        private String bonus;

        @Column(nullable = false, length = 64)
        private String country;

        @Column(nullable = false, length = 64)
        private String city;

        @Column
        private String exitDate;   //timestamp

} //ENDCLASS
