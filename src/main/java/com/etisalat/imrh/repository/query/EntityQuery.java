package com.etisalat.imrh.repository.query;

import com.etisalat.imrh.dto.PartnerDto;
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