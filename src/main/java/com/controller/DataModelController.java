package com.controller;

import com.dto.DtoConverter;
import com.service.DataModelService;
import com.dto.EmployeeImportDto;
import com.specification.SearchRequest;
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

    @NotNull
    @PostMapping(path = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeImportDto importResults(@RequestPart MultipartFile file) {
        return dataModelService.importResults(file);
    }

    // test function to verify if the data has been added from excelFile to database

    @GetMapping(path = "/getImportResult", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeImportDto> getResult(
            @RequestParam("page") int page, @RequestParam("size") int size) {
        return DtoConverter.toDtoList(dataModelService.getImportResult(page, size));
    }

    //get record based on filter

    @GetMapping(path = "/filterResult", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeImportDto> getImportResultByFilter(
            @RequestParam(value = "fullName", required = false) String fullName,
            @RequestParam(value = "jobTitle", required = false) String jobTitle,
            @RequestParam(value = "department", required = false) String department,
            @RequestParam(value = "businessUnit", required = false) String businessUnit)
    {
        SearchRequest request = new SearchRequest(fullName, jobTitle, department, businessUnit);
        return DtoConverter.toDtoList(dataModelService.getFilteredResult(request));
    }

} //ENDCLASS
