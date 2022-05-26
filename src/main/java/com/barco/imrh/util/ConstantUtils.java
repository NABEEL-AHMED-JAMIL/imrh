package com.barco.imrh.util;

/**
 * @author Nabeel Ahmed
 */
public class ConstantUtils {

    public static final String DOT_XLSX = ".xlsx";
    public static final String DOT_PDF = ".pdf";
    public static final String PDF_MEDIA_TYPE = "application/pdf";
    public static final String REPORT_NOT_FOUND = "Report not found.";
    public static final String HEADER_NAME = "Content-Disposition";
    public static final String HEADER_VALUE = "attachment; filename=%s";
    public static final String SOME_INTERNAL_ERROR = "Some Internal error accrue contact with support team.";
    public static final String DOC_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String UPLOAD_ONLY_XLSX_EXTENSION_FILE = "You can upload only .xlsx extension file.";

    public static interface BankControllerConst {

        public static final String ORIGINS =  "*";
        public static final String IMRH_BANK = "/imrh/bank";
        public static final String CREATE_BANK = "/createBank";
        public static final String ENABLE_DISABLE_BANK = "/enableDisableBank";
        public static final String ENABLE_DISABLE_ALL_BANK = "/enableDisableAllBank";
        public static final String FIND_BY_BANK_ID = "/findByBankId";
        public static final String UPDATE_BANK = "/updateBank";
        public static final String DELETE_BANK = "/deleteBank";
    }

    public static interface CityControllerConst {

        public static final String ORIGINS =  "*";
        public static final String IMRH_CITY = "/imrh/city";
        public static final String CREATE_CITY = "/createCity";
        public static final String ENABLE_DISABLE_CITY = "/enableDisableCity";
        public static final String ENABLE_DISABLE_ALL_CITY_BY_COUNTRY_CODE = "/enableDisableAllCityByCountryCode";
        public static final String FIND_BY_CITY_ID = "/findByCityId";
        public static final String UPDATE_CITY = "/updateCity";
        public static final String DELETE_CITY = "/deleteCity";
    }
    public static interface CountryControllerConst {
        public static final String ORIGINS =  "*";
        public static final String IMRH_COUNTRY = "/imrh/country";
        public static final String ENABLE_DISABLE_COUNTRY = "/enableDisableCountry";
        public static final String ENABLE_DISABLE_ALL_COUNTRY = "/enableDisableAllCountry";
        public static final String FIND_BY_COUNTRY_CODE = "/findByCountryCode";
        public static final String FETCH_ALL_COUNTRY = "/fetchAllCountry";
        public static final String FETCH_ALL_CITY_BY_COUNTRY_CODE = "/fetchAllCityByCountryCode";
        public static final String FETCH_ALL_BANK_BY_COUNTRY_CODE = "/fetchAllBankByCountryCode";
        public static final String FETCH_ALL_WALLET_BY_COUNTRY_CODE = "/fetchAllWalletsByCountryCode";
    }

    public static interface PartnerControllerConst {

        public static final String ORIGINS =  "*";
        public static final String IMRH_PARTNER = "/imrh/partner";
        public static final String ATTACH_MTO_COUNTRY_WITH_MTO_PARTNER = "/attachMtoCountryWithMtoPartner";
        public static final String ATTACH_MTO_CITY_WITH_MTO_PARTNER = "/attachMtoCityWithMtoPartner";
        public static final String ATTACH_MTO_WALLET_WITH_MTO_PARTNER = "/attachMtoWalletWithMtoPartner";
        public static final String ATTACH_MTO_BANK_WITH_MTO_PARTNER = "/attachMtoBankWithMtoPartner";
        public static final String ATTACH_MTO_PARTNER_COUNTRY_PRODUCT = "/attachMtoPartnerCountryProduct";
        public static final String ENABLE_DISABLE_MTO_PARTNER = "/enableDisableMtoPartner";
        public static final String ENABLE_DISABLE_ALL_MTO_PARTNER = "/enableDisableAllMtoPartner";
        public static final String FETCH_ALL_MTO_PARTNER = "/fetchAllMtoPartner";
        public static final String FIND_BY_MTO_PARTNER_ID = "/findByMtoPartnerId";
        public static final String FIND_MTO_COUNTRY_BY_MTO_PARTNER_ID = "/findMtoCountryByMtoPartnerId";
        public static final String FIND_MTO_CITY_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "/findMtoCityByMtoPartnerIdAndMtoCountryCode";
        public static final String FIND_PRODUCT_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "/findProductByMtoPartnerIdAndMtoCountryCode";
        public static final String FIND_MTO_WALLET_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "/findMtoWalletByMtoPartnerIdAndMtoCountryCode";
        public static final String FIND_MTO_BANK_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "/findMtoBankByMtoPartnerIdAndMtoCountryCode";
        public static final String UPDATE_MTO_PARTNER = "/updateMtoPartner";
        public static final String UPDATE_PREFERENCE_ORDER_FOR_MTO_PARTNER = "/updatePreferenceOrderForMtoPartner";
        public static final String DELETE_MTO_PARTNER = "/deleteMtoPartner";
        public static final String DELETE_MTO_COUNTRY_LINK_MTO_PARTNER = "/deleteMtoCountryLinkMtoPartner";
        public static final String DELETE_MTO_CITY_LINK_MTO_PARTNER = "/deleteMtoCityLinkMtoPartner";
        public static final String DELETE_MTO_WALLET_LINK_MTO_PARTNER = "/deleteMtoWalletLinkMtoPartner";
        public static final String DELETE_MTO_BANK_LINK_MTO_PARTNER = "/deleteMtoBankLinkMtoPartner";
        public static final String DELETE_MTO_PARTNER_COUNTRY_PRODUCT= "/deleteMtoPartnerCountryProduct";
    }

