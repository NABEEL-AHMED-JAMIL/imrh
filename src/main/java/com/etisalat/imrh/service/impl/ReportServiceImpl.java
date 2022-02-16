package com.etisalat.imrh.service.impl;

import com.etisalat.imrh.repository.query.EntityQuery;
import com.etisalat.imrh.repository.view.*;
import com.etisalat.imrh.service.ReportService;
import com.etisalat.imrh.util.PoiWorkBookUtil;
import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * @author Nabeel Ahmed
 */
@Service
public class ReportServiceImpl extends PoiWorkBookUtil implements ReportService {

    public Logger logger = LogManager.getLogger(ReportServiceImpl.class);

    @Autowired
    private EntityQuery entityQuery;
    private ScriptEngine engine;
    private Map<String, List<Report>> reportDetail = new HashMap<>();
    private String imagePath = "https://firebasestorage.googleapis.com/v0/b/imrh-7db21.appspot.com/o/etisalat-logo-vector.png?alt=media";

    {
        ScriptEngineManager mgr = new ScriptEngineManager();
        this.engine = mgr.getEngineByName("JavaScript");

        int count = 0;
        List<Report> reports = new ArrayList<>();
        reports.add(new Report(count, "Partner Id", "20*255"));
        reports.add(new Report(count++, "Partner Name", "20*255"));
        reports.add(new Report(count++, "Country Code", "20*255"));
        reports.add(new Report(count++, "Country Name", "20*255"));
        reports.add(new Report(count++, "Wallet Id", "20*255"));
        reports.add(new Report(count++, "Wallet Name", "20*255"));
        reports.add(new Report(count++, "Wallet Enabled", "20*255"));
        this.reportDetail.put("fetch_mto_partner_country_wallet_view", reports);

        reports = new ArrayList<>();
        reports.add(new Report(0, "Partner Id", "20*255"));
        reports.add(new Report(1, "Partner Name", "20*255"));
        reports.add(new Report(2, "Country Name", "20*255"));
        this.reportDetail.put("fetch_mto_partner_country_view", reports);

        reports = new ArrayList<>();
        reports.add(new Report(0, "Partner Id", "20*255"));
        reports.add(new Report(1, "Partner Name", "20*255"));
        reports.add(new Report(2, "Country Code", "20*255"));
        reports.add(new Report(3, "Country Name", "20*255"));
        reports.add(new Report(4, "City Id", "20*255"));
        reports.add(new Report(5, "City Name", "20*255"));
        reports.add(new Report(6, "City Status", "20*255"));
        this.reportDetail.put("fetch_mto_partner_country_city_view", reports);

        reports = new ArrayList<>();
        reports.add(new Report(0, "Partner Id", "20*255"));
        reports.add(new Report(1, "Partner Name", "20*255"));
        reports.add(new Report(2, "Country Code", "20*255"));
        reports.add(new Report(3, "Country Name", "20*255"));
        reports.add(new Report(4, "Bank Id", "20*255"));
        reports.add(new Report(5, "Bank Name", "20*255"));
        reports.add(new Report(6, "Bank Enabled", "20*255"));
        this.reportDetail.put("fetch_mto_partner_country_bank_view", reports);

        reports = new ArrayList<>();
        reports.add(new Report(0,"Country Name", "20*255"));
        reports.add(new Report(1,"Country Code", "20*255"));
        reports.add(new Report(2,"Country Status", "20*255"));
        reports.add(new Report(3,"Total City", "20*255"));
        reports.add(new Report(4,"Total Wallet", "20*255"));
        reports.add(new Report(5,"Total Bank", "20*255"));
        this.reportDetail.put("fetch_all_global_country_detail_for_report_view", reports);
    }

