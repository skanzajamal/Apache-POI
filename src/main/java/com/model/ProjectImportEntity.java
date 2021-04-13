package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "project")
public class ProjectImportEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        int id;

        @Column(nullable = false, length = 64)
        String name;

        @Column(nullable = false, length = 64)
        String key;

        @Column(length = 2048)
        String comment;

        @Column(length = 16)
        String category;

        @Column(length = 16)
        String subCategory;
        
}
