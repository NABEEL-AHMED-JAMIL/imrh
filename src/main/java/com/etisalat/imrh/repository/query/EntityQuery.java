package com.etisalat.imrh.repository.query;

import com.etisalat.imrh.dto.PartnerDto;
import com.etisalat.imrh.util.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Service
public class EntityQuery {

    public Logger logger = LogManager.getLogger(EntityQuery.class);

    @PersistenceContext
    private EntityManager entityManager;

    //update partner set preference_order = (case when partner_id = 1000 then 2
    // when partner_id = 1001 then 3 when partner_id = 1002 then 1 end) where partner_id in (1000, 1001, 1002);
    public static String changePreferenceOrder(List<PartnerDto> partnerOrder) {
        StringBuilder changePreferenceOrder = new StringBuilder();
        changePreferenceOrder.append("UPDATE PARTNER SET PERFERENCE_ORDER = (CASE");
        StringBuilder changePreferenceInDetail = new StringBuilder();
        Iterator<PartnerDto> partnerPreferenceIterator = partnerOrder.iterator();
        while (partnerPreferenceIterator.hasNext()) {
            PartnerDto partnerDto = partnerPreferenceIterator.next();
            if (!CommonUtils.isNull(partnerDto.getPartnerId()) && !CommonUtils.isNull(partnerDto.getPreferenceOrder()) ) {
                changePreferenceOrder.append(String.format(" WHEN PARTNER_ID = %d THEN %d",
                    partnerDto.getPartnerId(), partnerDto.getPreferenceOrder()));
                if (partnerPreferenceIterator.hasNext()) {
                    changePreferenceInDetail.append(String.format("%d, ", partnerDto.getPartnerId()));
                } else {
                    changePreferenceInDetail.append(String.format("%d)", partnerDto.getPartnerId()));
                }
            }
        }
        changePreferenceOrder.append(" END) WHERE PARTNER_ID IN (");
        changePreferenceOrder.append(changePreferenceInDetail);
        return changePreferenceOrder.toString();
    }

    public int executeUpdateQuery(String queryString) {
        logger.info("Transaction Start for %s ", queryString);
        this.entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(queryString);
        int rowsUpdated = query.executeUpdate();
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        logger.info("Transaction End with update rows %d ", rowsUpdated);
        return rowsUpdated;
    }

}
