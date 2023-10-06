package com.service;

import com.dto.EmployeeImportDto;
import com.model.EmployeeImportEntity;
import com.repository.EmployeeImportRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DataModelService {
    
    @Autowired
    EmployeeImportRepository employeeImportRepository;

    public EmployeeImportDto importResults(MultipartFile multipartFile)
    {
        EmployeeImportDto importResult = new EmployeeImportDto();
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

    public EmployeeImportDto importResults(Workbook workbook, EmployeeImportDto importResult) {

        // the data are on the first sheet
        Sheet dataSheet = workbook.getSheetAt(0);

        boolean isHeader = true; // ignore the first row

        for (Row row: dataSheet){
            if(!isHeader){
                EmployeeImportDto importDbEmployeeDto = parseAndCheck(row);
                if(importDbEmployeeDto != null) {
                    addEmployeeImport(importDbEmployeeDto);
                }
            }
            isHeader = false;
        }
        return importResult;
    }


    public EmployeeImportDto parseAndCheck (Row row){
        EmployeeImportDto dto = new EmployeeImportDto();
        DataFormatter dataFormatter = new DataFormatter();
        dto.setJobTitle(dataFormatter.formatCellValue(row.getCell(0)));
        dto.setDepartment(dataFormatter.formatCellValue(row.getCell(1)));
        dto.setBusinessUnit(dataFormatter.formatCellValue(row.getCell(2)));
        dto.setGender((dataFormatter.formatCellValue(row.getCell(3))));
        dto.setHireDate(dataFormatter.formatCellValue(row.getCell(4)));
        dto.setAnnualSalary(dataFormatter.formatCellValue(row.getCell(5)));
        dto.setBonus(dataFormatter.formatCellValue(row.getCell(6)));
        dto.setCountry(dataFormatter.formatCellValue(row.getCell(7)));
        dto.setCity(dataFormatter.formatCellValue(row.getCell(8)));
        dto.setExitDate(dataFormatter.formatCellValue(row.getCell(9)));
        return dto;
    }

    private void addEmployeeImport(EmployeeImportDto employeeImportDto) {
        EmployeeImportEntity employeeImportEntity = new EmployeeImportEntity();
        BeanUtils.copyProperties(employeeImportDto, employeeImportEntity);
        employeeImportRepository.save(employeeImportEntity);
    }

    public List<EmployeeImportEntity> getImportResult(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return employeeImportRepository.findAll(pageable).getContent();
    }

} //ENDCLASS