    public static interface PartnerCustomerControllerConst {

        public static final String ORIGINS = "*";
        public static final String IMRH_PARTNER_CUSTOMER = "/imrh/partnerCustomer";
        public static final String SEARCH_CUSTOMER_MSISDN = "/searchCustomerMsisdn";
        public static final String FETCH_CUSTOMER_MSISDN = "/fetchCustomerMsisdn";
        public static final String CREATE_CUSTOMER_MSISDN = "/createCustomerMsisdn";
        public static final String UPDATE_PARTNER_CUSTOMER_MSISDN = "/updatePartnerCustomerMsisdn";
        public static final String DELETE_PARTNER_CUSTOMER_MSISDN = "/deletePartnerCustomerMsisdn";
        public static final String DOWNLOAD_MTO_PARTNER_CUSTOMER = "/downloadMtoPartnerCustomer";
        public static final String UPLOAD_MTO_PARTNER_CUSTOMER = "/uploadMtoPartnerCustomer";
    }

    public static interface ProductControllerConst {

        public static final String ORIGINS = "*";
        public static final String IMRH_PRODUCT = "/imrh/product";
        public static final String FIND_BY_PRODUCT_ID = "/findByProductId";
        public static final String UPDATE_PRODUCT = "/updateProduct";
        public static final String ENABLE_DISABLE_PRODUCT = "/enableDisableProduct";
        public static final String ENABLE_DISABLE_ALL_PRODUCT = "/enableDisableAllProduct";
        public static final String FETCH_ALL_PRODUCT = "/fetchAllProduct";
    }

    public static interface ResourceControllerConst {

        public static final String ORIGINS = "*";
        public static final String IMRH_RESOURCE = "/imrh/resource";
        public static final String UPLOAD_FILE = "/uploadFile";
        public static final String DOWNLOAD_IMAGE_FILE_NAME = "/download/image/file-name";
        public static final String DELETE_IMAGE_FILE_NAME = "/delete/image/file-name";
        public static final String DOWNLOAD_FILE_XLSX_FILE_NAME = "/downloadFileXlsx/file-name";
        public static final String DOWNLOAD_FILE_PDF_FILE_NAME = "/downloadFilePdf/file-name";
        public static final String DOWNLOAD_JASPER_FILE_FILE_NAME = "/downloadJasperFile/file-name";
    }

    public static interface CompanyControllerConst {
        public static final String ORIGINS = "*";
        public static final String IMRH_COMPANY = "/imrh/company";
        public static final String CREATE_COMPANY = "/createCompany";
        public static final String UPDATE_COMPANY_DETAIL = "/updateCompanyDetail";
        public static final String CLOSE_COMPANY_DETAIL = "closeCompany";
    }

    public static interface WalletControllerConst {

        public static final String ORIGINS = "*";
        public static final String IMRH_WALLET = "/imrh/wallet";
        public static final String CREATE_WALLET = "/createWallet";
        public static final String ENABLE_DISABLE_WALLET = "/enableDisableWallet";
        public static final String ENABLE_DISABLE_ALL_WALLET_BY_COUNTRY_CODE = "/enableDisableAllWalletByCountryCode";
        public static final String FIND_BY_WALLET_ID = "/findByWalletId";
        public static final String UPDATE_WALLET = "/updateWallet";
        public static final String DELETE_WALLET = "/deleteWallet";
    }

