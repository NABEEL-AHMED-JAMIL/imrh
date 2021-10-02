package com.etisalat.imrh.repository.query;

import com.etisalat.imrh.dto.PartnerDto;
import com.etisalat.imrh.util.CommonUtils;
import java.util.Iterator;
import java.util.List;

public class EntityQuery {

    //update partner set preference_order = (case when partner_id = 1000 then 2 when partner_id = 1001 then 3 when partner_id = 1002 then 1 end) where partner_id in (1000, 1001, 1002);
    public static String changePreferenceOrder(List<PartnerDto> partnerOrder) {
        StringBuilder changePreferenceOrder = new StringBuilder();
        changePreferenceOrder.append("UPDATE PARTNER SET PERFERENCE_ORDER = (CASE");
        StringBuilder changePreferenceInDetail = new StringBuilder();
        Iterator<PartnerDto> partnerPreferenceIterator = partnerOrder.iterator();
        while (partnerPreferenceIterator.hasNext()) {
            PartnerDto partnerDto = partnerPreferenceIterator.next();
            if (!CommonUtils.isNull(partnerDto.getPartnerId()) && !CommonUtils.isNull(partnerDto.getPreferenceOrder()) ) {
                changePreferenceOrder.append(String.format(" WHEN PARTNER_ID = %d THEN %d", partnerDto.getPartnerId(), partnerDto.getPreferenceOrder()));
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

}
