package com.subham.pdf_generation.service;

import com.itextpdf.text.*;
import com.subham.pdf_generation.util.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class PdfGenService {

    public double generateElectricBill(double unit, double pricePerUnit) throws DocumentException, FileNotFoundException {

        //calculating monthly electric bill
        double eletricBill = unit * pricePerUnit;

        //create pdf with electric bill
        PdfGenUtil.createPDF(eletricBill);
        return eletricBill;
    }
}