    public static interface WalletRepositoryConst {
        public static final String SET_ALL_WALLET_STATUS_BY_COUNTRY_CODE = "UPDATE WALLET SET ENABLED = ?1 WHERE COUNTRY_CODE = ?2 ";
    }

    public static interface ProductRepositoryConst {
        public static final String FIND_ALL_PRODUCT = "SELECT PRODUCT_ID AS productId, PRODUCT_NAME AS productName,\n"
                + "PRODUCT_IMAGE_URl AS productImageUrl, ENABLED AS enabled FROM PRODUCT";
        public static final String SET_ALL_PRODUCT_STATUS = "UPDATE Product product SET product.enabled = ?1";
    }

    public static interface PartnerRepositoryConst {
        public static final String ATTACH_MTO_COUNTRY_WITH_MTO_PARTNER = "INSERT INTO partner_country(partner_id, country_code) VALUES (?1, ?2)";
        public static final String SET_ALL_PARTNER_STATUS = "UPDATE Partner SET ENABLED = ?1";
        public static final String FIND_ALL_PARTNER = "SELECT partner_id AS partnerId, partner_name AS partnerName, enabled FROM partner";
        public static final String IS_ATTACH_MTO_COUNTRY_WITH_MTO_PARTNER = "SELECT CASE WHEN COUNT(partner_country) > 0 THEN true " +
              "ELSE false END FROM partner_country WHERE partner_id = ?1 and country_code = ?2";
        public static final String DELETE_PARTNER_COUNTRY_BY_PARTNER_ID = "DELETE FROM partner_country WHERE partner_id = ?1";
        public static final String DELETE_PARTNER_COUNTRY_BY_COUNTRY_CODE= "DELETE FROM partner_country WHERE country_code = ?1";
        public static final String DELETE_PARTNER_COUNTRY_BY_PARTNER_ID_AND_COUNTRY_CODE = "DELETE FROM partner_country WHERE partner_id = ?1 AND country_code = ?2";
        public static final String DELETE_PARTNER_CITY_BY_PARTNER_ID_AND_COUNTRY_CODE = "DELETE FROM partner_city\n" +
            "WHERE partner_city.partner_id = ?1 AND partner_city.city_id IN (SELECT partner_city.city_id AS cityId FROM partner\n" +
            "INNER JOIN partner_city ON partner_city.partner_id = partner.partner_id INNER JOIN city ON city.city_id = partner_city.city_id\n" +
            "INNER JOIN country ON country.country_code = city.country_code WHERE partner.partner_id = ?1 AND country.country_code = ?2)";
        public static final String DELETE_PARTNER_BANK_BY_PARTNER_ID_AND_COUNTRY_CODE = "DELETE FROM partner_bank\n" +
            "WHERE partner_bank.partner_id = ?1 AND partner_bank.bank_id IN(SELECT partner_bank.bank_id FROM partner\n" +
            "INNER JOIN partner_bank ON partner_bank.partner_id = partner.partner_id INNER JOIN bank ON bank.bank_id = partner_bank.bank_id\n" +
            "INNER JOIN country ON country.country_code = bank.country_code WHERE partner.partner_id = ?1 AND country.country_code = ?2)";
        public static final String DELETE_PARTNER_WALLET_BY_PARTNER_ID_AND_COUNTRY_CODE = "DELETE FROM partner_wallet\n" +
            "WHERE partner_wallet.partner_id = ?1 AND partner_wallet.wallet_id IN(SELECT partner_wallet.wallet_id FROM partner\n" +
            "INNER JOIN partner_wallet ON partner_wallet.partner_id = partner.partner_id INNER JOIN wallet ON wallet.wallet_id = partner_wallet.wallet_id\n" +
            "INNER JOIN country ON country.country_code = wallet.country_code WHERE partner.partner_id = ?1 AND country.country_code = ?2)";
        public static final String FIND_MOT_CITY_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName," +
            "partner.partner_image_url AS partnerImageUrl, country.country_code AS countryCode, country.country_name AS countryName," +
            "country.country_image_url AS countryImageUrl, country.enabled AS countryEnabled, city.city_id AS cityId, city.city_name AS cityName, city.enabled AS cityEnabled FROM partner\n" +
            "INNER JOIN partner_city ON partner_city.partner_id = partner.partner_id INNER JOIN city ON city.city_id = partner_city.city_id\n" +
            "INNER JOIN country ON country.country_code = city.country_code WHERE partner.partner_id = ?1 AND country.country_code = ?2";
        public static final String FIND_MTO_WALLET_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName," +
            "partner.partner_image_url AS partnerImageUrl, country.country_code AS countryCode, country.country_name AS countryName," +
            "country.country_image_url AS countryImageUrl, country.enabled AS countryEnabled, wallet.wallet_id AS walletId, wallet.wallet_name AS walletName, wallet.wallet_image_url AS walletImageUrl, " +
            "wallet.enabled AS walletEnabled FROM partner INNER JOIN partner_wallet ON partner_wallet.partner_id = partner.partner_id\n" +
            "INNER JOIN wallet ON wallet.wallet_id = partner_wallet.wallet_id INNER JOIN country ON country.country_code = wallet.country_code\n" +
            "WHERE partner.partner_id = ?1 AND country.country_code = ?2";
        public static final String FIND_MTO_BANK_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, " +
            "partner.partner_image_url AS partnerImageUrl, country.country_code AS countryCode, country.country_name AS countryName, " +
            "country.country_image_url AS countryImageUrl, country.enabled AS countryEnabled, bank.bank_id AS bankId, bank.bank_name AS bankName, bank.bank_image_url AS bankImageUrl, " +
            "bank.enabled AS bankEnabled FROM partner INNER JOIN partner_bank ON partner_bank.partner_id = partner.partner_id\n" +
            "INNER JOIN bank ON bank.bank_id = partner_bank.bank_id INNER JOIN country ON country.country_code = bank.country_code\n" +
            "WHERE partner.partner_id = ?1 AND country.country_code = ?2";
        public static final String ATTACH_MTO_CITY_WITH_PARTNER = "INSERT INTO partner_city(partner_id, city_id) VALUES (?1, ?2)";
        public static final String IS_ATTACH_MTO_CITY_WITH_MTO_PARTNER = "SELECT CASE WHEN COUNT(partner_city) > 0 THEN true ELSE false END FROM partner_city WHERE partner_id = ?1 and city_id = ?2";
        public static final String DELETE_PARTNER_CITY_BY_CITY_ID = "DELETE FROM partner_city WHERE city_id = ?1";
        public static final String DELETE_PARTNER_CITY_BY_PARTNER_ID_AND_CITY_ID = "DELETE FROM partner_city WHERE partner_id = ?1 AND city_id = ?2";
        public static final String DELETE_PARTNER_CITY_BY_PARTNER_ID = "DELETE FROM partner_city WHERE partner_id = ?1";
        public static final String ATTACH_MTO_WALLET_WITH_MTO_PARTNER = "INSERT INTO partner_wallet(partner_id, wallet_id) VALUES (?1, ?2)";
        public static final String IS_ATTACH_MTO_WALLET_WITH_MTO_PARTNER = "SELECT CASE WHEN COUNT(partner_wallet) > 0 THEN true ELSE false END " +
            "FROM partner_wallet WHERE partner_id = ?1 and wallet_id = ?2";
        public static final String DELETE_PARTNER_WALLET_BY_WALLET_ID = "DELETE FROM partner_wallet WHERE wallet_id = ?1";
        public static final String DELETE_PARTNER_WALLET_BY_PARTNER_ID_AND_WALLET_ID = "DELETE FROM partner_wallet WHERE partner_id = ?1 AND wallet_id = ?2";
        public static final String DELETE_PARTNER_WALLET_BY_PARTNER_ID = "DELETE FROM partner_wallet WHERE partner_id = ?1";
        public static final String ATTACH_MTO_BANK_WITH_MTO_PARTNER = "INSERT INTO partner_bank(partner_id, bank_id) VALUES (?1, ?2)";
        public static final String IS_ATTACH_MTO_BANK_WITH_MTO_PARTNER = "SELECT CASE WHEN COUNT(partner_bank) > 0 THEN true ELSE false END " +
            "FROM partner_bank WHERE partner_id = ?1 and bank_id = ?2";
        public static final String DELETE_PARTNER_BANK_BY_BANK_ID = "DELETE FROM partner_bank WHERE bank_id = ?1";
        public static final String DELETE_PARTNER_BANK_BY_PARTNER_ID_AND_BANK_ID = "DELETE FROM partner_bank WHERE partner_id = ?1 AND bank_id = ?2";
        public static final String DELETE_PARTNER_BANK_BY_PARTNER_ID = "DELETE FROM partner_bank WHERE partner_id = ?1";
    }

