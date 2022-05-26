package com.barco.imrh.service.impl;

import com.barco.imrh.report.ReportHeader;
import com.barco.imrh.report.UserDetail;
import com.barco.imrh.repository.query.EntityQuery;
import com.barco.imrh.repository.view.*;
import com.barco.imrh.enums.Report;
import com.barco.imrh.service.ReportService;
import com.barco.imrh.util.PoiWorkBookUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value(value = MOI_IMAGE_PATH)
    private String moiImagePath;
    @Value(value = ETISALAT_IMAGE_PATH)
    private String etisalatImagePath;

    private final String FETCH_MTO_PARTNER_COUNTRY_VIEW_QUERY ="select * from fetch_mto_partner_country_view";
    private final String FETCH_MTO_PARTNER_COUNTRY_WALLET_VIEW_QUERY  = "select * from fetch_mto_partner_country_wallet_view";
    private final String FETCH_MTO_PARTNER_COUNTRY_CITY_VIEW_QUERY = "select * from fetch_mto_partner_country_city_view";
    private final String FETCH_MTO_PARTNER_COUNTRY_BANK_VIEW_QUERY = "select * from fetch_mto_partner_country_bank_view";
    private final String FETCH_ALL_GLOBAL_COUNTRY_DETAIL_FOR_REPORT_VIEW_QUERY = "select * from fetch_all_global_country_detail_for_report_view";
    private final String FETCH_MTO_PARTNER_COUNTRY_WALLET_VIEW= "fetch_mto_partner_country_wallet_view";
    private final String FETCH_MTO_PARTNER_COUNTRY_VIEW = "fetch_mto_partner_country_view";
    private final String FETCH_MTO_PARTNER_COUNTRY_CITY_VIEW = "fetch_mto_partner_country_city_view";
    private final String FETCH_MTO_PARTNER_COUNTRY_BANK_VIEW = "fetch_mto_partner_country_bank_view";
    private final String FETCH_ALL_GLOBAL_COUNTRY_DETAIL_FOR_REPORT_VIEW = "fetch_all_global_country_detail_for_report_view";

    private ScriptEngine engine;
    private Map<String, List<ReportHeader>> reportDetail = new HashMap<>();

    {
        ScriptEngineManager mgr = new ScriptEngineManager();
        this.engine = mgr.getEngineByName(JAVA_SCRIPT);
        int count = 0;
        List<ReportHeader> reports = new ArrayList<>();
        reports.add(new ReportHeader(count, PARTNER_ID, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, PARTNER_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, COUNTRY_CODE, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, COUNTRY_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, WALLET_ID, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, WALLET_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, WALLET_ENABLED, CELL_SIZE_20_225));
        this.reportDetail.put(FETCH_MTO_PARTNER_COUNTRY_WALLET_VIEW, reports);

        count = 0;
        reports = new ArrayList<>();
        reports.add(new ReportHeader(count, PARTNER_ID, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, PARTNER_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, COUNTRY_NAME, CELL_SIZE_20_225));
        this.reportDetail.put(FETCH_MTO_PARTNER_COUNTRY_VIEW, reports);

        count = 0;
        reports = new ArrayList<>();
        reports.add(new ReportHeader(count, PARTNER_ID, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, PARTNER_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, COUNTRY_CODE, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, COUNTRY_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, CITY_ID, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, CITY_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, CITY_STATUS, CELL_SIZE_20_225));
        this.reportDetail.put(FETCH_MTO_PARTNER_COUNTRY_CITY_VIEW, reports);

        count = 0;
        reports = new ArrayList<>();
        reports.add(new ReportHeader(count, PARTNER_ID, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, PARTNER_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, COUNTRY_CODE, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, COUNTRY_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, BANK_ID, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, BANK_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, BANK_ENABLED, CELL_SIZE_20_225));
        this.reportDetail.put(FETCH_MTO_PARTNER_COUNTRY_BANK_VIEW, reports);

        count = 0;
        reports = new ArrayList<>();
        reports.add(new ReportHeader(count,COUNTRY_NAME, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count,COUNTRY_CODE, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count,COUNTRY_STATUS, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count,TOTAL_CITY, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count, TOTAL_WALLET, CELL_SIZE_20_225));
        reports.add(new ReportHeader(++count,TOTAL_BANK, CELL_SIZE_20_225));
        this.reportDetail.put(FETCH_ALL_GLOBAL_COUNTRY_DETAIL_FOR_REPORT_VIEW, reports);
    }

    @Override
    public ByteArrayOutputStream fetchMtoPartnerCountryViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, MARGIN, MARGIN, MARGIN, MARGIN);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.etisalatImagePath, document);
            this.addHeadingDetail(this.getParameters(Report.MtoPartnerCountryReport).get(TITLE).toString(),
                this.getParameters(Report.MtoPartnerCountryReport).get(SUB_TITLE).toString(), document);
            //===============================Header-Field======================
            List<ReportHeader> mtoPartnerCountryReportDetail = this.reportDetail.get(FETCH_MTO_PARTNER_COUNTRY_VIEW);
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
            List<FetchMtoPartnerCountryView> fetchMtoPartnerCountryViews =
                this.entityQuery.executeQuery(FETCH_MTO_PARTNER_COUNTRY_VIEW_QUERY, FetchMtoPartnerCountryView.class);
            for (FetchMtoPartnerCountryView fetchMtoPartnerCountry: fetchMtoPartnerCountryViews) {
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountry.getPartnerId()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountry.getPartnerName()), font)));
                pdfPTable.addCell(new PdfPCell(new Phrase(String.valueOf(fetchMtoPartnerCountry.getCountryName()), font)));
            }
            document.add(pdfPTable);
            return byteArrayOutputStream;
        } catch (Exception ex) {
            logger.error(MTO_PARTNER_COUNTRY_REPORT_ERROR, ex);
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

    @Override
    public ByteArrayOutputStream fetchMtoPartnerCountryWalletViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, MARGIN, MARGIN, MARGIN, MARGIN);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.etisalatImagePath, document);
            this.addHeadingDetail(this.getParameters(Report.MtoPartnerCountryWalletReport).get(TITLE).toString(),
                this.getParameters(Report.MtoPartnerCountryWalletReport).get(SUB_TITLE).toString(), document);
            //===============================Header-Field======================
            List<ReportHeader> mtoPartnerCountryWalletReportDetail = this.reportDetail.get(FETCH_MTO_PARTNER_COUNTRY_WALLET_VIEW);
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
                    FETCH_MTO_PARTNER_COUNTRY_WALLET_VIEW_QUERY, FetchMtoPartnerCountryWalletView.class);
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
            logger.error(MTO_PARTNER_COUNTRY_WALLET_REPORT_ERROR, ex);
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

    @Override
    public ByteArrayOutputStream fetchMtoPartnerCountryCityViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, MARGIN, MARGIN, MARGIN, MARGIN);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.etisalatImagePath, document);
            this.addHeadingDetail(this.getParameters(Report.MtoPartnerCountryCityReport).get(TITLE).toString(),
                this.getParameters(Report.MtoPartnerCountryCityReport).get(SUB_TITLE).toString(), document);
            //===============================Header-Field======================
            List<ReportHeader> mtoPartnerCountryCityReportDetail = this.reportDetail.get(FETCH_MTO_PARTNER_COUNTRY_CITY_VIEW);
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
                    FETCH_MTO_PARTNER_COUNTRY_CITY_VIEW_QUERY, FetchMtoPartnerCountryCityView.class);
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
            logger.error(MTO_PARTNER_COUNTRY_CITY_REPORT_ERROR, ex);
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

    @Override
    public ByteArrayOutputStream fetchMtoPartnerCountryBankViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, MARGIN, MARGIN, MARGIN, MARGIN);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.etisalatImagePath, document);
            this.addHeadingDetail(this.getParameters(Report.MtoPartnerCountryBankReport).get(TITLE).toString(),
                this.getParameters(Report.MtoPartnerCountryBankReport).get(SUB_TITLE).toString(), document);
            //===============================Header-Field======================
            List<ReportHeader> mtoPartnerCountryBankReportDetail = this.reportDetail.get(FETCH_MTO_PARTNER_COUNTRY_BANK_VIEW);
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
                    FETCH_MTO_PARTNER_COUNTRY_BANK_VIEW_QUERY, FetchMtoPartnerCountryBankView.class);
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
            logger.error(MTO_PARTNER_COUNTRY_BANK_REPORT_ERROR, ex);
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

    @Override
    public ByteArrayOutputStream fetchAllGlobalCountryDetailForReportViewPdf() throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        Document document = null;
        PdfWriter writer = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            document = new Document(PageSize.A4, MARGIN, MARGIN, MARGIN, MARGIN);
            writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            // adding image
            this.addHeaderImage(this.etisalatImagePath, document);
            this.addHeadingDetail(this.getParameters(Report.GlobalCountryDetailReport).get(TITLE).toString(),
                this.getParameters(Report.GlobalCountryDetailReport).get(SUB_TITLE).toString(), document);
            //===============================Header-Field======================
            List<ReportHeader> globalCountryDetailReportDetail = this.reportDetail.get(FETCH_ALL_GLOBAL_COUNTRY_DETAIL_FOR_REPORT_VIEW);
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
                    FETCH_ALL_GLOBAL_COUNTRY_DETAIL_FOR_REPORT_VIEW_QUERY, FetchAllGlobalCountryDetailForReportView.class);
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
            logger.error(ALL_GLOBAL_COUNTRY_DETAIL_REPORT_ERROR, ex);
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

    @Override
    public ByteArrayInputStream fetchMtoPartnerCountryViewXlsx() throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet mtoPartnerCountryReportSheet = workbook.createSheet(MTO_PARTNER_COUNTRY_REPORT_SHEET);
            Row row = mtoPartnerCountryReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCountryReportSheet);
            //===============================Header-Field======================
            List<ReportHeader> mtoPartnerCountryReportDetail = this.reportDetail.get(FETCH_MTO_PARTNER_COUNTRY_VIEW);
            for (ReportHeader reportHeader: mtoPartnerCountryReportDetail) {
                this.fillHeading(mtoPartnerCountryReportSheet, row, style, reportHeader.getIndex(),
                    Integer.valueOf(String.valueOf(this.engine.eval(reportHeader.getFiledWidth()))),
                    reportHeader.getFiledName(), null, false);
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(mtoPartnerCountryReportSheet);
            List<FetchMtoPartnerCountryView> fetchMtoPartnerCountryViews = this.entityQuery.executeQuery(
                 FETCH_MTO_PARTNER_COUNTRY_VIEW_QUERY, FetchMtoPartnerCountryView.class);
            for (FetchMtoPartnerCountryView fetchMtoPartnerCountry: fetchMtoPartnerCountryViews) {
                int fillCellCount = 0;
                row = mtoPartnerCountryReportSheet.createRow(rowCount);
                this.fillCellValue(fillCellCount, row, style, fetchMtoPartnerCountry.getPartnerId());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountry.getPartnerName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountry.getCountryName());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error(MTO_PARTNER_COUNTRY_REPORT_ERROR, ex);
            throw ex;
        }
    }

    @Override
    public ByteArrayInputStream fetchMtoPartnerCountryWalletViewXlsx() throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet mtoPartnerCountryWalletReportSheet = workbook.createSheet(MTO_PARTNER_COUNTRY_WALLET_REPORT_SHEET);
            Row row = mtoPartnerCountryWalletReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCountryWalletReportSheet);
            //===============================Header-Field======================
            List<ReportHeader> mtoPartnerCountryWalletReportDetail = this.reportDetail.get(FETCH_MTO_PARTNER_COUNTRY_WALLET_VIEW);
            for (ReportHeader report: mtoPartnerCountryWalletReportDetail) {
                try {
                    this.fillHeading(mtoPartnerCountryWalletReportSheet, row, style, report.getIndex(),
                        Integer.valueOf(String.valueOf(this.engine.eval(report.getFiledWidth()))),
                            report.getFiledName(), null, false);
                } catch (ScriptException ex) {
                    throw ex;
                }
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(mtoPartnerCountryWalletReportSheet);
            List<FetchMtoPartnerCountryWalletView> fetchMtoPartnerCountryWalletViews = this.entityQuery.executeQuery(
                    FETCH_MTO_PARTNER_COUNTRY_WALLET_VIEW_QUERY, FetchMtoPartnerCountryWalletView.class);
            for (FetchMtoPartnerCountryWalletView fetchMtoPartnerCountryWallet: fetchMtoPartnerCountryWalletViews) {
                int fillCellCount = 0;
                row = mtoPartnerCountryWalletReportSheet.createRow(rowCount);
                this.fillCellValue(fillCellCount, row, style, fetchMtoPartnerCountryWallet.getPartnerId());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryWallet.getPartnerName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryWallet.getCountryCode());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryWallet.getCountryName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryWallet.getWalletId());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryWallet.getWalletName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryWallet.getWalletEnabled());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error(MTO_PARTNER_COUNTRY_WALLET_REPORT_ERROR, ex);
            throw ex;
        }
    }

    @Override
    public ByteArrayInputStream fetchMtoPartnerCountryCityViewXlsx() throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet mtoPartnerCountryCityReportSheet = workbook.createSheet(MTO_PARTNER_COUNTRY_CITY_REPORT_SHEET);
            Row row = mtoPartnerCountryCityReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCountryCityReportSheet);
            //===============================Header-Field======================
            List<ReportHeader> mtoPartnerCountryCityReportDetail = this.reportDetail.get(FETCH_MTO_PARTNER_COUNTRY_CITY_VIEW);
            for (ReportHeader reportHeader: mtoPartnerCountryCityReportDetail) {
                this.fillHeading(mtoPartnerCountryCityReportSheet, row, style, reportHeader.getIndex(),
                    Integer.valueOf(String.valueOf(this.engine.eval(reportHeader.getFiledWidth()))),
                        reportHeader.getFiledName() , null, false);
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(mtoPartnerCountryCityReportSheet);
            List<FetchMtoPartnerCountryCityView> fetchMtoPartnerCountryCityViews = this.entityQuery.executeQuery(
                    FETCH_MTO_PARTNER_COUNTRY_CITY_VIEW_QUERY, FetchMtoPartnerCountryCityView.class);
            for (FetchMtoPartnerCountryCityView fetchMtoPartnerCountryCity: fetchMtoPartnerCountryCityViews) {
                int fillCellCount = 0;
                row = mtoPartnerCountryCityReportSheet.createRow(rowCount);
                this.fillCellValue(fillCellCount, row, style, fetchMtoPartnerCountryCity.getPartnerId());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryCity.getPartnerName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryCity.getCountryCode());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryCity.getCountryName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryCity.getCityId());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryCity.getCityName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryCity.getCityEnabled());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error(MTO_PARTNER_COUNTRY_CITY_REPORT_ERROR, ex);
            throw ex;
        }
    }

    @Override
    public ByteArrayInputStream fetchMtoPartnerCountryBankViewXlsx() throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet mtoPartnerCountryBankReportSheet = workbook.createSheet(MTO_PARTNER_COUNTRY_BANK_REPORT_SHEET);
            Row row = mtoPartnerCountryBankReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), mtoPartnerCountryBankReportSheet);
            //===============================Header-Field======================
            List<ReportHeader> mtoPartnerCountryBankReportDetail = this.reportDetail.get(FETCH_MTO_PARTNER_COUNTRY_BANK_VIEW);
            for (ReportHeader reportHeader: mtoPartnerCountryBankReportDetail) {
                this.fillHeading(mtoPartnerCountryBankReportSheet, row, style, reportHeader.getIndex(),
                    Integer.valueOf(String.valueOf(this.engine.eval(reportHeader.getFiledWidth()))),
                        reportHeader.getFiledName() , null, false);
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(mtoPartnerCountryBankReportSheet);
            List<FetchMtoPartnerCountryBankView> fetchMtoPartnerCountryBankViews = this.entityQuery.executeQuery(
                 FETCH_MTO_PARTNER_COUNTRY_BANK_VIEW_QUERY, FetchMtoPartnerCountryBankView.class);
            for (FetchMtoPartnerCountryBankView fetchMtoPartnerCountryBankView: fetchMtoPartnerCountryBankViews) {
                int fillCellCount = 0;
                row = mtoPartnerCountryBankReportSheet.createRow(rowCount);
                this.fillCellValue(fillCellCount, row, style, fetchMtoPartnerCountryBankView.getPartnerId());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryBankView.getPartnerName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryBankView.getCountryCode());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryBankView.getCountryName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryBankView.getBankId());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryBankView.getBankName());
                this.fillCellValue(++fillCellCount, row, style, fetchMtoPartnerCountryBankView.getBankEnabled());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error(MTO_PARTNER_COUNTRY_BANK_REPORT_ERROR, ex);
            throw ex;
        }
    }

    @Override
    public ByteArrayInputStream fetchAllGlobalCountryDetailForReportViewXlsx() throws IOException, ScriptException {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet globalCountryDetailReportSheet = workbook.createSheet(GLOBAL_COUNTRY_DETAIL_REPORT_SHEET);
            Row row = globalCountryDetailReportSheet.createRow(0);
            CellStyle style = this.cellHeadingBackgroundColorStyle(IndexedColors.BLACK.getIndex(), globalCountryDetailReportSheet);
            //===============================Header-Field======================
            List<ReportHeader> globalCountryDetailReportDetail = this.reportDetail.get(FETCH_ALL_GLOBAL_COUNTRY_DETAIL_FOR_REPORT_VIEW);
            for (ReportHeader reportHeader: globalCountryDetailReportDetail) {
                this.fillHeading(globalCountryDetailReportSheet, row, style, reportHeader.getIndex(),
                    Integer.valueOf(String.valueOf(this.engine.eval(reportHeader.getFiledWidth()))), reportHeader.getFiledName() ,
                    null, false);
            }
            //===============================Detail-Field======================
            Integer rowCount = 1;
            style = this.cellBodyColorStyle(globalCountryDetailReportSheet);
            List<FetchAllGlobalCountryDetailForReportView> fetchAllGlobalCountryDetailForReportViews = this.entityQuery.executeQuery(
                 FETCH_ALL_GLOBAL_COUNTRY_DETAIL_FOR_REPORT_VIEW_QUERY, FetchAllGlobalCountryDetailForReportView.class);
            for (FetchAllGlobalCountryDetailForReportView fetchAllGlobalCountryDetailForReport: fetchAllGlobalCountryDetailForReportViews) {
                int fillCellCount = 0;
                row = globalCountryDetailReportSheet.createRow(rowCount);
                this.fillCellValue(fillCellCount, row, style, fetchAllGlobalCountryDetailForReport.getCountryName());
                this.fillCellValue(++fillCellCount, row, style, fetchAllGlobalCountryDetailForReport.getCountryCode());
                this.fillCellValue(++fillCellCount, row, style, fetchAllGlobalCountryDetailForReport.getCountryStatus());
                this.fillCellValue(++fillCellCount, row, style, fetchAllGlobalCountryDetailForReport.getTotalCity());
                this.fillCellValue(++fillCellCount, row, style, fetchAllGlobalCountryDetailForReport.getTotalWallet());
                this.fillCellValue(++fillCellCount, row, style, fetchAllGlobalCountryDetailForReport.getTotalBank());
                rowCount++;
            }
            //========================End-Work-Book==================
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (Exception ex) {
            logger.error(ALL_GLOBAL_COUNTRY_DETAIL_REPORT_ERROR, ex);
            throw ex;
        }
    }

    @Override
    public byte[] downloadJasperFile(Report report) throws JRException {
        try {
            JRDataSource jrDataSource = null;
            JasperReport jasperReport = null;
            if (report.equals(Report.MtoPartnerCountryReport)) {
                jrDataSource = new JRBeanCollectionDataSource(this.entityQuery.executeQuery(
                    FETCH_MTO_PARTNER_COUNTRY_VIEW_QUERY, FetchMtoPartnerCountryView.class));
                jasperReport = this.getJasperReport(report, true);
            } else if (report.equals(Report.MtoPartnerCountryCityReport)) {
                jrDataSource = new JRBeanCollectionDataSource(this.entityQuery.executeQuery(
                    FETCH_MTO_PARTNER_COUNTRY_CITY_VIEW_QUERY, FetchMtoPartnerCountryCityView.class));
                jasperReport = this.getJasperReport(report, true);
            } else if (report.equals(Report.MtoPartnerCountryWalletReport)) {
                jrDataSource = new JRBeanCollectionDataSource(this.entityQuery.executeQuery(
                    FETCH_MTO_PARTNER_COUNTRY_WALLET_VIEW_QUERY, FetchMtoPartnerCountryWalletView.class));
                jasperReport = this.getJasperReport(report, false);
            } else if (report.equals(Report.MtoPartnerCountryBankReport)) {
                jrDataSource = new JRBeanCollectionDataSource(this.entityQuery.executeQuery(
                    FETCH_MTO_PARTNER_COUNTRY_BANK_VIEW_QUERY, FetchMtoPartnerCountryBankView.class));
                jasperReport = this.getJasperReport(report, true);
            } else if (report.equals(Report.GlobalCountryDetailReport)) {
                jrDataSource = new JRBeanCollectionDataSource(this.entityQuery.executeQuery(
                    FETCH_ALL_GLOBAL_COUNTRY_DETAIL_FOR_REPORT_VIEW_QUERY, FetchAllGlobalCountryDetailForReportView.class));
                jasperReport = this.getJasperReport(report, true);
            }
            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = this.getParameters(report);
            parameters.put(IMAGE_PATH, this.moiImagePath);
            parameters.put(ITEM_DATA_SOURCE, jrDataSource);
            parameters.put(USER_DETAIL, new UserDetail());
            return JasperExportManager.exportReportToPdf(JasperFillManager
                   .fillReport(jasperReport, parameters, new JREmptyDataSource()));
        } catch (Exception ex) {
            logger.error(DOWNLOAD_JASPER_FILE_ERROR, ex);
            throw ex;
        }
    }

}