    public ByteArrayOutputStream fetchMtoPartnerCountryViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, 20, 20, 20, 20);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.imagePath, document);
            this.addHeadingDetail("MtoPartner Country Report", "Emirates Telecommunication Group Company", document);
            //===============================Header-Field======================
            List<Report> mtoPartnerCountryReportDetail = this.reportDetail.get("fetch_mto_partner_country_view");
            PdfPTable pdfPTable = this.getPdfPTable(mtoPartnerCountryReportDetail.size());
            com.itextpdf.text.Font font = this.getFont();
            mtoPartnerCountryReportDetail.forEach(report -> {
                PdfPCell pdfHeaderCell = new PdfPCell();
                pdfHeaderCell.setPadding(1);
                pdfHeaderCell.setGrayFill(0.7f);
                pdfHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfHeaderCell.setPhrase(new Phrase(report.getFiledName(), font));
                pdfHeaderCell.setBorderWidth(0.5f);
                pdfPTable.addCell(pdfHeaderCell);
            });
            List<FetchMtoPartnerCountryView> fetchMtoPartnerCountryViews = this.entityQuery.executeQuery(
                    "select * from fetch_mto_partner_country_view", FetchMtoPartnerCountryView.class);
            for (FetchMtoPartnerCountryView fetchMtoPartnerCountry: fetchMtoPartnerCountryViews) {
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountry.getPartnerId()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountry.getPartnerName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountry.getCountryName()), font)));
            }
            document.add(pdfPTable);
            return byteArrayOutputStream;
        } catch (Exception ex) {
            logger.error("### An error occurred while export MtoPartner Country Report ### ", ex);
            throw ex;
        } finally {
            if (writer != null) {
                writer.flush();
            }
            if (document != null) {
                document.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    public ByteArrayOutputStream fetchMtoPartnerCountryWalletViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, 20, 20, 20, 20);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.imagePath, document);
            this.addHeadingDetail("MtoPartner Country Wallet Report", "Emirates Telecommunication Group Company", document);
            //===============================Header-Field======================
            List<Report> mtoPartnerCountryWalletReportDetail = this.reportDetail.get("fetch_mto_partner_country_wallet_view");
            PdfPTable pdfPTable = this.getPdfPTable(mtoPartnerCountryWalletReportDetail.size());
            com.itextpdf.text.Font font = this.getFont();
            mtoPartnerCountryWalletReportDetail.forEach(report -> {
                PdfPCell pdfHeaderCell = new PdfPCell();
                pdfHeaderCell.setPadding(1);
                pdfHeaderCell.setGrayFill(0.7f);
                pdfHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfHeaderCell.setPhrase(new Phrase(report.getFiledName(), font));
                pdfHeaderCell.setBorderWidth(0.5f);
                pdfPTable.addCell(pdfHeaderCell);
            });
            List<FetchMtoPartnerCountryWalletView> fetchMtoPartnerCountryWalletViewLis = this.entityQuery.executeQuery(
                "select * from fetch_mto_partner_country_wallet_view", FetchMtoPartnerCountryWalletView.class);
            for (FetchMtoPartnerCountryWalletView fetchMtoPartnerCountryWallet: fetchMtoPartnerCountryWalletViewLis) {
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryWallet.getPartnerId()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryWallet.getPartnerName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryWallet.getCountryCode()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryWallet.getCountryName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryWallet.getWalletId()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryWallet.getWalletName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryWallet.getWalletEnabled()), font)));
            }
            document.add(pdfPTable);
            return byteArrayOutputStream;
        } catch (Exception ex) {
            logger.error("### An error occurred while export MtoPartner Country Wallet Report ### ", ex);
            throw ex;
        } finally {
            if (writer != null) {
                writer.flush();
            }
            if (document != null) {
                document.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    public ByteArrayOutputStream fetchMtoPartnerCountryCityViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, 20, 20, 20, 20);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.imagePath, document);
            this.addHeadingDetail("MtoPartner Country City Report", "Emirates Telecommunication Group Company", document);
            //===============================Header-Field======================
            List<Report> mtoPartnerCountryCityReportDetail = this.reportDetail.get("fetch_mto_partner_country_city_view");
            PdfPTable pdfPTable = this.getPdfPTable(mtoPartnerCountryCityReportDetail.size());
            com.itextpdf.text.Font font = this.getFont();
            mtoPartnerCountryCityReportDetail.forEach(report -> {
                PdfPCell pdfHeaderCell = new PdfPCell();
                pdfHeaderCell.setPadding(1);
                pdfHeaderCell.setGrayFill(0.7f);
                pdfHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfHeaderCell.setPhrase(new Phrase(report.getFiledName(), font));
                pdfHeaderCell.setBorderWidth(0.5f);
                pdfPTable.addCell(pdfHeaderCell);
            });
            List<FetchMtoPartnerCountryCityView> fetchMtoPartnerCountryCityViews = this.entityQuery.executeQuery(
                "select * from fetch_mto_partner_country_city_view", FetchMtoPartnerCountryCityView.class);
            for (FetchMtoPartnerCountryCityView fetchMtoPartnerCountryCity: fetchMtoPartnerCountryCityViews) {
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryCity.getPartnerId()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryCity.getPartnerName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryCity.getCountryCode()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryCity.getCountryName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryCity.getCityId()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryCity.getCityName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryCity.getCityEnabled()), font)));
            }
            document.add(pdfPTable);
            return byteArrayOutputStream;
        } catch (Exception ex) {
            logger.error("### An error occurred while export MtoPartner Country City Report ### ", ex);
            throw ex;
        } finally {
            if (writer != null) {
                writer.flush();
            }
            if (document != null) {
                document.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    public ByteArrayOutputStream fetchMtoPartnerCountryBankViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, 20, 20, 20, 20);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.imagePath, document);
            this.addHeadingDetail("MtoPartner Country Bank Report", "Emirates Telecommunication Group Company", document);
            //===============================Header-Field======================
            List<Report> mtoPartnerCountryBankReportDetail = this.reportDetail.get("fetch_mto_partner_country_bank_view");
            PdfPTable pdfPTable = this.getPdfPTable(mtoPartnerCountryBankReportDetail.size());
            com.itextpdf.text.Font font = this.getFont();
            mtoPartnerCountryBankReportDetail.forEach(report -> {
                PdfPCell pdfHeaderCell = new PdfPCell();
                pdfHeaderCell.setPadding(1);
                pdfHeaderCell.setGrayFill(0.7f);
                pdfHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfHeaderCell.setPhrase(new Phrase(report.getFiledName(), font));
                pdfHeaderCell.setBorderWidth(0.5f);
                pdfPTable.addCell(pdfHeaderCell);
            });
            List<FetchMtoPartnerCountryBankView> fetchMtoPartnerCountryBankViewList = this.entityQuery.executeQuery(
                "select * from fetch_mto_partner_country_bank_view", FetchMtoPartnerCountryBankView.class);
            for (FetchMtoPartnerCountryBankView fetchMtoPartnerCountryBankView: fetchMtoPartnerCountryBankViewList) {
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryBankView.getPartnerId()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryBankView.getPartnerName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryBankView.getCountryCode()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryBankView.getCountryName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryBankView.getBankId()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryBankView.getBankName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountryBankView.getBankEnabled()), font)));
            }
            document.add(pdfPTable);
            return byteArrayOutputStream;
        } catch (Exception ex) {
            logger.error("### An error occurred while export MtoPartner Country Bank Report ### ", ex);
            throw ex;
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
            if (document != null) {
                document.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    public ByteArrayOutputStream fetchAllGlobalCountryDetailForReportViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, 20, 20, 20, 20);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.imagePath, document);
            this.addHeadingDetail("Global Country Detail Report", "Emirates Telecommunication Group Company", document);
            //===============================Header-Field======================
            List<Report> globalCountryDetailReportDetail = this.reportDetail.get("fetch_all_global_country_detail_for_report_view");
            PdfPTable pdfPTable = this.getPdfPTable(globalCountryDetailReportDetail.size());
            com.itextpdf.text.Font font = this.getFont();
            globalCountryDetailReportDetail.forEach(report -> {
                PdfPCell pdfHeaderCell = new PdfPCell();
                pdfHeaderCell.setPadding(1);
                pdfHeaderCell.setGrayFill(0.7f);
                pdfHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfHeaderCell.setPhrase(new Phrase(report.getFiledName(), font));
                pdfHeaderCell.setBorderWidth(0.5f);
                pdfPTable.addCell(pdfHeaderCell);
            });
            List<FetchAllGlobalCountryDetailForReportView> fetchAllGlobalCountryDetailForReportViews = this.entityQuery.executeQuery(
                "select * from fetch_all_global_country_detail_for_report_view", FetchAllGlobalCountryDetailForReportView.class);
            for (FetchAllGlobalCountryDetailForReportView fetchAllGlobalCountryDetailForReport: fetchAllGlobalCountryDetailForReportViews) {
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchAllGlobalCountryDetailForReport.getCountryName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchAllGlobalCountryDetailForReport.getCountryCode()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchAllGlobalCountryDetailForReport.getCountryStatus()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchAllGlobalCountryDetailForReport.getTotalCity()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchAllGlobalCountryDetailForReport.getTotalWallet()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchAllGlobalCountryDetailForReport.getTotalBank()), font)));
            }
            document.add(pdfPTable);
            return byteArrayOutputStream;
        } catch (Exception ex) {
            logger.error("### An error occurred while export All Global Country Detail Report ### ", ex);
            throw ex;
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
            if (document != null) {
                document.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    public ByteArrayInputStream fetchMtoPartnerCountryViewXlsx()
        throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet mtoPartnerCountryReportSheet = workbook.createSheet("MtoPartner Country Report");
            Row row = mtoPartnerCountryReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCountryReportSheet);
            //===============================Header-Field======================
            List<Report> mtoPartnerCountryReportDetail = this.reportDetail.get("fetch_mto_partner_country_view");
            for (Report report: mtoPartnerCountryReportDetail) {
                try {
                    this.fillHeading(mtoPartnerCountryReportSheet, row, style, report.getIndex(),
                        Integer.valueOf(String.valueOf(this.engine.eval(report.getFiledWidth()))),
                        report.getFiledName() , null, false);
                } catch (ScriptException ex) {
                    throw ex;
                }
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(mtoPartnerCountryReportSheet);
            List<FetchMtoPartnerCountryView> fetchMtoPartnerCountryViews = this.entityQuery.executeQuery(
                    "select * from fetch_mto_partner_country_view", FetchMtoPartnerCountryView.class);
            for (FetchMtoPartnerCountryView fetchMtoPartnerCountry: fetchMtoPartnerCountryViews) {
                row = mtoPartnerCountryReportSheet.createRow(rowCount);
                this.fillCellValue(0, row, style, fetchMtoPartnerCountry.getPartnerId());
                this.fillCellValue(1, row, style, fetchMtoPartnerCountry.getPartnerName());
                this.fillCellValue(2, row, style, fetchMtoPartnerCountry.getCountryName());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error("### An error occurred while export MtoPartner Country Report ### ", ex);
            throw ex;
        }
    }

    public ByteArrayInputStream fetchMtoPartnerCountryWalletViewXlsx()
        throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet mtoPartnerCountryWalletReportSheet = workbook.createSheet("MtoPartner Country Wallet Report");
            Row row = mtoPartnerCountryWalletReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCountryWalletReportSheet);
            //===============================Header-Field======================
            List<Report> mtoPartnerCountryWalletReportDetail = this.reportDetail.get("fetch_mto_partner_country_wallet_view");
            for (Report report: mtoPartnerCountryWalletReportDetail) {
                try {
                    this.fillHeading(mtoPartnerCountryWalletReportSheet, row, style, report.getIndex(),
                            Integer.valueOf(String.valueOf(this.engine.eval(report.getFiledWidth()))),
                            report.getFiledName() , null, false);
                } catch (ScriptException ex) {
                    throw ex;
                }
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(mtoPartnerCountryWalletReportSheet);
            List<FetchMtoPartnerCountryWalletView> fetchMtoPartnerCountryWalletViews = this.entityQuery.executeQuery(
                    "select * from fetch_mto_partner_country_wallet_view", FetchMtoPartnerCountryWalletView.class);
            for (FetchMtoPartnerCountryWalletView fetchMtoPartnerCountryWallet: fetchMtoPartnerCountryWalletViews) {
                row = mtoPartnerCountryWalletReportSheet.createRow(rowCount);
                this.fillCellValue(0, row, style, fetchMtoPartnerCountryWallet.getPartnerId());
                this.fillCellValue(1, row, style, fetchMtoPartnerCountryWallet.getPartnerName());
                this.fillCellValue(2, row, style, fetchMtoPartnerCountryWallet.getCountryCode());
                this.fillCellValue(3, row, style, fetchMtoPartnerCountryWallet.getCountryName());
                this.fillCellValue(4, row, style, fetchMtoPartnerCountryWallet.getWalletId());
                this.fillCellValue(5, row, style, fetchMtoPartnerCountryWallet.getWalletName());
                this.fillCellValue(6, row, style, fetchMtoPartnerCountryWallet.getWalletEnabled());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error("### An error occurred while export MtoPartner Country Wallet Report ### ", ex);
            throw ex;
        }
    }

    public ByteArrayInputStream fetchMtoPartnerCountryCityViewXlsx()
        throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet mtoPartnerCountryCityReportSheet = workbook.createSheet("MtoPartner Country City Report");
            Row row = mtoPartnerCountryCityReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCountryCityReportSheet);
            //===============================Header-Field======================
            List<Report> mtoPartnerCountryCityReportDetail = this.reportDetail.get("fetch_mto_partner_country_city_view");
            for (Report report: mtoPartnerCountryCityReportDetail) {
                try {
                    this.fillHeading(mtoPartnerCountryCityReportSheet, row, style, report.getIndex(),
                        Integer.valueOf(String.valueOf(this.engine.eval(report.getFiledWidth()))),
                        report.getFiledName() , null, false);
                } catch (ScriptException ex) {
                    throw ex;
                }
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(mtoPartnerCountryCityReportSheet);
            List<FetchMtoPartnerCountryCityView> fetchMtoPartnerCountryCityViews = this.entityQuery.executeQuery(
                    "select * from fetch_mto_partner_country_city_view", FetchMtoPartnerCountryCityView.class);
            for (FetchMtoPartnerCountryCityView fetchMtoPartnerCountryCity: fetchMtoPartnerCountryCityViews) {
                row = mtoPartnerCountryCityReportSheet.createRow(rowCount);
                this.fillCellValue(0, row, style, fetchMtoPartnerCountryCity.getPartnerId());
                this.fillCellValue(1, row, style, fetchMtoPartnerCountryCity.getPartnerName());
                this.fillCellValue(2, row, style, fetchMtoPartnerCountryCity.getCountryCode());
                this.fillCellValue(3, row, style, fetchMtoPartnerCountryCity.getCountryName());
                this.fillCellValue(4, row, style, fetchMtoPartnerCountryCity.getCityId());
                this.fillCellValue(5, row, style, fetchMtoPartnerCountryCity.getCityName());
                this.fillCellValue(6, row, style, fetchMtoPartnerCountryCity.getCityEnabled());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error("### An error occurred while export MtoPartner Country City Report ### ", ex);
            throw ex;
        }
    }

    public ByteArrayInputStream fetchMtoPartnerCountryBankViewXlsx()
        throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet mtoPartnerCountryBankReportSheet = workbook.createSheet("MtoPartner Country Bank Report");
            Row row = mtoPartnerCountryBankReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCountryBankReportSheet);
            //===============================Header-Field======================
            List<Report> mtoPartnerCountryBankReportDetail = this.reportDetail.get("fetch_mto_partner_country_bank_view");
            for (Report report: mtoPartnerCountryBankReportDetail) {
                try {
                    this.fillHeading(mtoPartnerCountryBankReportSheet, row, style, report.getIndex(),
                            Integer.valueOf(String.valueOf(this.engine.eval(report.getFiledWidth()))),
                            report.getFiledName() , null, false);
                } catch (ScriptException ex) {
                    throw ex;
                }
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(mtoPartnerCountryBankReportSheet);
            List<FetchMtoPartnerCountryBankView> fetchMtoPartnerCountryBankViews = this.entityQuery.executeQuery(
                    "select * from fetch_mto_partner_country_bank_view", FetchMtoPartnerCountryBankView.class);
            for (FetchMtoPartnerCountryBankView fetchMtoPartnerCountryBankView: fetchMtoPartnerCountryBankViews) {
                row = mtoPartnerCountryBankReportSheet.createRow(rowCount);
                this.fillCellValue(0, row, style, fetchMtoPartnerCountryBankView.getPartnerId());
                this.fillCellValue(1, row, style, fetchMtoPartnerCountryBankView.getPartnerName());
                this.fillCellValue(2, row, style, fetchMtoPartnerCountryBankView.getCountryCode());
                this.fillCellValue(3, row, style, fetchMtoPartnerCountryBankView.getCountryName());
                this.fillCellValue(4, row, style, fetchMtoPartnerCountryBankView.getBankId());
                this.fillCellValue(5, row, style, fetchMtoPartnerCountryBankView.getBankName());
                this.fillCellValue(6, row, style, fetchMtoPartnerCountryBankView.getBankEnabled());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error("### An error occurred while export MtoPartner Country Bank Report ### ", ex);
            throw ex;
        }
    }

    public ByteArrayInputStream fetchAllGlobalCountryDetailForReportViewXlsx()
        throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet globalCountryDetailReportSheet = workbook.createSheet("Global Country Detail Report");
            Row row = globalCountryDetailReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), globalCountryDetailReportSheet);
            //===============================Header-Field======================
            List<Report> globalCountryDetailReportDetail = this.reportDetail.get("fetch_all_global_country_detail_for_report_view");
            for (Report report: globalCountryDetailReportDetail) {
                try {
                    this.fillHeading(globalCountryDetailReportSheet, row, style, report.getIndex(),
                        Integer.valueOf(String.valueOf(this.engine.eval(report.getFiledWidth()))),
                        report.getFiledName() , null, false);
                } catch (ScriptException ex) {
                    throw ex;
                }
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(globalCountryDetailReportSheet);
            List<FetchAllGlobalCountryDetailForReportView> fetchAllGlobalCountryDetailForReportViews = this.entityQuery.executeQuery(
                    "select * from fetch_all_global_country_detail_for_report_view", FetchAllGlobalCountryDetailForReportView.class);
            for (FetchAllGlobalCountryDetailForReportView fetchAllGlobalCountryDetailForReport: fetchAllGlobalCountryDetailForReportViews) {
                row = globalCountryDetailReportSheet.createRow(rowCount);
                this.fillCellValue(0, row, style, fetchAllGlobalCountryDetailForReport.getCountryName());
                this.fillCellValue(1, row, style, fetchAllGlobalCountryDetailForReport.getCountryCode());
                this.fillCellValue(2, row, style, fetchAllGlobalCountryDetailForReport.getCountryStatus());
                this.fillCellValue(3, row, style, fetchAllGlobalCountryDetailForReport.getTotalCity());
                this.fillCellValue(4, row, style, fetchAllGlobalCountryDetailForReport.getTotalWallet());
                this.fillCellValue(5, row, style, fetchAllGlobalCountryDetailForReport.getTotalBank());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error("### An error occurred while export All Global Country Detail Report ### ", ex);
            throw ex;
        }
    }

    public class Report {

        private Integer index;
        private String filedName;
        private String filedWidth;

        public Report() {}

        public Report(Integer index, String filedName, String filedWidth) {
            this.index = index;
            this.filedName = filedName;
            this.filedWidth = filedWidth;
        }

        public Integer getIndex() {
            return index;
        }
        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getFiledName() {
            return filedName;
        }
        public void setFiledName(String filedName) {
            this.filedName = filedName;
        }

        public String getFiledWidth() {
            return filedWidth;
        }
        public void setFiledWidth(String filedWidth) {
            this.filedWidth = filedWidth;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

}