    public interface  PartnerCustomerRepositoryConst {
        public static final String UPDATE_PARTNER_CUSTOMER_MSISDN = "UPDATE partner_customer SET PARTNER_ID = ?1 where CUSTOMER_ID = ?2";
        public static final String DELETE_PARTNER_COUNTRY_BY_COUNTRY_CODE = "DELETE FROM partner_customer WHERE CUSTOMER_ID = ?1";
        public static final String FETCH_ALL_CUSTOMER_DETAIL = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName," +
            "partner.partner_image_url AS partnerImageUrl, partner_customer.customer_id as customerId, partner_customer.customer_number AS partnerCustomer " +
            "FROM partner_customer INNER JOIN partner ON partner.partner_id = partner_customer.partner_id\n" +
            "WHERE partner_customer.customer_number = ?1";
        public static final String FETCH_ALL_CUSTOMER_DETAIL_WITH_PAGE = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName," +
            "partner.partner_image_url AS partnerImageUrl, partner_customer.customer_id as customerId," +
            "partner_customer.customer_number AS partnerCustomer FROM partner_customer\n" +
            "INNER JOIN partner ON partner.partner_id = partner_customer.partner_id ORDER BY partner_customer.customer_id ";
        public static final String FETCH_ALL_CUSTOMER_DETAIL_WITH_PAGE_COUNT = "SELECT COUNT(*) FROM partner_customer " +
            "INNER JOIN partner ON partner.partner_id = partner_customer.partner_id";
        public static final String FETCH_ALL_CUSTOMER_DETAIL_V1 = "SELECT partner.partner_id AS partnerId, partner.partner_name AS partnerName, " +
            "partner_customer.customer_number AS partnerCustomer FROM partner_customer INNER JOIN partner ON partner.partner_id = partner_customer.partner_id";
        public static final String TRUNCATE_PARTNER_CUSTOMER = "TRUNCATE TABLE partner_customer";
    }

