package com.etisalat.imrh.repository.query;

import com.etisalat.imrh.dto.PartnerDto;
import com.etisalat.imrh.repository.view.*;
import com.etisalat.imrh.util.CommonUtils;
import com.etisalat.imrh.repository.validate.MtoPartnerCustomerValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

/**
 * @author Nabeel Ahmed
 */
@Service
@Transactional
public class EntityQuery {

    public Logger logger = LogManager.getLogger(EntityQuery.class);

    @PersistenceContext
    private EntityManager entityManager;

    public static String changePreferenceOrderQuery(List<PartnerDto> partnerOrder) {
        StringBuilder changePreferenceOrder = new StringBuilder();
        changePreferenceOrder.append("UPDATE partner SET preference_order = (CASE");
        StringBuilder changePreferenceInDetail = new StringBuilder();
        Iterator<PartnerDto> partnerPreferenceIterator = partnerOrder.iterator();
        while (partnerPreferenceIterator.hasNext()) {
            PartnerDto partnerDto = partnerPreferenceIterator.next();
            if (!CommonUtils.isNull(partnerDto.getPartnerId()) && !CommonUtils.isNull(partnerDto.getPreferenceOrder()) ) {
                changePreferenceOrder.append(String.format(" WHEN partner_id = %d THEN %d",
                    partnerDto.getPartnerId(), partnerDto.getPreferenceOrder()));
                if (partnerPreferenceIterator.hasNext()) {
                    changePreferenceInDetail.append(String.format("%d, ", partnerDto.getPartnerId()));
                } else {
                    changePreferenceInDetail.append(String.format("%d)", partnerDto.getPartnerId()));
                }
            }
        }
        changePreferenceOrder.append(" END) WHERE partner_id IN (");
        changePreferenceOrder.append(changePreferenceInDetail);
        return changePreferenceOrder.toString();
    }

    public static String mtoPartnerCountryQuery(Set<MtoPartnerCustomerValidation> mtoPartnerCustomerValidations) {
        StringBuilder mtoPartnerCountry = new StringBuilder("INSERT INTO partner_customer(customer_id,customer_number,partner_id) VALUES ");
        Iterator<MtoPartnerCustomerValidation> partnerCustomerValidationIterator = mtoPartnerCustomerValidations.iterator();
        while (partnerCustomerValidationIterator.hasNext()) {
            MtoPartnerCustomerValidation mtoPartnerCustomerValidation = partnerCustomerValidationIterator.next();
            if (partnerCustomerValidationIterator.hasNext()) {
                mtoPartnerCountry.append(String.format("(nextval('partner_customer_seq'), '%s', %d),",
                    mtoPartnerCustomerValidation.getCustomerNumber(), mtoPartnerCustomerValidation.getPartnerId()));
            } else {
                mtoPartnerCountry.append(String.format("(nextval('partner_customer_seq'), '%s', %d)",
                    mtoPartnerCustomerValidation.getCustomerNumber(), mtoPartnerCustomerValidation.getPartnerId()));
            }
        }
        return mtoPartnerCountry.toString();
    }

    public int executeUpdateQuery(String queryString) {
        logger.info("Transaction Start for " + queryString);
        Query query = this.entityManager.createNativeQuery(queryString);
        int rowsUpdated = query.executeUpdate();
        logger.info("Transaction End with update rows " + rowsUpdated);
        return rowsUpdated;
    }

    public int executeInsertQuery(String queryString) {
        logger.info("Transaction Start for " + queryString);
        Query query = this.entityManager.createNativeQuery(queryString);
        int rowsUpdated = query.executeUpdate();
        logger.info("Transaction End with update rows " + rowsUpdated);
        return rowsUpdated;
    }

