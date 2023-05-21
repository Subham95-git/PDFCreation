package com.subham.pdf_generation.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.io.*;
import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

class PdfGenUtilTest {

    @InjectMocks
    PdfGenUtil pdfGenUtil;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePDF() throws DocumentException, IOException {

        //fetching current date
        LocalDate currentdate = LocalDate.now();

        //fetching month
        Month month = currentdate.getMonth();

        //fetching year
        int year = currentdate.getYear();

        PdfGenUtil.createPDF(100);

        PdfReader pdfReader = new PdfReader("./bill/ElectricityBill-"+month+"-"+year+".pdf");
        String actualText = PdfTextExtractor.getTextFromPage(pdfReader,1);

        String expectedText = "Electric Bill of "+month+", "+year+" is 100.0";

        assertEquals(expectedText, actualText);
    }
}