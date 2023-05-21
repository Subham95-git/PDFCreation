package com.subham.pdf_generation.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.time.*;

public class PdfGenUtil {


    public static void createPDF(double bill) throws FileNotFoundException, DocumentException {

        //fetching current date
        LocalDate currentdate = LocalDate.now();

        //fetching month
        Month month = currentdate.getMonth();

        //fetching year
        int year = currentdate.getYear();

        //creating document object
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("./bill/ElectricityBill-"+month+"-"+year+".pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 22, BaseColor.GREEN);

        //adding pdf text
        document.add(new Chunk("Electric Bill of "+month+", "+year+" is ₹"+bill));
        document.close();
    }
}
