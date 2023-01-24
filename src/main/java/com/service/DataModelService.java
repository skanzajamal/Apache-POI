package com.service;

import com.dto.ProjectImportDto;
import com.model.ProjectImportEntity;
import com.repository.ProjectImportRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class DataModelService {
    
    @Autowired
    ProjectImportRepository projectImportRepository;

    public ProjectImportDto importResults(MultipartFile multipartFile)
    {
        ProjectImportDto importResult = new ProjectImportDto();
        Workbook workbook = null;
        try{
            workbook = WorkbookFactory.create(multipartFile.getInputStream());
            importResult = importResults(workbook, importResult);
        }catch (Exception ex) {
            ex.getLocalizedMessage();
        }
        if(workbook != null) {
            try {
                workbook.close();
            } catch (IOException ignored) {
            }
        }

        return importResult;
    }

    public ProjectImportDto importResults(Workbook workbook, ProjectImportDto importResult) {

        // the data are on the first sheet
        Sheet dataSheet = workbook.getSheetAt(0);

        boolean isHeader = true; // ignore the first row

        for (Row row: dataSheet){
            if(!isHeader){
                ProjectImportDto importDbProjectDto = parseAndCheck(row);
                if(importDbProjectDto != null) {
                    addProjectImport(importDbProjectDto);
                }
            }
            isHeader = false;
        }
        return importResult;
    }


    public ProjectImportDto parseAndCheck (Row row){
        ProjectImportDto dto = new ProjectImportDto();
        DataFormatter dataFormatter = new DataFormatter();
        dto.setKey(dataFormatter.formatCellValue(row.getCell(0)));
        dto.setName(dataFormatter.formatCellValue(row.getCell(1)));
        dto.setCategory(dataFormatter.formatCellValue(row.getCell(2)));
        dto.setComment((dataFormatter.formatCellValue(row.getCell(3))));
        dto.setSubCategory(dataFormatter.formatCellValue(row.getCell(4)));
        return dto;
    }

    private void addProjectImport(ProjectImportDto projectImportDto)
    {
        ProjectImportEntity projectImportEntity = new ProjectImportEntity();
        BeanUtils.copyProperties(projectImportDto, projectImportEntity);
        projectImportRepository.save(projectImportEntity);

    }
}
