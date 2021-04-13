package com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectImportDto {

    int id;

    String name;

    String key;

    String comment;

    String category;

    String subCategory;
    
}
