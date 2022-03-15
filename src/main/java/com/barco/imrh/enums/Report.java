package com.barco.imrh.enums;

public enum Report {

    MtoPartnerCountryReport("/report/mto_partner_country_report.jasper", "/report/mto_partner_country_report.jrxml"),
    MtoPartnerCountryCityReport("/report/mto_partner_country_city_report.jasper", "/report/mto_partner_country_city_report.jrxml"),
    MtoPartnerCountryWalletReport("/report/mto_partner_country_wallet_report.jasper", "/report/mto_partner_country_wallet_report.jrxml"),
    MtoPartnerCountryBankReport("/report/mto_partner_country_bank_report.jasper", "/report/mto_partner_country_bank_report.jrxml"),
    GlobalCountryDetailReport("/report/all_global_country_detail_for_report.jasper", "/report/all_global_country_detail_for_report.jrxml");

    public final String reportPathJasper;
    public final String reportPathJrXml;

    private Report(String reportPathJasper, String reportPathJrXml) {
        this.reportPathJasper = reportPathJasper;
        this.reportPathJrXml = reportPathJrXml;
    }
}
