package com.etisalat.imrh.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * @author Nabeel Ahmed
 */
public class PoiWorkBookUtil {

    private final String FOUNT_NAME = "Calibri";

    public void fillHeading(XSSFSheet sheet, Row row, CellStyle style, Integer index,
        Integer width, String heading, String margeCell, Boolean isMarged) {
        Cell cell = row.createCell(index);
        cell.setCellValue(heading); // heading value
        if(style != null) { cell.setCellStyle(style); } // style if have
        if(width != null) { sheet.setColumnWidth(index, width); } // width if have
        if(isMarged) {
            sheet.addMergedRegion(CellRangeAddress.valueOf(margeCell));
        }
    }

    public CellStyle cellHeadingBackgroundColorStyle(short backgroundColor, XSSFSheet sheet) {
        CellStyle style = sheet.getWorkbook().createCellStyle();
        style.setFont(this.getFont(true, sheet));
        style.setFillForegroundColor(backgroundColor);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        return style;
    }

    public Font getFont(Boolean isWhite, XSSFSheet sheet) {
        Font font = sheet.getWorkbook().createFont();
        font.setFontName(FOUNT_NAME);
        if(isWhite) {
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setBold(isWhite);
        }
        font.setFontHeightInPoints((short) 11);
        return font;
    }

    public CellStyle cellBodyColorStyle(XSSFSheet sheet) {
        CellStyle style = sheet.getWorkbook().createCellStyle();
        style.setFont(this.getFont(false, sheet));
        return style;
    }

    public void fillCellValue(Integer fillCellCount, Row row, CellStyle style, String value) {
        Cell cell = row.createCell(fillCellCount);
        if(style != null) { cell.setCellStyle(style); }
        if(value != null) { cell.setCellValue(value); }
    }

    public void fillCellValue(Integer fillCellCount, Row row, CellStyle style, Long value) {
        Cell cell = row.createCell(fillCellCount);
        if(style != null) { cell.setCellStyle(style); }
        if(value != null) { cell.setCellValue(value); }
    }

}
