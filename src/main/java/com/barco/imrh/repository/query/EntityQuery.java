package com.barco.imrh.repository.query;

import com.barco.imrh.repository.view.*;
import com.barco.imrh.dto.PartnerDto;
import com.barco.imrh.util.CommonUtils;
import com.barco.imrh.repository.validate.MtoPartnerCustomerValidation;
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
                int dataCounter = 0;
                FetchAllGlobalCountryDetailForReportView fetchAllGlobalCountryDetailForReportView = new FetchAllGlobalCountryDetailForReportView();
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchAllGlobalCountryDetailForReportView.setCountryName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchAllGlobalCountryDetailForReportView.setCountryCode(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchAllGlobalCountryDetailForReportView.setCountryStatus(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchAllGlobalCountryDetailForReportView.setCountryImageUrl(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchAllGlobalCountryDetailForReportView.setTotalCity(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchAllGlobalCountryDetailForReportView.setTotalWallet(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchAllGlobalCountryDetailForReportView.setTotalBank(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                result.add(fetchAllGlobalCountryDetailForReportView);
            }
        } else if (entityType.isAssignableFrom(FetchMtoPartnerCountryView.class)) {
            result = new ArrayList<FetchMtoPartnerCountryView>();
            for (Object[] object: list) {
                int dataCounter = 0;
                FetchMtoPartnerCountryView fetchMtoPartnerCountryView = new FetchMtoPartnerCountryView();
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryView.setPartnerId(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryView.setPartnerName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryView.setCountryName(String.valueOf(object[dataCounter]));
                }
                result.add(fetchMtoPartnerCountryView);
            }
        } else if (entityType.isAssignableFrom(FetchMtoPartnerCountryBankView.class)) {
            result = new ArrayList<FetchMtoPartnerCountryBankView>();
            for (Object[] object: list) {
                int dataCounter = 0;
                FetchMtoPartnerCountryBankView fetchMtoPartnerCountryBankView = new FetchMtoPartnerCountryBankView();
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setPartnerId(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setPartnerName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setPartnerImageUrl(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setCountryCode(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setCountryName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setCountryImageUrl(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setBankId(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setBankName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setBankImageUrl(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryBankView.setBankEnabled(String.valueOf(object[dataCounter]));
                }
                result.add(fetchMtoPartnerCountryBankView);
            }
        } else if (entityType.isAssignableFrom(FetchMtoPartnerCountryCityView.class)) {
            result = new ArrayList<FetchMtoPartnerCountryCityView>();
            for (Object[] object: list) {
                int dataCounter = 0;
                FetchMtoPartnerCountryCityView fetchMtoPartnerCountryCityView = new FetchMtoPartnerCountryCityView();
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryCityView.setPartnerId(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryCityView.setPartnerName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryCityView.setPartnerImageUrl(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryCityView.setCountryCode(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[4])) {
                    fetchMtoPartnerCountryCityView.setCountryName(String.valueOf(object[4]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryCityView.setCountryImageUrl(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryCityView.setCityId(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryCityView.setCityName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryCityView.setCityEnabled(String.valueOf(object[dataCounter]));
                }
                result.add(fetchMtoPartnerCountryCityView);
            }
        } else if (entityType.isAssignableFrom(FetchMtoPartnerCountryWalletView.class)) {
            result = new ArrayList<FetchMtoPartnerCountryWalletView>();
            for (Object[] object: list) {
                int dataCounter = 0;
                FetchMtoPartnerCountryWalletView fetchMtoPartnerCountryWalletView = new FetchMtoPartnerCountryWalletView();
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setPartnerId(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setPartnerName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setPartnerImageUrl(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setCountryCode(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setCountryName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setCountryImageUrl(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setWalletId(Long.valueOf(String.valueOf(object[dataCounter])));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setWalletName(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setWalletImageUrl(String.valueOf(object[dataCounter]));
                }
                dataCounter++;
                if (!CommonUtils.isNull(object[dataCounter])) {
                    fetchMtoPartnerCountryWalletView.setWalletEnabled(String.valueOf(object[dataCounter]));
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