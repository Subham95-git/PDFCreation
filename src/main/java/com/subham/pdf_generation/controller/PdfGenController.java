package com.subham.pdf_generation.controller;

import com.itextpdf.text.*;
import com.subham.pdf_generation.dto.*;
import com.subham.pdf_generation.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.time.*;

@RestController
@RequestMapping("/api/v1")
public class PdfGenController {

    @Autowired
    PdfGenService pdfGenService;

    @GetMapping("/generatepdf")
    public ResponseEntity<String> generatePDF(@RequestBody DataHolder dataHolder) throws DocumentException, FileNotFoundException {

        //fetching current date
        LocalDate currentdate = LocalDate.now();

        //fetching month
        Month month = currentdate.getMonth();

        //fetching year
        int year = currentdate.getYear();

        double electricBill = pdfGenService.generateElectricBill(dataHolder.getUnit(), dataHolder.getPricePerUnit());
        return ResponseEntity.status(200).body(String.format("Electric bill of %s, %d is ₹%.2f",month, year, electricBill));
    }
}
