package dev.fujiwara.drawer.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;

import java.io.*;
import java.util.List;

public class Concatenator {

    private Concatenator() {

    }

    public static void concatenate(List<String> srcFiles, String outFile)
            throws DocumentException, IOException {
        try(OutputStream os = new FileOutputStream(outFile)){
            concatenate(srcFiles, os);
        }
    }

    public static void concatenate(List<String> srcFiles, OutputStream ostream)
            throws DocumentException, IOException {
        Document doc = new Document();
        PdfCopy copy = new PdfCopy(doc, ostream);
        doc.open();
        for (String fileName : srcFiles) {
            InputStream fin = new FileInputStream(fileName);
            PdfReader reader = new PdfReader(fin);
            copy.addDocument(reader);
            copy.freeReader(reader);
            reader.close();
        }
        doc.close();
    }

}
