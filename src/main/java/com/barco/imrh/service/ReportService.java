package com.barco.imrh.service;

import com.barco.imrh.enums.Report;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.core.io.ClassPathResource;
import javax.script.ScriptException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface ReportService {

    public Map<String, Object> parameters = new HashMap<>();
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

    public byte[] downloadJasperFile(Report report) throws JRException;

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

    /**
     * Method use to get the jasper report from the source path
     * @param report
     * @return JasperReport
     * */
    public default JasperReport getJasperReport(Report report) throws JRException {
        String reportName = null;
        if (report.equals(Report.MtoPartnerCountryReport)) {
            reportName ="/report/mto_partner_country_report.jrxml";
        } else if (report.equals(Report.MtoPartnerCountryCityReport)) {
            reportName ="/report/mto_partner_country_city_report.jrxml";
        } else if (report.equals(Report.MtoPartnerCountryWalletReport)) {
            reportName ="/report/mto_partner_country_wallet_report.jrxml";
        } else if (report.equals(Report.MtoPartnerCountryBankReport)) {
            reportName ="/report/mto_partner_country_bank_report.jrxml";
        } else if (report.equals(Report.GlobalCountryDetailReport)) {
            reportName ="/report/all_global_country_detail_for_report.jrxml";
        }
        return JasperCompileManager.compileReport(getClass().getResourceAsStream(reportName));
    }

    /**
     * Method use to get the jasper report title and sub-title
     * @param report
     * @return Map<String, Object>
     * */
    public default Map<String, Object> getParameters(Report report){
        parameters.put("subTitle", "Ministry of Interior Qatar");
        if (report.equals(Report.MtoPartnerCountryReport)) {
            parameters.put("title", "MtoPartner Country Report");
        } else if (report.equals(Report.MtoPartnerCountryCityReport)) {
            parameters.put("title", "MtoPartner Country City Report");
        } else if (report.equals(Report.MtoPartnerCountryWalletReport)) {
            parameters.put("title", "MtoPartner Country Wallet Report");
        } else if (report.equals(Report.MtoPartnerCountryBankReport)) {
            parameters.put("title", "MtoPartner Country Bank Report");
        } else if (report.equals(Report.GlobalCountryDetailReport)) {
            parameters.put("title", "Global Country Detail Report");
        }
        return parameters;
    }

}