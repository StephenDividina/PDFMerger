package com.mobigator;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PdfMergeTool {
    public static void main(String[] args) throws Exception {
//        PdfMergeTool.mergePdf(args);
//
        String[] pdfs = new String[3];
        pdfs[0] = "/Users/dev/Desktop/stephen.pdf";
        pdfs[1] = "/Users/dev/Desktop/Leave.pdf";
        pdfs[2] = "/Users/dev/Desktop/StackTrek.pdf";
        PdfMergeTool.mergePdf(pdfs);
    }

    static String mergePdf(String[] listData) throws Exception {
//        String date = new SimpleDateFormat("YYYY-MM-DD").format(new Date());
//        String time = new SimpleDateFormat("HHmmss").format(new Date());
//
//        String name = "REPORT_" + date + "-" + time + ".pdf";
        int index = listData[0].lastIndexOf('/');
        String name = listData[0].substring(listData[0].lastIndexOf('/') + 1);
        try{
            File file = new File(listData[0]);
            if (file.exists()){
                file.delete();
            } else {
                new File(listData[0].substring(0, index)).mkdirs();
            }
        }catch (Exception e){
            throw new Exception(e);
        }

        PDFMergerUtility mergerUtility = new PDFMergerUtility();

        for (int i = 1; i < listData.length; i++ ){
            mergerUtility.addSource(listData[i]);
        }

//        mergerUtility.setDestinationFileName(listData[0] + "/" + name);
        mergerUtility.setDestinationFileName(listData[0]);
        mergerUtility.mergeDocuments();

        return mergerUtility.getDestinationFileName();
    }
}
