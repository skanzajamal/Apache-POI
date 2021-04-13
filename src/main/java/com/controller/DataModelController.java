package com.controller;

import com.service.DataModelService;
import com.dto.ProjectImportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
public class DataModelController {
    
    @Autowired
    DataModelService dataModelService;
    
    @PostMapping(path = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @NotNull
    public ProjectImportDto importResults(@RequestPart MultipartFile file) {
        return dataModelService.importResults(file);
    }
}
