package com.etisalat.imrh.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import org.springframework.core.io.ClassPathResource;
import javax.script.ScriptException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface ReportService {

    // pdf
    public ByteArrayOutputStream fetchMtoPartnerCountryViewPdf() throws DocumentException, IOException;

    public ByteArrayOutputStream fetchMtoPartnerCountryWalletViewPdf() throws DocumentException, IOException;

    public ByteArrayOutputStream fetchMtoPartnerCountryCityViewPdf() throws DocumentException, IOException;

    public ByteArrayOutputStream fetchMtoPartnerCountryBankViewPdf() throws DocumentException, IOException;

    public ByteArrayOutputStream fetchAllGlobalCountryDetailForReportViewPdf() throws DocumentException, IOException;

    // xlsx
    public ByteArrayInputStream fetchMtoPartnerCountryViewXlsx() throws IOException, ScriptException;

    public ByteArrayInputStream fetchMtoPartnerCountryWalletViewXlsx() throws IOException, ScriptException;

    public ByteArrayInputStream fetchMtoPartnerCountryCityViewXlsx() throws IOException, ScriptException;

    public ByteArrayInputStream fetchMtoPartnerCountryBankViewXlsx() throws IOException, ScriptException;

    public ByteArrayInputStream fetchAllGlobalCountryDetailForReportViewXlsx() throws IOException, ScriptException;

    public default String getResourcePath(String path) {
        return new ClassPathResource(path).getPath();
    }

    public default void addHeaderImage(String imagePath, Document document) throws IOException, DocumentException {
        // Add image on the document
        Image image = Image.getInstance(imagePath);
        image.scaleToFit(90f, 90f);
        image.setAlignment(Image.MIDDLE);
        image.setAbsolutePosition(20, 780);
        image.scaleAbsolute(100, 40);
        document.add(image);
    }

    public default void addHeadingDetail(String title, String subTitle, Document document) throws DocumentException {
        // main title detail
        Paragraph titleParagraph = new Paragraph(title, FontFactory.getFont(FontFactory.HELVETICA,
            14, com.itextpdf.text.Font.BOLD, new BaseColor(0, 0, 0)));
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        // sub title detail
        Paragraph subTitleParagraph = new Paragraph(subTitle, FontFactory.getFont(FontFactory.HELVETICA,
            10, com.itextpdf.text.Font.UNDERLINE, new BaseColor(0, 0, 0)));
        subTitleParagraph.setAlignment(Element.ALIGN_CENTER);
        // space detail
        Paragraph spaceParagraph = new Paragraph("\n\n");
        document.add(titleParagraph);
        document.add(subTitleParagraph);
        document.add(spaceParagraph);
    }

    public default Font getFont() {
        return FontFactory.getFont(FontFactory.HELVETICA, 8);
    }

    public default PdfPTable getPdfPTable(Integer numColumns) {
        // Create table and set the width of columns
        PdfPTable pdfPTable = new PdfPTable(numColumns);
        pdfPTable.setWidthPercentage(100.0f);
        pdfPTable.setSpacingBefore(5);
        return pdfPTable;
    }

}