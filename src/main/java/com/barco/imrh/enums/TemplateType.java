package com.barco.imrh.enums;

import com.google.gson.Gson;

/**
 * @author Nabeel Ahmed
 */
public enum TemplateType {

    TEST_TEMPLATE("TEST_TEMPLATE", "templates/test.vm");

    private String templateName;
    private String templatePath;

    TemplateType(String templateName, String templatePath) {
        this.templateName = templateName;
        this.templatePath = templatePath;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