    public List executeQuery(String queryStr, Class<?> entityType) {
        logger.info("Execute Query :- " + queryStr);
        Query query = this.entityManager.createNativeQuery(queryStr);
        List<Object[]> list = query.getResultList();
        List result = null;
        if (entityType.isAssignableFrom(FetchAllGlobalCountryDetailForReportView.class)) {
            result = new ArrayList<FetchAllGlobalCountryDetailForReportView>();
            for (Object[] object: list) {
                FetchAllGlobalCountryDetailForReportView fetchAllGlobalCountryDetailForReportView = new FetchAllGlobalCountryDetailForReportView();
                if (object[0] != null) {
                    fetchAllGlobalCountryDetailForReportView.setCountryName(String.valueOf(object[0]));
                }
                if (object[1] != null) {
                    fetchAllGlobalCountryDetailForReportView.setCountryCode(String.valueOf(object[1]));
                }
                if (object[2] != null) {
                    fetchAllGlobalCountryDetailForReportView.setCountryStatus(String.valueOf(object[2]));
                }
                if (object[3] != null) {
                    fetchAllGlobalCountryDetailForReportView.setCountryImageUrl(String.valueOf(object[3]));
                }
                if (object[4] != null) {
                    fetchAllGlobalCountryDetailForReportView.setTotalCity(Long.valueOf(String.valueOf(object[4])));
                }
                if (object[5] != null) {
                    fetchAllGlobalCountryDetailForReportView.setTotalWallet(Long.valueOf(String.valueOf(object[5])));
                }
                if (object[6] != null) {
                    fetchAllGlobalCountryDetailForReportView.setTotalBank(Long.valueOf(String.valueOf(object[6])));
                }
                result.add(fetchAllGlobalCountryDetailForReportView);
            }
        } else if (entityType.isAssignableFrom(FetchMtoPartnerCountryView.class)) {
            result = new ArrayList<FetchMtoPartnerCountryView>();
            for (Object[] object: list) {
                FetchMtoPartnerCountryView fetchMtoPartnerCountryView = new FetchMtoPartnerCountryView();
                if (object[0] != null) {
                    fetchMtoPartnerCountryView.setPartnerId(Long.valueOf(String.valueOf(object[0])));
                }
                if (object[1] != null) {
                    fetchMtoPartnerCountryView.setPartnerName(String.valueOf(object[1]));
                }
                if (object[2] != null) {
                    fetchMtoPartnerCountryView.setCountryName(String.valueOf(object[2]));
                }
                result.add(fetchMtoPartnerCountryView);
            }
        } else if (entityType.isAssignableFrom(FetchMtoPartnerCountryBankView.class)) {
            result = new ArrayList<FetchMtoPartnerCountryBankView>();
            for (Object[] object: list) {
                FetchMtoPartnerCountryBankView fetchMtoPartnerCountryBankView = new FetchMtoPartnerCountryBankView();
                if (object[0] != null) {
                    fetchMtoPartnerCountryBankView.setPartnerId(Long.valueOf(String.valueOf(object[0])));
                }
                if (object[1] != null) {
                    fetchMtoPartnerCountryBankView.setPartnerName(String.valueOf(object[1]));
                }
                if (object[2] != null) {
                    fetchMtoPartnerCountryBankView.setPartnerImageUrl(String.valueOf(object[2]));
                }
                if (object[3] != null) {
                    fetchMtoPartnerCountryBankView.setCountryCode(String.valueOf(object[3]));
                }
                if (object[4] != null) {
                    fetchMtoPartnerCountryBankView.setCountryName(String.valueOf(object[4]));
                }
                if (object[5] != null) {
                    fetchMtoPartnerCountryBankView.setCountryImageUrl(String.valueOf(object[5]));
                }
                if (object[6] != null) {
                    fetchMtoPartnerCountryBankView.setBankId(Long.valueOf(String.valueOf(object[6])));
                }
                if (object[7] != null) {
                    fetchMtoPartnerCountryBankView.setBankName(String.valueOf(object[7]));
                }
                if (object[8] != null) {
                    fetchMtoPartnerCountryBankView.setBankImageUrl(String.valueOf(object[8]));
                }
                if (object[9] != null) {
                    fetchMtoPartnerCountryBankView.setBankEnabled(String.valueOf(object[9]));
                }
                result.add(fetchMtoPartnerCountryBankView);
            }
        } else if (entityType.isAssignableFrom(FetchMtoPartnerCountryCityView.class)) {
            result = new ArrayList<FetchMtoPartnerCountryCityView>();
            for (Object[] object: list) {
                FetchMtoPartnerCountryCityView fetchMtoPartnerCountryCityView = new FetchMtoPartnerCountryCityView();
                if (object[0] != null) {
                    fetchMtoPartnerCountryCityView.setPartnerId(Long.valueOf(String.valueOf(object[0])));
                }
                if (object[1] != null) {
                    fetchMtoPartnerCountryCityView.setPartnerName(String.valueOf(object[1]));
                }
                if (object[2] != null) {
                    fetchMtoPartnerCountryCityView.setPartnerImageUrl(String.valueOf(object[2]));
                }
                if (object[3] != null) {
                    fetchMtoPartnerCountryCityView.setCountryCode(String.valueOf(object[3]));
                }
                if (object[4] != null) {
                    fetchMtoPartnerCountryCityView.setCountryName(String.valueOf(object[4]));
                }
                if (object[5] != null) {
                    fetchMtoPartnerCountryCityView.setCountryImageUrl(String.valueOf(object[5]));
                }
                if (object[6] != null) {
                    fetchMtoPartnerCountryCityView.setCityId(Long.valueOf(String.valueOf(object[6])));
                }
                if (object[7] != null) {
                    fetchMtoPartnerCountryCityView.setCityName(String.valueOf(object[7]));
                }
                if (object[8] != null) {
                    fetchMtoPartnerCountryCityView.setCityEnabled(String.valueOf(object[8]));
                }
                result.add(fetchMtoPartnerCountryCityView);
            }
        } else if (entityType.isAssignableFrom(FetchMtoPartnerCountryWalletView.class)) {
            result = new ArrayList<FetchMtoPartnerCountryWalletView>();
            for (Object[] object: list) {
                FetchMtoPartnerCountryWalletView fetchMtoPartnerCountryWalletView = new FetchMtoPartnerCountryWalletView();
                if (object[0] != null) {
                    fetchMtoPartnerCountryWalletView.setPartnerId(Long.valueOf(String.valueOf(object[0])));
                }
                if (object[1] != null) {
                    fetchMtoPartnerCountryWalletView.setPartnerName(String.valueOf(object[1]));
                }
                if (object[2] != null) {
                    fetchMtoPartnerCountryWalletView.setPartnerImageUrl(String.valueOf(object[2]));
                }
                if (object[3] != null) {
                    fetchMtoPartnerCountryWalletView.setCountryCode(String.valueOf(object[3]));
                }
                if (object[4] != null) {
                    fetchMtoPartnerCountryWalletView.setCountryName(String.valueOf(object[4]));
                }
                if (object[5] != null) {
                    fetchMtoPartnerCountryWalletView.setCountryImageUrl(String.valueOf(object[5]));
                }
                if (object[6] != null) {
                    fetchMtoPartnerCountryWalletView.setWalletId(Long.valueOf(String.valueOf(object[6])));
                }
                if (object[7] != null) {
                    fetchMtoPartnerCountryWalletView.setWalletName(String.valueOf(object[7]));
                }
                if (object[8] != null) {
                    fetchMtoPartnerCountryWalletView.setWalletImageUrl(String.valueOf(object[8]));
                }
                if (object[9] != null) {
                    fetchMtoPartnerCountryWalletView.setWalletEnabled(String.valueOf(object[9]));
                }
                result.add(fetchMtoPartnerCountryWalletView);
            }
        }
        return result;
    }

    /**
     * public static void main(String[] args) {
     *     List<PartnerDto> partnerOrder = Arrays.asList(new PartnerDto(1000L, 1),
     *       new PartnerDto(1002L, 1), new PartnerDto(1003L, 3));
     *     System.out.println(changePreferenceOrderQuery(partnerOrder));
     *     List<MtoPartnerCustomerValidation> mtoPartnerCustomerValidations = Arrays.asList(new MtoPartnerCustomerValidation(1000L, "03153817177"),
     *       new MtoPartnerCustomerValidation(1002L, "03153817177"), new MtoPartnerCustomerValidation(1003L, "03153817177"));
     *     System.out.println(mtoPartnerCountryQuery(mtoPartnerCustomerValidations));
     * }
     * */
}