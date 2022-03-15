package com.barco.imrh.report;

import com.google.gson.Gson;

public class ReportHeader {

    private Integer index;
    private String filedName;
    private String filedWidth;

    public ReportHeader() {}

    public ReportHeader(Integer index, String filedName, String filedWidth) {
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