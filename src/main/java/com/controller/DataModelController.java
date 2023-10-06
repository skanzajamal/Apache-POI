package com.controller;

import com.model.EmployeeImportEntity;
import com.service.DataModelService;
import com.dto.EmployeeImportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/fileImport")
public class DataModelController {
    
    @Autowired
    DataModelService dataModelService;
    
    @PostMapping(path = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @NotNull
    public EmployeeImportDto importResults(@RequestPart MultipartFile file) {
        return dataModelService.importResults(file);
    }

    // test function to verify if the data has been added from excelFile to database
    @GetMapping(path = "/getImportResult", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeImportEntity> getResult(@RequestParam("page") int page, @RequestParam("size") int size) {
        return dataModelService.getImportResult(page, size);
    }

}
