package com.subham.pdf_generation.service;

import com.itextpdf.text.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PdfGenServiceTest {

    @InjectMocks
    PdfGenService pdfGenService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Testing Monthly Electric Bill")
    void generateElectricBill() throws DocumentException, FileNotFoundException {

        double expectedBill = 100.00;
        assertEquals(expectedBill, pdfGenService.generateElectricBill(10,10));
    }
}