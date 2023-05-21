package com.subham.pdf_generation.controller;

import com.itextpdf.text.*;
import com.subham.pdf_generation.dto.*;
import com.subham.pdf_generation.service.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class PdfGenControllerTest {

    @InjectMocks
    PdfGenController pdfGenController;

    @Mock
    PdfGenService pdfGenService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Testing controller return type")
    void testGeneratePDF() throws DocumentException, FileNotFoundException {
        DataHolder dataHolder = new DataHolder(15.0, 10.0);

        when(pdfGenService.generateElectricBill(anyDouble(),anyDouble()))
                .thenReturn(150.0);
        ResponseEntity<String> result = pdfGenController.generatePDF(dataHolder);

        assertEquals("Electric bill of MAY, 2023 is ₹150.00", result.getBody());
    }
}