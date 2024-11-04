package com.specification;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SearchRequest {

    private String fullName;

    private String jobTitle;

    private String department;

    private String businessUnit;
}
