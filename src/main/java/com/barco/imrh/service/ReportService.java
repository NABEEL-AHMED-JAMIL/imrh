package com.barco.imrh.service;

import com.barco.imrh.enums.Report;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import javax.script.ScriptException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nabeel Ahmed
 */
public interface ReportService {

    public static final Integer MARGIN = 20;
    public static final String MOI_IMAGE_PATH = "${moiImagePath}";
    public static final String ETISALAT_IMAGE_PATH = "${etisalatImagePath}";
    public static final String JAVA_SCRIPT = "JavaScript";
    public static final String CELL_SIZE_20_225= "20*255";
    public static final String PARTNER_ID = "Partner Id";
    public static final String PARTNER_NAME = "Partner Name";
    public static final String COUNTRY_CODE = "Country Code";
    public static final String COUNTRY_NAME = "Country Name";
    public static final String CITY_ID = "City Id";
    public static final String CITY_NAME = "City Name";
    public static final String CITY_STATUS = "City Status";
    public static final String WALLET_ID = "Wallet Id";
    public static final String WALLET_NAME = "Wallet Name";
    public static final String WALLET_ENABLED = "Wallet Enabled";
    public static final String BANK_ID = "Bank Id";
    public static final String BANK_NAME = "Bank Name";
    public static final String BANK_ENABLED = "Bank Enabled";
    public static final String COUNTRY_STATUS = "Country Status";
    public static final String TOTAL_CITY = "Total City";
    public static final String TOTAL_WALLET = "Total Wallet";
    public static final String TOTAL_BANK = "Total Bank";
    public static final String TITLE = "title";
    public static final String SUB_TITLE = "subTitle";
    public static final String IMAGE_PATH = "imagePath";
    public static final String ITEM_DATA_SOURCE = "itemDataSource";
    public static final String USER_DETAIL = "userDetail";
    public static final String MTO_PARTNER_COUNTRY_REPORT_SHEET = "MtoPartner Country Report";
    public static final String MTO_PARTNER_COUNTRY_WALLET_REPORT_SHEET = "MtoPartner Country Wallet Report";
    public static final String MTO_PARTNER_COUNTRY_CITY_REPORT_SHEET = "MtoPartner Country City Report";
    public static final String MTO_PARTNER_COUNTRY_BANK_REPORT_SHEET = "MtoPartner Country Bank Report";
    public static final String GLOBAL_COUNTRY_DETAIL_REPORT_SHEET = "Global Country Detail Report";
    public static final String MTO_PARTNER_COUNTRY_REPORT_ERROR = "### An error occurred while export MtoPartner Country Report ### ";
    public static final String MTO_PARTNER_COUNTRY_WALLET_REPORT_ERROR = "### An error occurred while export MtoPartner Country Wallet Report ### ";
    public static final String MTO_PARTNER_COUNTRY_CITY_REPORT_ERROR = "### An error occurred while export MtoPartner Country City Report ### ";
    public static final String MTO_PARTNER_COUNTRY_BANK_REPORT_ERROR = "### An error occurred while export MtoPartner Country Bank Report ### ";
    public static final String ALL_GLOBAL_COUNTRY_DETAIL_REPORT_ERROR = "### An error occurred while export All Global Country Detail Report ### ";
    public static final String DOWNLOAD_JASPER_FILE_ERROR = "### An error occurred while export downloadJasperFile ### ";

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
    public default JasperReport getJasperReport(Report report, boolean isCompiled) throws JRException {
        String reportName = null;
        if (report.equals(Report.MtoPartnerCountryReport)) {
            reportName = isCompiled == true ? Report.MtoPartnerCountryReport.reportPathJasper : Report.MtoPartnerCountryReport.reportPathJrXml;
        } else if (report.equals(Report.MtoPartnerCountryCityReport)) {
            reportName = isCompiled == true ? Report.MtoPartnerCountryCityReport.reportPathJasper : Report.MtoPartnerCountryCityReport.reportPathJrXml;
        } else if (report.equals(Report.MtoPartnerCountryWalletReport)) {
            reportName = isCompiled == true ? Report.MtoPartnerCountryWalletReport.reportPathJasper : Report.MtoPartnerCountryWalletReport.reportPathJrXml;
        } else if (report.equals(Report.MtoPartnerCountryBankReport)) {
            reportName = isCompiled == true ? Report.MtoPartnerCountryBankReport.reportPathJasper : Report.MtoPartnerCountryBankReport.reportPathJrXml;
        } else if (report.equals(Report.GlobalCountryDetailReport)) {
            reportName = isCompiled == true ? Report.GlobalCountryDetailReport.reportPathJasper : Report.GlobalCountryDetailReport.reportPathJrXml;
        }
        return isCompiled == true ? (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream(reportName)) :
                JasperCompileManager.compileReport(getClass().getResourceAsStream(reportName));
    }

    /**
     * Method use to get the jasper report title and sub-title
     * @param report
     * @return Map<String, Object>
     * */
    public default Map<String, Object> getParameters(Report report){
        Map<String, Object> parameters = new HashMap<>();
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