    public interface PartnerCountryProductRepositoryConst {
        public static final String IS_ATTACH_MTO_PARTNER_COUNTRY_PRODUCT = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END " +
            "FROM partner_country_product WHERE partner_id = ?1 and product_id = ?2 and country_code = ?3";
        public static final String FIND_PRODUCT_BY_MTO_PARTNER_ID_AND_MTO_COUNTRY_CODE = "SELECT partner.partner_id AS partnerId, " +
            "partner.partner_name AS partnerName, partner.partner_image_url as partnerImageUrl country.country_code AS countryCode, " +
            "country.country_name AS countryName, country.country_image_url AS countryImageUrl, country.enabled AS countryEnabled, " +
            "product.product_id, product.product_name, product.product_image_url as productImageUrl," +
            "product.enabled from partner_country_product INNER JOIN country ON country.country_code = partner_country_product.country_code\n" +
            "INNER JOIN partner ON partner.partner_id = partner_country_product.partner_id INNER JOIN product ON product.product_id = partner_country_product.product_id\n" +
            "WHERE partner.partner_id = ?1 AND country.country_code = ?2";
        public static final String DELETE_MTO_PARTNER_COUNTRY_PRODUCT_BY_PARTNER_ID_AND_COUNTRY_CODE = "DELETE FROM partner_country_product WHERE partner_id = ?1 AND country_code = ?2";
        public static final String DELETE_MTO_PARTNER_COUNTRY_PRODUCT_BY_PARTNER_ID_AND_PRODUCT_ID_AND_COUNTRY_CODE = "DELETE FROM partner_country_product WHERE partner_id = ?1 " +
            "AND product_id = ?2 AND country_code = ?3";
    }

    public interface CountryRepositoryConst {
        public static final String FIND_ALL_COUNTRY = "SELECT COUNTRY_CODE AS countryCode, COUNTRY_NAME AS countryName," +
            "COUNTRY_IMAGE_URl AS countryImageUrl, COUNTRY_LEGACY_CODE AS countryLegacyCode, ENABLED AS enabled " +
            "FROM COUNTRY ORDER BY COUNTRY_NAME ASC";
        public static final String SET_ALL_COUNTRY_STATUS = "UPDATE Country country SET country.enabled = ?1";
    }

    public interface CityRepositoryConst {
        public static final String SET_ALL_CITY_STATUS_BY_COUNTRY_CODE = "UPDATE CITY SET ENABLED = ?1 WHERE COUNTRY_CODE = ?2 ";
    }

    public interface BankRepositoryConst {
        public static final String SET_ALL_BANK_STATUS_BY_COUNTRY_CODE = "UPDATE BANK SET ENABLED = ?1 WHERE COUNTRY_CODE = ?2 ";
    }

}
