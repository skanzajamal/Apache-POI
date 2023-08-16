package com.controller;

import com.FileImportApplicationTest;
import com.repository.ProjectImportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
public class DataModelControllerTest extends FileImportApplicationTest {

    @Autowired
    DataModelController dataModelController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    ProjectImportRepository projectImportRepository;

    @Test
    public void test() throws Exception {

        MockMultipartFile fileImport = new MockMultipartFile("filename", "Book.xlsx", "application/vnd.ms-excel", new ClassPathResource("Book.xlsx").getInputStream());
        Assertions.assertNotNull(fileImport);

        MockMvc mockMvc = MockMvcBuilders.
                webAppContextSetup(webApplicationContext).build();

//        mockMvc.perform(MockMvcRequestBuilders
//                .multipart("/fileImport/import")
//                .file(fileImport)
//                .param("file", "Book.xlsx"))
//                .andExpect(status().is(200));

        var result = dataModelController.importResults(fileImport);
        Assertions.assertNotNull(result);

        var checkIfFileImported = dataModelController.getResult();
        Assertions.assertFalse(checkIfFileImported.isEmpty());

    }

} //ENDCLASS
